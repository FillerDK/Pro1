package gui;

import javafx.geometry.HPos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Hotel;
import model.Tilmelding;

public class VisHotelScene {
    private static Stage window;
    private static Scene hotellerScene, visHotelScene;

    public static void initVisHotel(
            GridPane pane,
            Stage stage,
            Scene forrigeScene,
            Hotel hotel,
            Tilmelding tilmelding
    ) {
        window = stage;
        hotellerScene = forrigeScene;

        Gui.gPaneDefault(pane);

        Label lblNavn = new Label("Navn:");
        pane.add(lblNavn, 0, 0);

        TextField txfNavn = new TextField();
        txfNavn.setText(hotel.hentNavn());
        txfNavn.setEditable(false);
        txfNavn.setFocusTraversable(false);
        txfNavn.setMouseTransparent(true);
        pane.add(txfNavn, 0, 1);

        Label lblLokation = new Label("Lokation / Adresse:");
        pane.add(lblLokation, 0, 2);

        TextField txfLokation = new TextField();
        txfLokation.setText(hotel.hentAdresse());
        txfLokation.setEditable(false);
        txfLokation.setFocusTraversable(false);
        txfLokation.setMouseTransparent(true);
        pane.add(txfLokation, 0, 3);

        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 0, 4);

        // Ændre pris til det rigtige
        TextField txfPris = new TextField();
        int hotelPris = hotel.hentEnkeltVærelsesPris();
        if (tilmelding.hentLedsager() != null)
            hotelPris = hotel.hentDobbeltVærelsesPris();
        txfPris.setText(hotelPris + ",-");
        txfPris.setEditable(false);
        txfPris.setFocusTraversable(false);
        txfPris.setMouseTransparent(true);
        pane.add(txfPris, 0, 5);

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(100);
        pane.add(btnOK, 0, 6);
        GridPane.setHalignment(btnOK, HPos.CENTER);

        btnOK.setOnAction(event -> {
            window.setScene(hotellerScene);
            window.centerOnScreen();
        });
    }
}
