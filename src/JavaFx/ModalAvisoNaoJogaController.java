package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class ModalAvisoNaoJogaController {

    @FXML
    private Label avisoNaoPodeJogar;

    private Stage stage;

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    Jogador jogador;

    public void aviso(Jogador jogador) {
        semMoedasLabel.setText("");
        avisoNaoPodeJogar.setText(jogador.getNome() + ", não pode jogar");
        semMoedasLabel.setDisable(true);
        this.jogador = jogador;
    }

    @FXML
    private ImageView imageView;

    Image image = new Image(getClass().getResourceAsStream("./images/images.png"));

    @FXML
    public void initialize() {
        imageView.setImage(image);
        som();

    }

    public void som() {
        SoundUtil.playSound(
                "C:\\Users\\Victo\\Desktop\\PROGRAMAS\\Java\\JAVAUece\\Tabuleiro JAVA & JAVAFX\\jogo-tabuleiro-java - Copia (2)\\jogo-tabuleiro-java - Copia (2)\\src\\JavaFx\\audio\\Shock MGS.wav");
    }

    @FXML
    private Label semMoedasLabel;
    @FXML
    private Button pagarBtn;

    @FXML
    private Button pularBtn;

    @FXML
    void pagarOnAction(ActionEvent event) {
        if (stage != null) {
            if (jogador.getMoedas() == 0) {
                semMoedasLabel.setText("Jogador não possui moedas!");
                pagarBtn.setDisable(true);
            } else {
                jogador.setPodeJogar(true);
                jogador.setRodadasSemJogar(0);
                jogador.gastarMoeda(1);
                Stage stage = (Stage) pagarBtn.getScene().getWindow(); // Obtendo a janela atual
                SoundUtil.stopSound();

                stage.close(); // Fechando o Stage
            }

        }

        if (stage == null)
            System.out.println("stage null");
    }

    @FXML
    void pularOnAction(ActionEvent event) {
        if (stage != null) {
            Stage stage = (Stage) pularBtn.getScene().getWindow(); // Obtendo a janela atual
            SoundUtil.stopSound();

            stage.close(); // Fechando o Stage
        }

        if (stage == null)
            System.out.println("stage null");
    }

}
