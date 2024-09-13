
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class MainController {

    @FXML
    protected void initialize() {
        App.addOnChangeScreenListener(new App.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {

            }

        });
    }

    @FXML
    private Button fivePlayersBtn;

    @FXML
    private Button fourPlayersBtn;

    @FXML
    private Button sixPlayersBtn;

    @FXML
    private Button threePlayersBtn;

    @FXML
    private Button twoPlayersBtn;

    @FXML
    void twoPlayersOnAction(ActionEvent event) {
        App.changeScreen("settingPiece", "2");

    }

    @FXML
    void threePlayersOnAction(ActionEvent event) {
        App.changeScreen("settingPiece", "3");

    }

    @FXML
    void fourPlayersOnAction(ActionEvent event) {
        App.changeScreen("settingPiece", "4");

    }

    @FXML
    void fivePlayersOnAction(ActionEvent event) {
        App.changeScreen("settingPiece", "5");

    }

    @FXML
    void sixPlayersOnAction(ActionEvent event) {
        App.changeScreen("settingPiece", "6");

    }

}
