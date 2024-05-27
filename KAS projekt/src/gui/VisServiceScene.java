package gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Service;

public class VisServiceScene {
    private static Stage window;
    private static Scene servicesScene;

    public static void initVisService(
            GridPane pane,
            Stage stage,
            Scene forrigeScene,
            Service service
    ) {
        window = stage;
        servicesScene = forrigeScene;

        Gui.gPaneDefault(pane);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        TextField txfNavn = new TextField();
        txfNavn.setText(service.hentNavn());
        txfNavn.setEditable(false);
        txfNavn.setFocusTraversable(false);
        txfNavn.setMouseTransparent(true);
        pane.add(txfNavn, 0, 1);

        Label lblBeskrivelse = new Label("Beskrivelse:");
        pane.add(lblBeskrivelse, 0, 2);

        TextArea txaBeskrivelse = new TextArea();
        txaBeskrivelse.setEditable(false);
        txaBeskrivelse.setFocusTraversable(false);
        txaBeskrivelse.setMouseTransparent(true);
        txaBeskrivelse.setText(service.hentBeskrivelse());
        pane.add(txaBeskrivelse, 0, 3);

        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 4);

        TextField txfPris = new TextField();
        txfPris.setText(service.hentPris() + ",-");
        txfPris.setEditable(false);
        txfPris.setFocusTraversable(false);
        txfPris.setMouseTransparent(true);
        pane.add(txfPris, 0, 5);

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(100);
        pane.add(btnOK, 0, 6);
        GridPane.setHalignment(btnOK, HPos.CENTER);

        btnOK.setOnAction(event -> {
            window.setScene(servicesScene);
            window.centerOnScreen();
        });
    }
}
