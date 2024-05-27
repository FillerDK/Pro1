package gui;

import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Tilmelding;

public class OrdreOversigtScene {
    private static Stage window;
    private static Scene forrigeScene;

    public static void initOrdreOversigt(
            GridPane pane, Stage stage, Scene forrigeScene, Tilmelding tilmelding
    ) {
        window = stage;
        OrdreOversigtScene.forrigeScene = forrigeScene;

        // Venstre side
        GridPane leftPane = new GridPane();
        Gui.gPaneDefault(leftPane);
        pane.add(leftPane, 0, 1);

        Label lblKonference = new Label();
        lblKonference.setText("Konference: " + tilmelding.hentKonference().toString());
        leftPane.add(lblKonference, 0, 0);

        Label lblLedsager = new Label();
        leftPane.add(lblLedsager, 0, 1);

        Label lblUdflugter = new Label("Udflugter:");
        leftPane.add(lblUdflugter, 0, 2);

        TextArea txaUdflugter = new TextArea();
        txaUdflugter.setEditable(false);
        txaUdflugter.setFocusTraversable(false);
        txaUdflugter.setMouseTransparent(true);
        leftPane.add(txaUdflugter, 0, 3);

        Label lblHotel = new Label();
        if (tilmelding.hentHotel() == null)
            lblHotel.setText("Ingen hotel");
        else lblHotel.setText("Hotel: " + tilmelding.hentHotel().toString());
        leftPane.add(lblHotel, 0, 4);

        Button btnForrige = new Button("Forrige");
        btnForrige.setPrefWidth(100);
        leftPane.add(btnForrige, 0, 5);
        GridPane.setHalignment(btnForrige, HPos.CENTER);

        btnForrige.setOnAction(event -> {
            ServicesScene.opdaterFelter();
            window.setScene(forrigeScene);
            window.centerOnScreen();
        });

        if (tilmelding.hentLedsager() != null) {
            lblLedsager.setText("Ledsager: " + tilmelding.hentLedsager().hentNavn());
            txaUdflugter.setText(tilmelding.hentLedsager().hentUdflugter().toString());
        } else {
            lblLedsager.setText("Ledsager: ingenledsager");
            txaUdflugter.setText("Ingen udflugter er valgt");
        }


        // Højre side
        GridPane rightPane = new GridPane();
        Gui.gPaneDefault(rightPane);
        pane.add(rightPane, 2, 1);

        Label lblOplysninger = new Label("Oplysninger");
        rightPane.add(lblOplysninger, 0, 0, 2, 1);
        GridPane.setHalignment(lblOplysninger, HPos.CENTER);

        Label lblKonferencePris = new Label("Konference:");
        rightPane.add(lblKonferencePris, 0, 1);

        TextField txfKonferencePris = new TextField();
        txfKonferencePris.setText(tilmelding.hentKonference().hentKonferenceAfgift() + ",-");
        txfKonferencePris.setAlignment(Pos.BASELINE_RIGHT);
        txfKonferencePris.setEditable(false);
        txfKonferencePris.setFocusTraversable(false);
        txfKonferencePris.setMouseTransparent(true);
        txfKonferencePris.setPrefWidth(100);
        rightPane.add(txfKonferencePris, 1, 1);

        Label lblUdflugterPris = new Label("Udflugter:");
        rightPane.add(lblUdflugterPris, 0, 2);

        TextField txfUdflugterPris = new TextField();
        if (tilmelding.hentLedsager() != null) {
            txfUdflugterPris.setText(tilmelding.hentLedsager().prisForUdflugter() + ",-");

        } else {
            txfUdflugterPris.setText("0,-");
        }
        txfUdflugterPris.setAlignment(Pos.BASELINE_RIGHT);
        txfUdflugterPris.setEditable(false);
        txfUdflugterPris.setFocusTraversable(false);
        txfUdflugterPris.setMouseTransparent(true);
        txfUdflugterPris.setPrefWidth(100);
        rightPane.add(txfUdflugterPris, 1, 2);

        Label lblHotelPris = new Label("Hotel:");
        rightPane.add(lblHotelPris, 0, 3);

        TextField txfHotelPris = new TextField();
        if (tilmelding.hentHotel() != null) {
            int hotelPris = tilmelding.hentHotel().hentEnkeltVærelsesPris();
            if (tilmelding.hentLedsager() != null)
                hotelPris = tilmelding.hentHotel().hentDobbeltVærelsesPris();
            txfHotelPris.setText(hotelPris + ",-");
        } else {
            txfHotelPris.setText("Ingen hotel valgt");
        }

        txfHotelPris.setAlignment(Pos.BASELINE_RIGHT);
        txfHotelPris.setEditable(false);
        txfHotelPris.setFocusTraversable(false);
        txfHotelPris.setMouseTransparent(true);
        txfHotelPris.setPrefWidth(100);
        rightPane.add(txfHotelPris, 1, 3);

        Label lblTotalPris = new Label("Total:");
        rightPane.add(lblTotalPris, 0, 4);

        TextField txfTotalPris = new TextField();
        txfTotalPris.setText(tilmelding.beregnPris() + ",-");
        txfTotalPris.setAlignment(Pos.BASELINE_RIGHT);
        txfTotalPris.setEditable(false);
        txfTotalPris.setFocusTraversable(false);
        txfTotalPris.setMouseTransparent(true);
        txfTotalPris.setPrefWidth(100);
        rightPane.add(txfTotalPris, 1, 4);

        Button btnBekræft = new Button("Bekræft tilmelding");
        btnBekræft.setPrefWidth(150);
        rightPane.add(btnBekræft, 0, 5, 2, 1);
        GridPane.setHalignment(btnBekræft, HPos.CENTER);

        btnBekræft.setOnAction(event -> {
            MinScene.opdaterFelter(tilmelding.hentDeltager());
            LoginScene.skiftTilMinScene(tilmelding.hentDeltager());
        });
    }
}
