package JavaFx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaSorteModalController {
    private Stage stage;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();
    @FXML
    private Button continuarBtn;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        tabuleiro.verificarCasa(jogadorAtual);
        if (jogadores.get(jogadorAtual).getTipo().equals("azarado")) {
            jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", é um jogador azarado!");
            somAzar();
        } else {
            jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", anda 3 casas pra frente (Casa ->"
                    + jogadores.get(jogadorAtual).getPosicao() + ")");
            somSorte();
        }

    }

    public void somAzar() {
        SoundUtil.playSound(
                "Unlucky Sound Effect.wav");
    }

    public void somSorte() {
        SoundUtil.playSound(
                "Sonic Ring - Sound Effect (HD).wav");
    }

    @FXML
    private ImageView imageViewModal;

    @FXML
    private Label jogadorLabel;

    @FXML
    private Label jogadorLabel1;

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
