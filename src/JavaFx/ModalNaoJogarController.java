package JavaFx;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ModalNaoJogarController {

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/images.png"));

    @FXML
    private Button continuarBtn;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        imageView.setImage(image);
        som();

    }

    public void desabilitarJogadaTemp(Jogador jogador) {
        jogador.setPodeJogar(false);
    }

    public void som() {
        SoundUtil.playSound(
                "C:\\Users\\Victo\\Desktop\\PROGRAMAS\\Java\\JAVAUece\\Tabuleiro JAVA & JAVAFX\\jogo-tabuleiro-java - Copia (2)\\jogo-tabuleiro-java - Copia (2)\\src\\JavaFx\\audio\\Shock MGS.wav");
    }

    @FXML
    void continuarOnAction(ActionEvent event) {
        if (stage != null) {

            Stage stage = (Stage) continuarBtn.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

}
