import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableColumn;

public class SettingPieceController {
    private int playersNumber;
    private int count = 1;
    private Fachada fachada = new Fachada();

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if ("settingPiece".equals(newScreen)) {
                    if (userData instanceof String) {
                        try {
                            String playersNumberString = (String) userData;
                            playersNumber = Integer.parseInt(playersNumberString);
                            whichPlayerLabel.setText("1° Jogador");
                            nameField.clear();
                        } catch (NumberFormatException e) {
                            // Lida com a exceção caso a string não seja um número válido
                            System.err.println("Erro: A string não pode ser convertida para um número inteiro.");
                            e.printStackTrace();
                        }
                    } else {
                        // Lida com a situação onde userData não é uma String
                        System.err.println("Erro: userData não é uma instância de String.");
                    }
                }
            }

        });
    }

    private void restart() {
        if (count == playersNumber) {
            App.changeScreen("match", fachada);
        }
        count++;
        whichPlayerLabel.setText(count + "° jogador");
        nameField.clear();
    }

    @FXML
    private Label whichPlayerLabel;

    @FXML
    private Button blackBtn;

    @FXML
    private Button blueBtn;

    @FXML
    private Button greenBtn;

    @FXML
    private TextField nameField;

    @FXML
    private Button purbleBtn;

    @FXML
    private Button redBtn;

    @FXML
    private Button yellowBtn;

    @FXML
    void blackOnAction(ActionEvent event) {
        String playerName = nameField.getText();
        fachada.criarJogadores(playerName, "black");
        blackBtn.setDisable(true);
        restart();
    }

    @FXML
    void blueOnAction(ActionEvent event) {
        String playerName = nameField.getText();
        fachada.criarJogadores(playerName, "blue");
        blueBtn.setDisable(true);
        restart();
    }

    @FXML
    void greenOnAction(ActionEvent event) {
        String playerName = nameField.getText();
        fachada.criarJogadores(playerName, "green");
        greenBtn.setDisable(true);
        restart();
    }

    @FXML
    void purpleOnAction(ActionEvent event) {
        String playerName = nameField.getText();
        fachada.criarJogadores(playerName, "purple");
        purbleBtn.setDisable(true);
        restart();
    }

    @FXML
    void redOnAction(ActionEvent event) {
        String playerName = nameField.getText();
        fachada.criarJogadores(playerName, "red");
        redBtn.setDisable(true);
        restart();
    }

    @FXML
    void yellowOnAction(ActionEvent event) {
        String playerName = nameField.getText();
        fachada.criarJogadores(playerName, "yellow");
        yellowBtn.setDisable(true);
        restart();
    }

}
