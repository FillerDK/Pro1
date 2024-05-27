package gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Udflugt;

public class VisUdflugtScene {
    private static Stage window;
    private static Scene udflugterScene;

    public static void initVisUdflugt(
            GridPane pane,
            Stage stage,
            Scene forrigeScene,
            Udflugt udflugt
    ) {
        window = stage;
        udflugterScene = forrigeScene;

        Gui.gPaneDefault(pane);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        TextField txfNavn = new TextField();
        txfNavn.setText(udflugt.hentNavn());
        txfNavn.setEditable(false);
        txfNavn.setFocusTraversable(false);
        txfNavn.setMouseTransparent(true);
        pane.add(txfNavn, 0, 1);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 0, 2);

        TextField txfDato = new TextField();
        txfDato.setText(udflugt.hentDato().toString());
        txfDato.setEditable(false);
        txfDato.setFocusTraversable(false);
        txfDato.setMouseTransparent(true);
        pane.add(txfDato, 0, 3);

        Label lblBeskrivelse = new Label("Beskrivelse:");
        pane.add(lblBeskrivelse, 0, 4);

        TextArea txaBeskrivelse = new TextArea();
        txaBeskrivelse.setText(udflugt.hentBeskrivelse());
        txaBeskrivelse.setEditable(false);
        txaBeskrivelse.setFocusTraversable(false);
        txaBeskrivelse.setMouseTransparent(true);
        pane.add(txaBeskrivelse, 0, 5);

        Label lblLokation = new Label("Lokation / Adresse:");
        pane.add(lblLokation, 0, 6);

        TextField txfLokation = new TextField();
        txfLokation.setText(udflugt.hentLokation());
        txfLokation.setEditable(false);
        txfLokation.setFocusTraversable(false);
        txfLokation.setMouseTransparent(true);
        pane.add(txfLokation, 0, 7);

        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 8);

        TextField txfPris = new TextField();
        txfPris.setText(udflugt.hentPris() + ",-");
        txfPris.setEditable(false);
        txfPris.setFocusTraversable(false);
        txfPris.setMouseTransparent(true);
        pane.add(txfPris, 0, 9);

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(100);
        pane.add(btnOK, 0, 10);
        GridPane.setHalignment(btnOK, HPos.CENTER);

        btnOK.setOnAction(event -> {
            window.setScene(udflugterScene);
            window.centerOnScreen();
        });
    }
}
