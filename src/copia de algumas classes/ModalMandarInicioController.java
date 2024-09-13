package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ModalMandarInicioController {

    @FXML
    private Button btnJogador1;

    @FXML
    private Button btnJogador2;

    @FXML
    private Button btnJogador3;

    @FXML
    private Button btnJogador4;

    @FXML
    private Button btnJogador5;

    @FXML
    private Button btnJogador6;

    @FXML
    private Label casaEspecialLabel;

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/coringa.png"));

    @FXML
    public void initialize() {
        imageView.setImage(image);
        som();
    }

    public void atualizarTela(ArrayList<Jogador> x) {
        int i = 0;
        System.out.println("Entrou na casa especial mandar inicio");

        btnJogador1.setText("");
        btnJogador1.setDisable(true);

        btnJogador2.setText("");
        btnJogador2.setDisable(true);

        btnJogador3.setText("");
        btnJogador3.setDisable(true);

        btnJogador4.setText("");
        btnJogador4.setDisable(true);

        btnJogador5.setText("");
        btnJogador5.setDisable(true);

        btnJogador6.setText("");
        btnJogador6.setDisable(true);

        for (Jogador jogador : x) {
            switch (i) {
                case 0:
                    btnJogador1.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    btnJogador1.setDisable(false);
                    break;
                case 1:
                    btnJogador2.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    btnJogador2.setDisable(false);

                    break;
                case 2:
                    btnJogador3.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    btnJogador3.setDisable(false);

                    break;
                case 3:
                    btnJogador4.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    btnJogador4.setDisable(false);

                    break;
                case 4:
                    btnJogador5.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    btnJogador5.setDisable(false);

                    break;
                case 5:
                    btnJogador6.setText(jogador.getNome() + " | Posição: " + Integer.toString(jogador.getPosicao()));
                    btnJogador6.setDisable(false);

                    break;
                default:
                    break;
            }
            i++;
        }
    }

    public void som() {
        SoundUtil.playSound(
                "jogo-tabuleiro-java - Copia (2)/jogo-tabuleiro-java - Copia (2)/src/JavaFx/audio/Joker Laughing.wav");
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void jogador1Inicio(ActionEvent event) {
        if (stage != null) {
            Stage stage = (Stage) btnJogador1.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void jogador2Inicio(ActionEvent event) {
        if (stage != null) {

            Stage stage = (Stage) btnJogador2.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void jogador3Inicio(ActionEvent event) {
        if (stage != null) {

            Stage stage = (Stage) btnJogador3.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void jogador4Inicio(ActionEvent event) {
        if (stage != null) {
            Stage stage = (Stage) btnJogador4.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void jogador5Inicio(ActionEvent event) {
        if (stage != null) {
            Stage stage = (Stage) btnJogador5.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void jogador6Inicio(ActionEvent event) {
        if (stage != null) {
            Stage stage = (Stage) btnJogador6.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

}
