package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;

public class CasaSimplesModalController {
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();
    private Stage stage;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private int jogadorAtual;

    @FXML
    private Button continuarBtn;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", ganha uma moeda");
        this.jogadores = jogadores;
        this.jogadorAtual = jogadorAtual;
        som();
    }

    public void som() {
        SoundUtil.playSound(
                "Coin SFX.wav");
    }

    @FXML
    private ImageView imageViewModal;

    @FXML
    private Label jogadorLabel;

    @FXML
    void continuarOnAction(ActionEvent event) {
        if (stage != null) {
            tabuleiro.verificarCasa(jogadorAtual);
            Stage stage = (Stage) continuarBtn.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();
            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

}
