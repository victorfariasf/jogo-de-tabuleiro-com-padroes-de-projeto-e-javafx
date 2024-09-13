package JavaFx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaAzarModalController {
    private Stage stage;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        tabuleiro.verificarCasa(jogadorAtual);
        if (jogadores.get(jogadorAtual).getTipo().equals("sortudo")) {
            jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", jogador sortudo não perde moeda");

        }
        jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", perde 3 moedas");
        som();
    }

    public void som() {
        SoundUtil.playSound(
                "Unlucky Sound Effect.wav");
    }

    @FXML
    private Button continuarBtn;

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
