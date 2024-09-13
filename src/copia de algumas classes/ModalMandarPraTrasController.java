package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import java.util.ArrayList;

public class ModalMandarPraTrasController {

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/palhaco.png"));

    @FXML
    private Button btnContinuar;

    @FXML
    private Label casaEspecialLabel;

    @FXML
    private Label jogadorMaisAtrasLabel;

    @FXML
    private Label jogadorVoceLabel;

    @FXML
    public void initialize() {
        imageView.setImage(image);
        som();
    }

    public void som() {
        SoundUtil.playSound(
                "C:\\Users\\Victo\\Desktop\\PROGRAMAS\\Java\\JAVAUece\\Tabuleiro JAVA & JAVAFX\\jogo-tabuleiro-java - Copia (2)\\jogo-tabuleiro-java - Copia (2)\\src\\JavaFx\\audio\\risada sapo.wav");
    }

    public Jogador acharJogadorMaisAtras(ArrayList<Jogador> jogadores) {
        int maiorNumero = Integer.MAX_VALUE;
        int indice = 0;
        for (Jogador x : jogadores) {
            if (x.getPosicao() < maiorNumero)
                continue;
            else
                indice++;
        }
        return jogadores.get(indice);
    }

    public void atualizarTela(ArrayList<Jogador> jogadores, Jogador jogador) {
        Jogador jogadorMaisAtras = acharJogadorMaisAtras(jogadores);
        jogadorMaisAtrasLabel.setText(
                "Dados antigos ->" + jogadorMaisAtras.getNome() + " | Posição: " + jogadorMaisAtras.getPosicao());
        jogadorVoceLabel.setText("Dados antigos ->" + jogador.getNome() + " | Posição: " + jogador.getPosicao());
    }

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
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
