package gui;

import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Service;
import model.Tilmelding;
import model.Udflugt;

public class VisTilmeldingScene {

    static Stage window;
    static Scene minScene;

    public static void initVisTilmelding(
            GridPane pane,
            Stage stage,
            Scene scene,
            Tilmelding tilmelding
    ) {
        window = stage;
        minScene = scene;

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblKonference = new Label("Konference");
        lblKonference.setFont(new Font(20));
        pane.add(lblKonference, 0, 0, 2, 1);
        GridPane.setHalignment(lblKonference, HPos.CENTER);

        Label lblTitel = new Label("Titel:");
        pane.add(lblTitel, 0, 1);

        TextField txfTitel = new TextField();
        txfTitel.setPrefWidth(310);
        txfTitel.setEditable(false);
        txfTitel.setFocusTraversable(false);
        txfTitel.setMouseTransparent(true);
        txfTitel.setText(tilmelding.hentKonference().hentNavn());
        pane.add(txfTitel, 0, 2, 2, 1);

        Label lblStartDato = new Label("Start:");
        pane.add(lblStartDato, 0, 3);

        TextField txfStartDato = new TextField();
        txfStartDato.setEditable(false);
        txfStartDato.setFocusTraversable(false);
        txfStartDato.setMouseTransparent(true);
        txfStartDato.setText(tilmelding.hentAnkomstDato().toString());
        pane.add(txfStartDato, 0, 4);

        Label lblSlutDato = new Label("Slut:");
        pane.add(lblSlutDato, 1, 3);

        TextField txfSlutDato = new TextField();
        txfSlutDato.setEditable(false);
        txfSlutDato.setFocusTraversable(false);
        txfSlutDato.setMouseTransparent(true);
        txfSlutDato.setText(tilmelding.hentAfrejseDato().toString());
        pane.add(txfSlutDato, 1, 4);

        Label lblBeskrivelse = new Label("Beskrivelse:");
        pane.add(lblBeskrivelse, 0, 9);

        TextArea txaBeskrivelse = new TextArea();
        txaBeskrivelse.setPrefWidth(310);
        txaBeskrivelse.setEditable(false);
        txaBeskrivelse.setFocusTraversable(false);
        txaBeskrivelse.setMouseTransparent(true);
        txaBeskrivelse.setText(tilmelding.hentKonference().hentBeskrivelse());
        pane.add(txaBeskrivelse, 0, 10, 2, 1);

        Label lblLokation = new Label("Lokation / Adresse:");
        pane.add(lblLokation, 0, 5);

        TextField txfLokation = new TextField();
        txfLokation.setEditable(false);
        txfLokation.setFocusTraversable(false);
        txfLokation.setMouseTransparent(true);
        txfLokation.setText(tilmelding.hentKonference().hentLokation());
        pane.add(txfLokation, 0, 6, 2, 1);

        Label lblAfgift = new Label("Konferenceafgift:");
        pane.add(lblAfgift, 0, 7);

        TextField txfAfgift = new TextField();
        txfAfgift.setEditable(false);
        txfAfgift.setFocusTraversable(false);
        txfAfgift.setMouseTransparent(true);
        txfAfgift.setText(tilmelding.hentKonference().hentKonferenceAfgift() + ",-");
        pane.add(txfAfgift, 0, 8, 2, 1);


        Label lblLedsager = new Label("Ledsager");
        lblLedsager.setFont(new Font(20));
        pane.add(lblLedsager, 2, 0);
        GridPane.setHalignment(lblLedsager, HPos.CENTER);

        Label lblLedsagerNavn = new Label("Ledsager:");
        pane.add(lblLedsagerNavn, 2, 1);

        TextField txfLedsagerNavn = new TextField();
        txfLedsagerNavn.setEditable(false);
        txfLedsagerNavn.setFocusTraversable(false);
        txfLedsagerNavn.setMouseTransparent(true);
        pane.add(txfLedsagerNavn, 2, 2);

        Label lblLedsagerTlf = new Label("Tlf. Nr:");
        pane.add(lblLedsagerTlf, 2, 3);

        TextField txfLedsagerTlf = new TextField();
        txfLedsagerTlf.setEditable(false);
        txfLedsagerTlf.setFocusTraversable(false);
        txfLedsagerTlf.setMouseTransparent(true);
        pane.add(txfLedsagerTlf, 2, 4);

        Label lblUdflugter = new Label("Udflugter:");
        pane.add(lblUdflugter, 2, 5);

        TextArea txaUdflugter = new TextArea();
        txaUdflugter.setEditable(false);
        txaUdflugter.setFocusTraversable(false);
        txaUdflugter.setMouseTransparent(true);
        txaUdflugter.setPrefWidth(310);
        txaUdflugter.setPrefHeight(10);
        pane.add(txaUdflugter, 2, 6, 1, 5);

        // Hvis ledsager er tilmeldt, ledsager felter sættes
        if (tilmelding.hentLedsager() != null) {
            txfLedsagerNavn.setText(tilmelding.hentLedsager().hentNavn());
            txfLedsagerTlf.setText(tilmelding.hentLedsager().hentTlf());
            for (Udflugt udflugt : tilmelding.hentLedsager().hentUdflugter()) {
                txaUdflugter.setText(udflugt.toString() + "\n" + txaUdflugter.getText());
            }
        } else {
            txfLedsagerNavn.setText("Ingen ledsager tilmeldt");
            txfLedsagerTlf.setText("Ingen ledsager tilmeldt");
            txaUdflugter.setText("Ingen ledsager tilmeldt");
        }

        Button btnOK = new Button("OK");
        btnOK.setPrefWidth(100);
        pane.add(btnOK, 2, 11);
        GridPane.setHalignment(btnOK, HPos.CENTER);

        btnOK.setOnAction(event -> {
            window.setScene(minScene);
            window.centerOnScreen();
        });


        Label lblHotel = new Label("Hotel");
        lblHotel.setFont(new Font(20));
        pane.add(lblHotel, 3, 0);
        GridPane.setHalignment(lblHotel, HPos.CENTER);

        Label lblHotelNavn = new Label("Navn:");
        pane.add(lblHotelNavn, 3, 1);

        TextField txfHotelNavn = new TextField();
        txfHotelNavn.setEditable(false);
        txfHotelNavn.setFocusTraversable(false);
        txfHotelNavn.setMouseTransparent(true);
        pane.add(txfHotelNavn, 3, 2);

        Label lblHotelLokation = new Label("Lokation / adresse:");
        pane.add(lblHotelLokation, 3, 3);

        TextField txfHotelLokation = new TextField();
        txfHotelLokation.setEditable(false);
        txfHotelLokation.setFocusTraversable(false);
        txfHotelLokation.setMouseTransparent(true);
        pane.add(txfHotelLokation, 3, 4);

        Label lblPris = new Label("Pris:");
        pane.add(lblPris, 3, 5);

        TextField txfHotelPris = new TextField();
        txfHotelPris.setEditable(false);
        txfHotelPris.setFocusTraversable(false);
        txfHotelPris.setMouseTransparent(true);
        pane.add(txfHotelPris, 3, 6);

        Label lblServices = new Label("Services:");
        pane.add(lblServices, 3, 7);

        TextArea txaServices = new TextArea();
        txaServices.setEditable(false);
        txaServices.setFocusTraversable(false);
        txaServices.setMouseTransparent(true);
        txaServices.setPrefWidth(310);
        txaServices.setPrefHeight(10);
        pane.add(txaServices, 3, 8, 1, 3);

        // Hvis hotel er valgt, hotel felter sættes
        if (tilmelding.hentHotel() != null) {
            txfHotelNavn.setText(tilmelding.hentHotel().hentNavn());
            txfHotelLokation.setText(tilmelding.hentHotel().hentAdresse());
            for (Service service : tilmelding.hentHotel().hentServices()) {
                txaServices.setText(service.toString() + "\n" + txaServices.getText());
            }
            int værelsesPris = 0;
            if (tilmelding.hentLedsager() != null)
                værelsesPris = tilmelding.hentHotel().hentEnkeltVærelsesPris();
            else værelsesPris = tilmelding.hentHotel().hentDobbeltVærelsesPris();
            txfHotelPris.setText(værelsesPris + ",-");
        } else {
            txfHotelNavn.setText("Ingen hotel er valgt");
            txfHotelLokation.setText("Ingen hotel er valgt");
            txfHotelPris.setText("Ingen hotel er valgt");
            txaServices.setText("Ingen hotel er valgt");
        }
    }
}
