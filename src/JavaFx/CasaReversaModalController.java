package JavaFx;

import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class CasaReversaModalController {
    private Stage stage;
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setLabels(ArrayList<Jogador> jogadores, int jogadorAtual) {
        Jogador jogadorMaisAtras = pegarJogadorMaisAtras(jogadores, jogadorAtual);
        jogadorLabel.setText(jogadores.get(jogadorAtual).getNome() + ", vai trocar de lugar com "
                + jogadorMaisAtras.getNome() + "(Pos: " + jogadorMaisAtras.getPosicao() + ")");
        tabuleiro.verificarCasa(jogadorAtual);
        posicaoLabel.setText(
                jogadores.get(jogadorAtual).getNome() + ", irá pra casa->" + jogadores.get(jogadorAtual).getPosicao());
        som();
    }

    public Jogador pegarJogadorMaisAtras(ArrayList<Jogador> jogadores, int jogadorAtual) {
        int posicaoDoJogadorMaisAtras = Integer.MAX_VALUE;
        int indiceDoJogadorMaisAtras = -1;
        for (int i = 0; i < jogadores.size(); i++) {
            Jogador x = jogadores.get(i);
            if (x.getPosicao() < posicaoDoJogadorMaisAtras) {
                posicaoDoJogadorMaisAtras = x.getPosicao();
                indiceDoJogadorMaisAtras = i;
            }
        }
        if (indiceDoJogadorMaisAtras == -1) {
            throw new IllegalStateException("Nenhum jogador encontrado");
        }
        return jogadores.get(indiceDoJogadorMaisAtras);
    }

    public void som() {
        SoundUtil.playSound(
                "risada sapo.wav");
    }

    @FXML
    private Button continuarBtn;

    @FXML
    private ImageView imageViewModal;

    @FXML
    private Label jogadorLabel;
    @FXML
    private Label posicaoLabel;

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
