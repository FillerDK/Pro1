package gui;

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
import model.Tilmelding;

public class MinScene {

    static Stage window;
    static Scene minScene, konferenceScene, visTilmeldScene, opdaterOplysningerScene;

    private final static ListView lvwTilmeldinger = new ListView();
    private final static TextField txfNavn = new TextField();
    private final static TextField txfTlf = new TextField();
    private final static TextField txfEmail = new TextField();
    private final static TextField txfAdresse = new TextField();
    private final static PasswordField pswAdgangskode = new PasswordField();

    public static void initMin(BorderPane pane, Stage stage, Scene scene, Deltager deltager) {
        window = stage;
        minScene = scene;

        // Mine tilmeldinger --- venstre pane
        GridPane tPane = new GridPane();
        tPane.setPadding(new Insets(20));
        tPane.setHgap(10);
        tPane.setVgap(10);
        tPane.setGridLinesVisible(false);
        pane.setLeft(tPane);

        Label lblTilmeldinger = new Label("Mine tilmeldinger");
        lblTilmeldinger.setFont(new Font(20));
        tPane.add(lblTilmeldinger, 0, 0);
        GridPane.setHalignment(lblTilmeldinger, HPos.CENTER);

        lvwTilmeldinger.setPrefWidth(310);
        tPane.add(lvwTilmeldinger, 0, 1);

        // Hent deltagers tilmeldinger
        lvwTilmeldinger.getItems().setAll(deltager.hentTilmedlinger());

        Button btnOpretTilmelding = new Button("Opret tilmelding");
        btnOpretTilmelding.setPrefWidth(150);

        Button btnInfo = new Button("Vis info");
        btnInfo.setPrefWidth(150);

        HBox hbxKnapper = new HBox();
        hbxKnapper.setSpacing(10);
        hbxKnapper.getChildren().addAll(btnOpretTilmelding, btnInfo);
        tPane.add(hbxKnapper, 0, 2);

        btnOpretTilmelding.setOnAction(event -> {
            GridPane gridPane = new GridPane();
            konferenceScene = new Scene(gridPane);
            KonferenceScene.initKonferenceScene(
                    gridPane, window, minScene, konferenceScene, deltager
            );
            window.setScene(konferenceScene);
            window.centerOnScreen();
        });

        btnInfo.setOnAction(event -> {
            Tilmelding tilmelding = (Tilmelding)
                    lvwTilmeldinger.getSelectionModel().getSelectedItem();
            if (tilmelding != null) {
                GridPane gridPane = new GridPane();
                visTilmeldScene = new Scene(gridPane);
                VisTilmeldingScene.initVisTilmelding(gridPane, window, minScene, tilmelding);
                window.setScene(visTilmeldScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen tilmelding er valgt!");
                alert.show();
            }
        });

        // Mine oplysninger --- højre pane
        GridPane oPane = new GridPane();
        oPane.setPadding(new Insets(20));
        oPane.setHgap(10);
        oPane.setVgap(10);
        oPane.setGridLinesVisible(false);
        pane.setRight(oPane);

        Label lblOplysninger = new Label("Mine oplysninger");
        lblOplysninger.setFont(new Font(20));
        oPane.add(lblOplysninger, 0, 0);
        GridPane.setHalignment(lblOplysninger, HPos.CENTER);

        Label lblNavn = new Label("Navn:");
        oPane.add(lblNavn, 0, 1);

        txfNavn.setEditable(false);
        txfNavn.setFocusTraversable(false);
        txfNavn.setMouseTransparent(true);
        txfNavn.setPrefWidth(310);
        txfNavn.setText(deltager.hentNavn());
        oPane.add(txfNavn, 0, 2);

        Label lblTlf = new Label("Tlf:");
        oPane.add(lblTlf, 0, 3);

        txfTlf.setEditable(false);
        txfTlf.setFocusTraversable(false);
        txfTlf.setMouseTransparent(true);
        txfTlf.setText(deltager.hentTlf());
        oPane.add(txfTlf, 0, 4);

        Label lblEmail = new Label("Email:");
        oPane.add(lblEmail, 0, 5);

        txfEmail.setEditable(false);
        txfEmail.setFocusTraversable(false);
        txfEmail.setMouseTransparent(true);
        txfEmail.setText(deltager.hentEmail());
        oPane.add(txfEmail, 0, 6);

        Label lblAdresse = new Label("Adresse:");
        oPane.add(lblAdresse, 0, 7);

        txfAdresse.setEditable(false);
        txfAdresse.setFocusTraversable(false);
        txfAdresse.setMouseTransparent(true);
        txfAdresse.setText(deltager.hentAdresse());
        oPane.add(txfAdresse, 0, 8);

        Label lblAdgangskode = new Label("Adgangskode:");
        oPane.add(lblAdgangskode, 0, 9);

        pswAdgangskode.setEditable(false);
        pswAdgangskode.setFocusTraversable(false);
        pswAdgangskode.setMouseTransparent(true);
        pswAdgangskode.setText(deltager.hentAdgangskode());
        oPane.add(pswAdgangskode, 0, 10);

        Button btnOpdater = new Button("Opdater");
        btnOpdater.setPrefWidth(150);
        oPane.add(btnOpdater, 0, 11);
        GridPane.setHalignment(btnOpdater, HPos.CENTER);

        btnOpdater.setOnAction(event -> {
            GridPane gridPane = new GridPane();
            opdaterOplysningerScene = new Scene(gridPane);
            OpdaterOplysningerScene.initOpdaterOplysninger(gridPane, window, minScene, deltager);
            window.setScene(opdaterOplysningerScene);
            window.centerOnScreen();
        });
    }

    public static void opdaterFelter(Deltager deltager) {
        lvwTilmeldinger.getItems().setAll(deltager.hentTilmedlinger());
        txfNavn.setText(deltager.hentNavn());
        txfTlf.setText(deltager.hentTlf());
        txfEmail.setText(deltager.hentEmail());
        txfAdresse.setText(deltager.hentAdresse());
        pswAdgangskode.setText(deltager.hentAdgangskode());
    }
}
