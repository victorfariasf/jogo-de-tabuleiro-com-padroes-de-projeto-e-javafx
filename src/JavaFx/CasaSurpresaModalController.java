package JavaFx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaSurpresaModalController {
    private Stage stage;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();
    private int jogadorAtual;
    @FXML
    private Button continuarBtn;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        tabuleiro.verificarCasa(jogadorAtual);
        jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", se tornou uma peça -> "
                + jogadores.get(jogadorAtual).getTipo());
        this.jogadorAtual = jogadorAtual;
        som();
    }

    public void som() {
        SoundUtil.playSound("Surpresa SFX.wav");
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
