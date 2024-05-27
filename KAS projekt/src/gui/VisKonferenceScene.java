package gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Konference;

public class VisKonferenceScene {
    private static Stage window;
    private static Scene konferenceScene;

    public static void initVisKonf(GridPane pane, Stage stage, Scene scene, Konference konference) {
        window = stage;
        konferenceScene = scene;

        Gui.gPaneDefault(pane);

        Label lblTitel = new Label("Titel:");
        pane.add(lblTitel, 0, 0, 3, 1);

        TextField txfTitel = new TextField();
        txfTitel.setEditable(false);
        txfTitel.setFocusTraversable(false);
        txfTitel.setMouseTransparent(true);
        txfTitel.setText(konference.hentNavn());
        pane.add(txfTitel, 0, 1, 3, 1);

        Label lblFrist = new Label("Frist:");
        pane.add(lblFrist, 0, 2, 3, 1);

        TextField txfFrist = new TextField();
        txfFrist.setEditable(false);
        txfFrist.setFocusTraversable(false);
        txfFrist.setMouseTransparent(true);
        txfFrist.setPrefWidth(80);
        txfFrist.setText(konference.hentTilmeldingsfrist().toString());
        pane.add(txfFrist, 0, 3);

        Label lblStart = new Label("Start:");
        pane.add(lblStart, 1, 2);

        TextField txfStart = new TextField();
        txfStart.setEditable(false);
        txfStart.setFocusTraversable(false);
        txfStart.setMouseTransparent(true);
        txfStart.setPrefWidth(80);
        txfStart.setText(konference.hentStartDato().toString());
        pane.add(txfStart, 1, 3);

        Label lblSlut = new Label("Slut:");
        pane.add(lblSlut, 2, 2);

        TextField txfSlut = new TextField();
        txfSlut.setEditable(false);
        txfSlut.setFocusTraversable(false);
        txfSlut.setMouseTransparent(true);
        txfSlut.setPrefWidth(80);
        txfSlut.setText(konference.hentSlutDato().toString());
        pane.add(txfSlut, 2, 3);

        Label lblBeskrivelse = new Label("Beskrivelse:");
        pane.add(lblBeskrivelse, 0, 4, 3, 1);

        TextArea txaBeskrivelse = new TextArea();
        txaBeskrivelse.setEditable(false);
        txaBeskrivelse.setFocusTraversable(false);
        txaBeskrivelse.setMouseTransparent(true);
        txaBeskrivelse.setPrefWidth(100);
        txaBeskrivelse.setText(konference.hentBeskrivelse());
        pane.add(txaBeskrivelse, 0, 5, 3, 1);

        Label lblLokation = new Label("Lokation / Adresse:");
        pane.add(lblLokation, 0, 6, 3, 1);

        TextField txfLokation = new TextField();
        txfLokation.setEditable(false);
        txfLokation.setFocusTraversable(false);
        txfLokation.setMouseTransparent(true);
        txfLokation.setText(konference.hentLokation());
        pane.add(txfLokation, 0, 7, 3, 1);

        Label lblAfgift = new Label("Konferenceafgift:");
        pane.add(lblAfgift, 0, 8, 3, 1);

        TextField txfAfgift = new TextField();
        txfAfgift.setEditable(false);
        txfAfgift.setFocusTraversable(false);
        txfAfgift.setMouseTransparent(true);
        txfAfgift.setText(konference.hentKonferenceAfgift() + ",-");
        pane.add(txfAfgift, 0, 9, 3, 1);

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(100);
        pane.add(btnOK, 0, 10, 3, 1);
        GridPane.setHalignment(btnOK, HPos.CENTER);

        btnOK.setOnAction(event -> {
            window.setScene(konferenceScene);
            window.centerOnScreen();
        });
    }
}
