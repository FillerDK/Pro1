package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Deltager;

public class LoginScene {

    static Stage window;
    static Scene loginScene, opretScene, minScene;

    public static void initLogin(GridPane pane, Stage stage, Scene scene) {
        window = stage;
        loginScene = scene;

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblLogin = new Label("Log in");
        lblLogin.setFont(new Font(20));
        pane.add(lblLogin, 0, 0);
        GridPane.setHalignment(lblLogin, HPos.CENTER);

        TextField txfEmail = new TextField();
        txfEmail.setPromptText("Email");
        pane.add(txfEmail, 0, 1);

        PasswordField pswAdgangskode = new PasswordField();
        pswAdgangskode.setPromptText("Adganskode");
        pane.add(pswAdgangskode, 0, 2);

        Button btnOpretLogin = new Button("Opret Bruger");
        btnOpretLogin.setPrefWidth(100);

        Button btnLogin = new Button("Login");
        btnLogin.setPrefWidth(100);

        HBox hbxKnapper = new HBox();
        hbxKnapper.setSpacing(10);
        hbxKnapper.getChildren().addAll(btnOpretLogin, btnLogin);
        pane.add(hbxKnapper, 0, 3);

        // Fjerner fokus fra valgte node
        loginScene.setOnMouseClicked(event -> {
            if (!txfEmail.equals(event.getSource())) {
                txfEmail.getParent().requestFocus();
            }
        });

        // Alle actions
        btnOpretLogin.setOnAction(event -> {
            GridPane opretPane = new GridPane();
            opretScene = new Scene(opretPane);
            OpretScene.initOpret(opretPane, window, loginScene);
            window.setScene(opretScene);
            window.centerOnScreen();
        });

        btnLogin.setOnAction(event -> {
            if (txfEmail.getText().trim().equals("admin") &&
                    pswAdgangskode.getText().equals("admin")
            ) {
                skiftTilAdminScene();
            } else {
                // Hent deltager fra storage via controller
                Boolean okInput = true;

                String adgangskode = pswAdgangskode.getText().trim();
                if (adgangskode.equals(""))
                    okInput = false;

                String email = txfEmail.getText().trim();
                if (email.equals(""))
                    okInput = false;

                Deltager deltager = null;
                if (okInput) deltager = Controller.hentDeltager(email, adgangskode);


                if (deltager != null) {
                    skiftTilMinScene(deltager);
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Bruger ikke fundet!");
                    alert.setHeaderText("Email eller adganskode er forkert!");
                    alert.setContentText("Prøv igen!");
                    alert.show();
                }


            }
        });
    }

    public static void skiftTilMinScene(Deltager deltager) {
        BorderPane minPane = new BorderPane();
        minScene = new Scene(minPane);
        MinScene.initMin(minPane, window, minScene, deltager);
        window.setScene(minScene);
        window.centerOnScreen();
    }


    private static void skiftTilAdminScene() {
        GridPane pane = new GridPane();
        Scene adminScene = new Scene(pane);
        AdminScene.adminScene(pane);
        window.setScene(adminScene);
        window.centerOnScreen();

    }
}
