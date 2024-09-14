package JavaFx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaPrisaoModalController {
    private Stage stage;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();
    @FXML
    private Button continuarBtn;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        tabuleiro.verificarCasa(jogadorAtual);
        jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", caiu na prisão!");
        Image image = new Image(getClass().getResourceAsStream("./images/images_das_casas/prisao.png"));
        imageViewModal.setImage(image);
        som();
    }

    public void som() {
        SoundUtil.playSound(
                "gta-wated.wav");
    }

    @FXML
    private ImageView imageViewModal;

    @FXML
    private Label jogadorLabel;

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
