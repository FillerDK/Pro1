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

public class OpretScene {

    static Stage window;
    static Scene loginScene, minScene;

    public static void initOpret(GridPane pane, Stage stage, Scene scene) {
        window = stage;
        loginScene = scene;

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblOpret = new Label("Opret Bruger");
        lblOpret.setFont(new Font(20));
        pane.add(lblOpret, 0, 0);
        GridPane.setHalignment(lblOpret, HPos.CENTER);

        TextField txfNavn = new TextField();
        txfNavn.setPromptText("Navn");
        pane.add(txfNavn, 0, 1);

        TextField txfTlf = new TextField();
        txfTlf.setPromptText("Tlf. nr.");
        pane.add(txfTlf, 0, 2);

        TextField txfEmail = new TextField();
        txfEmail.setPromptText("Email");
        pane.add(txfEmail, 0, 3);

        TextField txfAdresse = new TextField();
        txfAdresse.setPromptText("Adresse");
        pane.add(txfAdresse, 0, 4);

        PasswordField pswAdgangskode = new PasswordField();
        pswAdgangskode.setPromptText("Adgangskode");
        pane.add(pswAdgangskode, 0, 5);

        Button btnAnnuller = new Button("Annuller");
        btnAnnuller.setPrefWidth(100);

        Button btnOpret = new Button("Opret");
        btnOpret.setPrefWidth(100);

        HBox hbxKnapper = new HBox();
        hbxKnapper.setSpacing(10);
        hbxKnapper.getChildren().addAll(btnAnnuller, btnOpret);
        pane.add(hbxKnapper, 0, 6);

        btnAnnuller.setOnAction(event -> window.setScene(loginScene));

        btnOpret.setOnAction(event -> {
            Boolean ok = true;
            String fejlbesked = "";

            String adgangskode = pswAdgangskode.getText().trim();
            if (adgangskode.equals("")) {
                ok = false;
                fejlbesked = "Indtast venligst en adganskode!";
            }

            String adresse = txfAdresse.getText().trim();
            if (adresse.equals("")) {
                ok = false;
                fejlbesked = "Indtast venligst en adresse!";
            }

            String email = txfEmail.getText().trim();
            if (!email.contains("@")) {
                ok = false;
                fejlbesked = "Indtast venligst en gyldig mail!";
            }
            if (email.equals("")) {
                ok = false;
                fejlbesked = "Indtast venligst en email!";
            }
            if (!Controller.muligBruger(email)) {
                ok = false;
                fejlbesked = "En bruger med denne email eksisterer allerede!";
            }

            String tlf = txfTlf.getText().trim();
            try {
                int phoneInt = Integer.parseInt(txfTlf.getText().trim());
            } catch (NumberFormatException ex) {
                ok = false;
                fejlbesked = "Indtast venligst et gyldigt telefonnummer!";
            }
            if (tlf.length() != 8) {
                ok = false;
                fejlbesked = "Indtast venligst et gyldigt telefonnummer!";
            }
            if (tlf.equals("")) {
                ok = false;
                fejlbesked = "Indtast venligst et telefonnummer!";
            }

            String navn = txfNavn.getText().trim();
            if (navn.equals("")) {
                ok = false;
                fejlbesked = "Indtast venligst et navn!";
            }

            if (ok) {
                Deltager deltager = Controller.opretDeltager(
                        navn,
                        tlf,
                        email,
                        adresse,
                        adgangskode
                );
                BorderPane minPane = new BorderPane();
                minScene = new Scene(minPane);
                MinScene.initMin(minPane, window, minScene, deltager);
                window.setScene(minScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Manglede information");
                alert.setHeaderText("En af felterne er ikke udflydt korrekt!");
                alert.setContentText(fejlbesked);
                alert.show();
            }
        });
    }
}
