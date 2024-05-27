package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import model.Deltager;

public class OpdaterOplysningerScene {
    private static Stage window;
    static Scene minScene;

    public static void initOpdaterOplysninger(
            GridPane pane,
            Stage stage,
            Scene scene,
            Deltager deltager
    ) {
        window = stage;
        minScene = scene;

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        int txfWidth = 210;

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        TextField txfNavn = new TextField();
        txfNavn.setPrefWidth(txfWidth);
        txfNavn.setText(deltager.hentNavn());
        pane.add(txfNavn, 0, 1);

        Label lblTlf = new Label("Tlf:");
        pane.add(lblTlf, 0, 2);

        TextField txfTlf = new TextField();
        txfTlf.setText(deltager.hentTlf());
        pane.add(txfTlf, 0, 3);

        Label lblEmail = new Label("Email:");
        pane.add(lblEmail, 0, 4);

        TextField txfEmail = new TextField();
        txfEmail.setText(deltager.hentEmail());
        pane.add(txfEmail, 0, 5);

        Label lblAdresse = new Label("Adresse:");
        pane.add(lblAdresse, 0, 6);

        TextField txfAdresse = new TextField();
        txfAdresse.setText(deltager.hentAdresse());
        pane.add(txfAdresse, 0, 7);

        Label lblAdgangskode = new Label("Adgangskode:");
        pane.add(lblAdgangskode, 0, 8);

        PasswordField pswAdgangskode = new PasswordField();
        pswAdgangskode.setText(deltager.hentAdgangskode());
        pane.add(pswAdgangskode, 0, 9);

        Button btnAnnuller = new Button("Annuller");
        btnAnnuller.setPrefWidth(100);

        Button btnOpdater = new Button("Opdater");
        btnOpdater.setPrefWidth(100);

        HBox hbxKnapper = new HBox();
        hbxKnapper.setSpacing(10);
        hbxKnapper.getChildren().addAll(btnAnnuller, btnOpdater);
        pane.add(hbxKnapper, 0, 10);
        GridPane.setHalignment(hbxKnapper, HPos.CENTER);

        btnAnnuller.setOnAction(event -> {
            window.setScene(minScene);
            window.centerOnScreen();
        });

        btnOpdater.setOnAction(event -> {
            deltager.setNavn(txfNavn.getText().trim());
            deltager.setTlf(txfTlf.getText().trim());
            deltager.setEmail(txfEmail.getText().trim());
            deltager.setAdresse(txfAdresse.getText().trim());
            deltager.setAdgangskode(pswAdgangskode.getText().trim());
            BorderPane borderPane = new BorderPane();
            minScene = new Scene(borderPane);
            MinScene.initMin(borderPane, window, minScene, deltager);
            MinScene.opdaterFelter(deltager);
            window.setScene(minScene);
            window.centerOnScreen();
        });
    }
}
