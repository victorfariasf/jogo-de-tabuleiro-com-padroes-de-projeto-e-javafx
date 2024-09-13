package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ModalTrocaPecaController {

    @FXML
    private Button btnContinuar;

    @FXML
    private Label novaPecaLabel;

    private Stage stage;
    private Jogador jogador;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        som();
    }

    public void setJogador(Jogador jogador) {
        this.jogador = jogador;
        novaPecaLabel.setText(jogador.getTipo());
    }

    public void som() {
        SoundUtil.playSound(
                "C:\\Users\\Victo\\Desktop\\PROGRAMAS\\Java\\JAVAUece\\Tabuleiro JAVA & JAVAFX\\jogo-tabuleiro-java - Copia (2)\\jogo-tabuleiro-java - Copia (2)\\src\\JavaFx\\audio\\Erro SFX.wav");
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
