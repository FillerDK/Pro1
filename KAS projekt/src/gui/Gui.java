package gui;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;


public class Gui extends Application {

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("KAS");
        GridPane pane = new GridPane();

        Scene loginScene = new Scene(pane);

        LoginScene.initLogin(pane, window, loginScene);

        window.setScene(loginScene);
        window.show();

    }

    // -----------hjælpe metoder

    public static void gPaneDefault(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
    }
}
