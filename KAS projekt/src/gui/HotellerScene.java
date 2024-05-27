package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Hotel;
import model.Tilmelding;

import java.time.Period;

public class HotellerScene {
    private static Stage window;
    private static Scene forrigeScene, hotellerScene, visHotelScene, servicesScene, ordreScene;

    private final static ListView<Hotel> lvwHoteller = new ListView<>();
    private final static TextField txfHotelPris = new TextField();
    private final static TextField txfTotalPris = new TextField();
    private final static CheckBox cbxIntetHotel = new CheckBox("Intet hotel");
    private static Tilmelding tilmelding;

    public static void initHoteller(
            GridPane pane,
            Stage stage,
            Scene forrigeScene,
            Scene nuværendeScene,
            Tilmelding tilmelding
    ) {
        window = stage;
        HotellerScene.forrigeScene = forrigeScene;
        hotellerScene = nuværendeScene;
        HotellerScene.tilmelding = tilmelding;

        // Venstre side
        GridPane leftPane = new GridPane();
        Gui.gPaneDefault(leftPane);
        pane.add(leftPane, 0, 1);

        Label lblHotel = new Label("Hotel");
        lblHotel.setFont(new Font(20));
        leftPane.add(lblHotel, 0, 0, 2, 1);
        GridPane.setHalignment(lblHotel, HPos.CENTER);

        leftPane.add(cbxIntetHotel, 0, 1);

        ChangeListener<Boolean> intetHotelListener = (ov, o, n) -> hotelValgt();
        cbxIntetHotel.selectedProperty().addListener(intetHotelListener);

        lvwHoteller.getItems().setAll(Controller.hentHoteller());
        lvwHoteller.getSelectionModel().select(0);
        leftPane.add(lvwHoteller, 0, 2, 2, 1);

        ChangeListener<Hotel> hotelListener = (ov, o, n) -> valgteHotelÆndret();
        lvwHoteller.getSelectionModel().selectedItemProperty().addListener(hotelListener);

        Button btnForrige = new Button("Forrige");
        btnForrige.setPrefWidth(100);
        leftPane.add(btnForrige, 0, 3);
        GridPane.setHalignment(btnForrige, HPos.CENTER);

        Button btnInfo = new Button("Vis info");
        btnInfo.setPrefWidth(100);
        leftPane.add(btnInfo, 1, 3);
        GridPane.setHalignment(btnInfo, HPos.CENTER);

        btnInfo.setOnAction(event -> {
            Hotel valgteHotel = lvwHoteller.getSelectionModel().getSelectedItem();
            if (valgteHotel != null) {
                GridPane gridPane = new GridPane();
                visHotelScene = new Scene(gridPane);
                VisHotelScene.initVisHotel(gridPane,
                        window,
                        hotellerScene,
                        valgteHotel,
                        tilmelding
                );
                window.setScene(visHotelScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Vælg venligst et hotel først!");
                alert.show();
            }
        });


        // Højre side
        GridPane rightPane = new GridPane();
        Gui.gPaneDefault(rightPane);
        pane.add(rightPane, 2, 1);

        Label lblOplysninger = new Label("Oplysninger");
        lblOplysninger.setFont(new Font(20));
        rightPane.add(lblOplysninger, 0, 0, 2, 1);
        GridPane.setHalignment(lblOplysninger, HPos.CENTER);

        Label lblKonferencePris = new Label("Konference:");
        rightPane.add(lblKonferencePris, 0, 1);

        TextField txfKonferencePris = new TextField();
        int konferencePris = 0;
        if (!tilmelding.erForedragsholder())
            konferencePris = tilmelding.hentKonference().hentKonferenceAfgift() *
                    (Period.between(tilmelding.hentAnkomstDato(),
                            tilmelding.hentAfrejseDato()).getDays() + 1);
        txfKonferencePris.setText(konferencePris + ",-");
        txfKonferencePris.setAlignment(Pos.BASELINE_RIGHT);
        txfKonferencePris.setEditable(false);
        txfKonferencePris.setFocusTraversable(false);
        txfKonferencePris.setMouseTransparent(true);
        txfKonferencePris.setPrefWidth(100);
        rightPane.add(txfKonferencePris, 1, 1);

        Label lblUdflugterPris = new Label("Udflugter:");
        rightPane.add(lblUdflugterPris, 0, 2);

        TextField txfUdflugterPris = new TextField();
        int prisForUdflugter = 0;
        if (tilmelding.hentLedsager() != null)
            prisForUdflugter = tilmelding.hentLedsager().prisForUdflugter();
        txfUdflugterPris.setText(prisForUdflugter + ",-");
        txfUdflugterPris.setAlignment(Pos.BASELINE_RIGHT);
        txfUdflugterPris.setEditable(false);
        txfUdflugterPris.setFocusTraversable(false);
        txfUdflugterPris.setMouseTransparent(true);
        txfUdflugterPris.setPrefWidth(100);
        rightPane.add(txfUdflugterPris, 1, 2);

        Label lblHotelPris = new Label("Hotel:");
        rightPane.add(lblHotelPris, 0, 3);

        int hotelPris = lvwHoteller.getSelectionModel().getSelectedItem().hentEnkeltVærelsesPris();
        if (tilmelding.hentLedsager() != null)
            hotelPris = lvwHoteller.getSelectionModel().getSelectedItem().hentDobbeltVærelsesPris();
        txfHotelPris.setText(hotelPris + ",-");
        txfHotelPris.setAlignment(Pos.BASELINE_RIGHT);
        txfHotelPris.setEditable(false);
        txfHotelPris.setFocusTraversable(false);
        txfHotelPris.setMouseTransparent(true);
        txfHotelPris.setPrefWidth(100);
        rightPane.add(txfHotelPris, 1, 3);

        Label lblTotalPris = new Label("Total:");
        rightPane.add(lblTotalPris, 0, 4);

        txfTotalPris.setText(tilmelding.beregnPris() + hotelPris + ",-");
        txfTotalPris.setAlignment(Pos.BASELINE_RIGHT);
        txfTotalPris.setEditable(false);
        txfTotalPris.setFocusTraversable(false);
        txfTotalPris.setMouseTransparent(true);
        txfTotalPris.setPrefWidth(100);
        rightPane.add(txfTotalPris, 1, 4);

        Button btnNæste = new Button("Næste");
        btnNæste.setPrefWidth(100);
        rightPane.add(btnNæste, 0, 5, 2, 1);
        GridPane.setHalignment(btnNæste, HPos.CENTER);


        // Knappeactions

        btnForrige.setOnAction(event -> {
            cbxIntetHotel.setSelected(false);
            window.setScene(forrigeScene);
            window.centerOnScreen();
        });

        btnNæste.setOnAction(event -> {
            Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
            if (cbxIntetHotel.isSelected()) {
                GridPane gridPane = new GridPane();
                ordreScene = new Scene(gridPane);
                OrdreOversigtScene.initOrdreOversigt(gridPane, window, hotellerScene, tilmelding);
                window.setScene(ordreScene);
                window.centerOnScreen();
            } else if (hotel != null) {
                Controller.addTilmeldingTilHotel(hotel, tilmelding);

                GridPane gridPane = new GridPane();
                servicesScene = new Scene(gridPane);
                ServicesScene.initServices(gridPane,
                        window,
                        hotellerScene,
                        servicesScene,
                        tilmelding
                );
                window.setScene(servicesScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Intet hotel valgt!");
                alert.show();
            }
        });
    }

    public static void valgteHotelÆndret() {
        String hotelPris = lvwHoteller.getSelectionModel().getSelectedItem()
                .hentEnkeltVærelsesPris() + ",-";
        if (tilmelding.hentLedsager() != null)
            hotelPris = lvwHoteller.getSelectionModel().getSelectedItem()
                    .hentDobbeltVærelsesPris() + ",-";
        txfHotelPris.setText(hotelPris);
        txfTotalPris.setText(tilmelding.beregnPris() + hotelPris + ",-");
    }

    public static void hotelValgt() {
        Hotel hotel = lvwHoteller.getSelectionModel().getSelectedItem();
        int hotelPris = 0;
        if (!cbxIntetHotel.isSelected()) {
            if (tilmelding.hentLedsager() != null) {
                hotelPris = hotel.hentDobbeltVærelsesPris();
            } else {
                hotelPris = hotel.hentEnkeltVærelsesPris();
            }
        }
        txfHotelPris.setText(hotelPris + ",-");
        txfTotalPris.setText(tilmelding.beregnPris() + hotelPris + ",-");
    }
}
