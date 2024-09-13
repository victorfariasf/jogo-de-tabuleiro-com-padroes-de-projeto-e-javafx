package JavaFx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaTrocaModalController {
    private Stage stage;
    private ArrayList<Jogador> jogadores = new ArrayList<>();
    private int jogadorAtual;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", ganha uma moeda");
        this.jogadores = jogadores;
        this.jogadorAtual = jogadorAtual;
    }

    @FXML
    private Button continuarBtn;

    @FXML
    private ImageView imageViewModal;

    @FXML
    private Label jogadorLabel;

    @FXML
    private Button naoComprarBtn;
    @FXML
    private Label erroLabel;

    @FXML
    void continuarOnAction(ActionEvent event) {
        if (stage != null) {
            if (jogadores.get(jogadorAtual).getMoedas() == 0) {
                continuarBtn.setDisable(true);
                erroLabel.setText("Jogador não possui moedas");
                return;
            } else {
                tabuleiro.verificarCasa(jogadorAtual);
                // tabuleiro.decorarJogador(jogadores.get(jogadorAtual), jogadorAtual);
                Stage stage = (Stage) continuarBtn.getScene().getWindow(); // Obtendo a janela atual
                // SoundUtil.stopSound();

                stage.close(); // Fechando o Stage
            }

        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void naoComprarOnAction(ActionEvent event) {
        if (stage != null) {

            Stage stage = (Stage) continuarBtn.getScene().getWindow(); // Obtendo a janela atual
            // SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

}
