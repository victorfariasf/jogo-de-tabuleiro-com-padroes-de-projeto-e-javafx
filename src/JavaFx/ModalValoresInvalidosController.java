package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.media.AudioClip;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;
import javafx.scene.control.Label;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class ModalValoresInvalidosController {

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/images.png"));

    @FXML
    private Button btnContinuar;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize(Jogador x) {
        imageView.setImage(image);
        naoJogar.setText(x.getNome() + ", não pode jogar");
        som();

    }

    public void som() {
        SoundUtil.playSound(
                "Erro SFX.wav");
    }

    @FXML
    private Label naoJogar;

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
