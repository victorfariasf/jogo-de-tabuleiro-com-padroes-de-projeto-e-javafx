package JavaFx;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.control.Alert;

import javafx.scene.Scene;

public class TelaInicialController {

    private Jogo jogo = new Jogo(getStage());
    private NovoTabuleiro tabuleiro = NovoTabuleiro.getInstance();

    @FXML
    private AnchorPane vBox;

    @FXML
    protected void initialize() {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if (newScreen.equals("main")) {
                    grupoJogadores.selectToggle(null);
                }

            }

        });
    }

    private Stage getStage() {
        return Main.getStage();
    }

    @FXML
    private Button campoIniciar;

    @FXML
    private RadioButton campoPlayer2;

    @FXML
    private RadioButton campoPlayer3;

    @FXML
    private RadioButton campoPlayer4;

    @FXML
    private RadioButton campoPlayer5;

    @FXML
    private RadioButton campoPlayer6;

    @FXML
    private RadioButton dubugModeRadioBtn;

    @FXML
    private ToggleGroup grupoJogadores;

    @FXML
    private TextField numeroDeCasasField;

    @FXML
    void acaoDoBotao(ActionEvent event) {

        RadioButton selectedRadioButton = (RadioButton) grupoJogadores.getSelectedToggle();
        if (selectedRadioButton == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Você deve selecionar um número de jogadores");
            alert.show();
            return;
        }
        if (numeroDeCasasField == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro");
            alert.setHeaderText("Você deve selecionar um número de jogadores");
            alert.show();
            return;
        }
        String[] numeroJogadores = selectedRadioButton.getText().split(" ");
        int qntdJogadores = Integer.parseInt(numeroJogadores[0]);
        int qntdCasas = Integer.parseInt(numeroDeCasasField.getText());
        jogo.configurarJogadores(qntdJogadores);
        jogo.configurarTabuleiro(qntdCasas);

        if (dubugModeRadioBtn.isSelected()) {
            jogo.setModoDebug(true);
        } else {
            jogo.setModoDebug(false);
        }
        Main.changeScreen("second", selectedRadioButton.getText());

    }

}
