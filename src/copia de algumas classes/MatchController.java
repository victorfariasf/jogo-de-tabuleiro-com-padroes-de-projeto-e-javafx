import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

import java.util.ArrayList;

public class MatchController {
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private Fachada fachada;
    private int rodadaAtual = 1;
    private int jogadorAtual = 0;

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if ("match".equals(newScreen)) {
                    if (userData instanceof Fachada) {
                        try {
                            // Converte userData para o tipo Fachada
                            fachada = (Fachada) userData;
                            jogadores = fachada.returnPlayerList();

                            // Aqui você pode realizar as operações que necessita com o objeto fachada
                            // Exemplo: obtendo uma lista de jogadores da fachada
                        } catch (ClassCastException e) {
                            // Lida com a situação onde a conversão não é válida
                            System.err.println("Erro: userData não contém um objeto do tipo Fachada.");
                            e.printStackTrace();
                        }
                    } else {
                        // Lida com a situação onde userData não é uma instância de Fachada
                        System.err.println("Erro: userData não é uma instância de Fachada.");
                    }
                    System.out.println("Tamanho do array jogadores: " + jogadores.size());
                    for (Jogador x : jogadores) {

                    }
                    organizeLabels();
                    organizeUI();
                }

            }

        });

    }

    private void organizeLabels() {
        playerOne.setText("");
        playerTwo.setText("");
        playerThree.setText("");
        playerFour.setText("");
        playerFive.setText("");
        playerSix.setText("");

        for (int i = 0; i < jogadores.size(); i++) {
            switch (i) {
                case 0:
                    playerOne.setText(jogadores.get(i).toString());
                    break;
                case 1:
                    playerTwo.setText(jogadores.get(i).toString());
                    break;
                case 2:
                    playerThree.setText(jogadores.get(i).toString());
                    break;
                case 3:
                    playerFour.setText(jogadores.get(i).toString());
                    break;
                case 4:
                    playerFive.setText(jogadores.get(i).toString());
                    break;
                case 5:
                    playerSix.setText(jogadores.get(i).toString());
                    break;
                default:
                    break;
            }
        }

    }

    private void organizeUI() {
        currentMatchLabel.setText("Rodada atual: " + rodadaAtual);
        currentPlayerOrganize();
    }

    private void currentPlayerOrganize() {

        currentPlayerLabel.setText("Jogador atual: " + jogadores.get(jogadorAtual).toString());
        Image pawnColor = new Image("images/" + jogadores.get(jogadorAtual).getColor() + ".png");
        colorPieceImageView.setImage(pawnColor);
    }

    private void passTurn() {

        diceOne.setText("Dado 1");
        diceTwo.setText("Dado 2");
        dicesSumValue.setText("Soma dos dados");

        organizeLabels();

        jogadorAtual++;
        if (jogadorAtual >= jogadores.size()) {
            jogadorAtual = 0;
        }

        organizeUI();
    }

    @FXML
    private Label playerSix;

    @FXML
    private ImageView colorPieceImageView;

    @FXML
    private Label currentMatchLabel;

    @FXML
    private Label currentPlayerLabel;

    @FXML
    private Label diceOne;

    @FXML
    private Label diceTwo;

    @FXML
    private Label dicesSumValue;

    @FXML
    private Button passTheTurnBtn;

    @FXML
    private Button playBtn;

    @FXML
    private Label playerFive;

    @FXML
    private Label playerFour;

    @FXML
    private Label playerOne;

    @FXML
    private Label playerThree;

    @FXML
    private Label playerTwo;

    @FXML
    void passTheTurnOnAction(ActionEvent event) {
        passTurn();
    }

    @FXML
    void playOnAction(ActionEvent event) {
        int diceOneV = fachada.rolarDados();
        int diceTwoV = fachada.rolarDados();
        int diceSumV = diceOneV + diceTwoV;
        diceOne.setText("Dado 1 - " + diceOneV);
        diceTwo.setText("Dado 2 - " + diceTwoV);
        dicesSumValue.setText("Soma dos dados - " + (diceOneV + diceTwoV));

        PauseTransition delay = new PauseTransition(Duration.seconds(1));
        delay.setOnFinished(e -> {
            if (jogadores.get(jogadorAtual).jogadaValida(diceSumV) == false) {
                passTurn();
            } else {
                jogadores.get(jogadorAtual).andarNoJogo(diceSumV);
                passTurn();
            }

        });

        delay.play();

    }

}
