package JavaFx;

import java.util.ArrayList;
import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleGroup;
import javafx.stage.Stage;

public class ConfigurandoPecaController {

    private int jogadorAtual = 1;
    private int numeroDeJogadores;
    private Fachada fachada = new Fachada(getStage());

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("second")) {

                    campoNome.clear();
                    grupoCOr.selectToggle(null);

                    String nome = (String) userData;
                    String[] vect = nome.split(" ");
                    numeroDeJogadores = Integer.parseInt(vect[0]);
                    campoQuantidadeJogadores.setText(nome);
                    campoQuantidadeJogadores1.setText("Jogador " + jogadorAtual);
                    System.out.println("nova tela: " + newScreen + " ," + userData);
                }

            }

        });
    }

    public Stage getStage() {
        return Main.getStage();
    }

    @FXML
    private RadioButton amarelo;

    @FXML
    private RadioButton azul;

    @FXML
    private Button btnContinuar;

    @FXML
    private TextField campoNome;

    @FXML
    private Label campoQuantidadeJogadores;

    @FXML
    private Label campoQuantidadeJogadores1;

    @FXML
    private ToggleGroup grupoCOr;

    @FXML
    private RadioButton preto;

    @FXML
    private RadioButton roxo;

    @FXML
    private RadioButton verde;

    private ArrayList<String> jogadores = new ArrayList<>();

    private ArrayList<Jogador> jogadoresObj = new ArrayList<>();

    @FXML
    void onActionBtn(ActionEvent event) {

        System.out.println(jogadorAtual);
        System.out.println(numeroDeJogadores);

        String nome = campoNome.getText();
        RadioButton selectedRadioButton = (RadioButton) grupoCOr.getSelectedToggle();
        String cor = selectedRadioButton.getText();
        fachada.criarJogador(nome, cor);
        // fachada.criarJogadores(nome, cor);

        jogadorAtual++;
        if (jogadorAtual <= numeroDeJogadores) {
            campoQuantidadeJogadores1.setText("Jogador " + jogadorAtual);
            campoNome.setText("");
            grupoCOr.selectToggle(null);
            selectedRadioButton.setDisable(true);
        } else {
            fachada.quantidaDeJogadores();
            fachada.buscarJogadores();
            Main.changeScreen("partida", fachada);
        }

    }

    @FXML
    void onActionCancelar(ActionEvent event) {
        campoNome.setText("");

        for (Toggle x : grupoCOr.getToggles()) {
            RadioButton rb = (RadioButton) x;
            rb.setDisable(false);
            rb.setSelected(false);
        }
        jogadorAtual = 1;
        Main.changeScreen("main");
    }

}
