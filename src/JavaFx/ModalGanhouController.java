package JavaFx;

import java.util.ArrayList;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;;

public class ModalGanhouController {
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();
    @FXML
    private Label ganhouLabel;

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/trofeu.png"));
    ArrayList<Jogador> x;

    @FXML
    public void initialize(ArrayList<Jogador> x) {
        System.out.println("inicializou");

        // atualizarTela(x);
        som();
    }

    public void setJogadores(ArrayList<Jogador> x, Jogador ganhador) {
        this.x = x;
        atualizarTela(x, ganhador);
        som();
        imageView.setImage(image);
    }

    @FXML
    private Label jogador1;

    @FXML
    private Label jogador2;

    @FXML
    private Label jogador3;

    @FXML
    private Label jogador4;

    @FXML
    private Label jogador5;

    @FXML
    private Label jogador6;

    public void atualizarTela(ArrayList<Jogador> x, Jogador ganhador) {
        int i = 0;

        ganhouLabel.setText(ganhador.getNome() + ", ganhou o jogo!");

        for (Jogador jogador : x) {
            switch (i) {
                case 0:
                    jogador1.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 1:
                    jogador2.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 2:
                    jogador3.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));

                    break;
                case 3:
                    jogador4.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 4:
                    jogador5.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                case 5:
                    jogador6.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    break;
                default:
                    break;
            }
            i++;
        }
    }

    public void som() {
        SoundUtil.playSound(
                "Ending-Theme-Super-Mario_-World.wav");
    }

    @FXML
    private Button btnContinuar;

    @FXML
    void continuarOnAction(ActionEvent event) {
        try {
            Platform.runLater(() -> {
                Stage stage = Main.getStage();
                stage.close();
                SoundUtil.stopSound();
                Platform.exit();
                System.exit(1);
            });
        } catch (IllegalStateException e) {
            System.out.println("Erro ao fechar o programa ->" + e.getMessage() + "/Causa ->" + e.getCause());
        }

    }

}
