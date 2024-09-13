package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.control.Label;

public class ModalAndarPraFrenteController {

    @FXML
    private Button btnContinuar;

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/+3.png"));
    Image imagemDoAzarado = new Image(getClass().getResourceAsStream("./images/images.png"));

    public void som(String soundPath) {
        SoundUtil.playSound(soundPath);
    }

    Jogador jogador;

    @FXML
    private Label casaEspeciallabel;

    public void isAzarado(Jogador jogador) {
        this.jogador = jogador;

        if (jogador.getTipo().equals("azarado")) {
            imageView.setImage(imagemDoAzarado);
            som("C:\\Users\\Victo\\Desktop\\PROGRAMAS\\Java\\JAVAUece\\Tabuleiro JAVA & JAVAFX\\jogo-tabuleiro-java - Copia (2)\\jogo-tabuleiro-java - Copia (2)\\src\\JavaFx\\audio\\Erro SFX.wav");
            casaEspeciallabel.setStyle("-fx-font-size: 20px;");
            casaEspeciallabel.setText("Não vai poder andar porque é uma peça azarada");
        } else {
            imageView.setImage(image);
            som("C:\\Users\\Victo\\Desktop\\PROGRAMAS\\Java\\JAVAUece\\Tabuleiro JAVA & JAVAFX\\jogo-tabuleiro-java - Copia (2)\\jogo-tabuleiro-java - Copia (2)\\src\\JavaFx\\audio\\Coin SFX.wav");

            jogador.setPosicao(jogador.getPosicao() + 3);
        }
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void continuarOnAction(ActionEvent event) {
        if (stage != null) {

            Stage stage = (Stage) btnContinuar.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

}
