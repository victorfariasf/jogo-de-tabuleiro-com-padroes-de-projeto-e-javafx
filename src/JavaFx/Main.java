package JavaFx;

import javafx.application.Application;
import javafx.beans.binding.ObjectExpression;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Scanner;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    private static Stage stage;

    private static Scene mainScene;
    private static Scene secondScene;
    private static Scene partidaScene;

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Parent fxmlMain = FXMLLoader.load(getClass().getResource("/JavaFx/fxml/telaInicial.fxml"));
        mainScene = new Scene(fxmlMain);

        Parent fxmlSecond = FXMLLoader.load(getClass().getResource("/JavaFx/fxml/configurandoPeca.fxml"));
        secondScene = new Scene(fxmlSecond);

        Parent fxmlPartida = FXMLLoader.load(getClass().getResource("/JavaFx/fxml/partida.fxml"));
        partidaScene = new Scene(fxmlPartida);

        primaryStage.setScene(mainScene);
        primaryStage.setTitle("Hello World!");
        primaryStage.show();
    }

    public static void changeScreen(String scr, Object userData) {
        switch (scr) {
            case "main":
                stage.setScene(mainScene);
                notifyAllListeners("main", userData);
                break;
            case "second":
                stage.setScene(secondScene);
                notifyAllListeners("second", userData);
                break;
            case "partida":
                stage.setScene(partidaScene);
                notifyAllListeners("partida", userData);
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
