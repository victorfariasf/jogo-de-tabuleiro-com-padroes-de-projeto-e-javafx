import java.util.ArrayList;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        launch(args);
    }

    private static Stage stage;

    private static Scene mainScene;
    private static Scene settingPieceScene;
    private static Scene matchScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("fxml/main.fxml"));
        mainScene = new Scene(fxmlMain);

        Parent fxmlSettingPiece = FXMLLoader.load(getClass().getResource("fxml/settingPiece.fxml"));
        settingPieceScene = new Scene(fxmlSettingPiece);

        Parent fxmlMatch = FXMLLoader.load(getClass().getResource("fxml/match.fxml"));
        matchScene = new Scene(fxmlMatch);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Bem-vindo");
        primaryStage.show();
    }

    public static void changeScreen(String scr, Object userData) {
        switch (scr) {
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "settingPiece":
                stage.setScene(settingPieceScene);
                notifyAllListeners("settingPiece", userData);
                break;
            case "match":
                stage.setScene(matchScene);
                notifyAllListeners("match", userData);
                break;
            default:
                break;
        }
    }

    public static Stage getStage() {
        return stage;
    }

    public static void changeScreen(String scr) {

        changeScreen(scr, null);
    }

    // ------------------------------------------------------------
    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public static interface OnChangeScreen {
        void onScreenChanged(String newScreen, Object userData);

    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener) {
        listeners.add(newListener);
    }

    private static void notifyAllListeners(String newScreen, Object userData) {
        for (OnChangeScreen l : listeners) {
            l.onScreenChanged(newScreen, userData);
        }
    }
}
