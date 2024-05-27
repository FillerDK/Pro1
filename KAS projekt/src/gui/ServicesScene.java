package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.*;

public class ServicesScene {
    private static Stage window;
    private static Scene hotellerScene, servicesScene, ordreScene, visServiceScene;

    private final static ListView<Service> lvwAlleServices = new ListView<>();
    private final static ListView<Service> lvwValgteServices = new ListView<>();
    private final static TextField txfHotelPris = new TextField();
    private final static TextField txfTotalPris = new TextField();
    private static Tilmelding tilmelding;
    private static int servicePris = 0;

    public static void initServices(GridPane pane,
                                    Stage stage,
                                    Scene forrigeScene,
                                    Scene nuværendeScene,
                                    Tilmelding tilmelding
    ) {
        window = stage;
        hotellerScene = forrigeScene;
        servicesScene = nuværendeScene;
        ServicesScene.tilmelding = tilmelding;

        // Venstre side
        GridPane leftPane = new GridPane();
        Gui.gPaneDefault(leftPane);
        pane.add(leftPane, 0, 1);

        Label lblService = new Label("Ekstra services");
        lblService.setFont(new Font(20));
        leftPane.add(lblService, 0, 0, 2, 1);
        GridPane.setHalignment(lblService, HPos.CENTER);


        // Alle services
        Label lblAlleServices = new Label("Alle services:");
        leftPane.add(lblAlleServices, 0, 1);

        lvwAlleServices.getItems().setAll(tilmelding.hentHotel().hentServices());
        leftPane.add(lvwAlleServices, 0, 2);

        Button btnTilføj = new Button("Tilføj");
        btnTilføj.setPrefWidth(100);
        leftPane.add(btnTilføj, 0, 3);
        GridPane.setHalignment(btnTilføj, HPos.CENTER);

        btnTilføj.setOnAction(event -> {
            Service service = lvwAlleServices.getSelectionModel().getSelectedItem();
            Controller.addServiceTilTilmelding(tilmelding, service);
            lvwValgteServices.getItems().add(service);
            lvwAlleServices.getItems().remove(service);

            Hotel hotel = tilmelding.hentHotel();
            int hotelPris = 0;
            if (tilmelding.hentLedsager() != null) {
                hotelPris = hotel.hentDobbeltVærelsesPris();
            } else {
                hotelPris = hotel.hentEnkeltVærelsesPris();
            }
            servicePris += service.hentPris();
            txfHotelPris.setText(hotelPris + servicePris + ",-");
            txfTotalPris.setText(tilmelding.beregnPris() + ",-");
        });

        Button btnForrige = new Button("Forrige");
        btnForrige.setPrefWidth(100);
        leftPane.add(btnForrige, 0, 4);
        GridPane.setHalignment(btnForrige, HPos.CENTER);

        btnForrige.setOnAction(event -> {
            Controller.fjernTilmeldingFraHotel(tilmelding);
            Controller.fjernServicesFraTilmelding(tilmelding);
            window.setScene(hotellerScene);
            window.centerOnScreen();
        });


        // Valgte services
        Label lblValgteServices = new Label("Valgte services");
        leftPane.add(lblValgteServices, 1, 1);

        leftPane.add(lvwValgteServices, 1, 2);

        Button btnFjern = new Button("Fjern");
        btnFjern.setPrefWidth(100);
        leftPane.add(btnFjern, 1, 3);
        GridPane.setHalignment(btnFjern, HPos.CENTER);

        btnFjern.setOnAction(event -> {
            Service service = lvwValgteServices.getSelectionModel().getSelectedItem();
            Controller.fjernServiceFraTilmelding(tilmelding, service);
            lvwAlleServices.getItems().add(service);
            lvwValgteServices.getItems().remove(service);

            Hotel hotel = tilmelding.hentHotel();
            int hotelPris = 0;
            if (tilmelding.hentLedsager() != null) {
                hotelPris = hotel.hentDobbeltVærelsesPris();
            } else {
                hotelPris = hotel.hentEnkeltVærelsesPris();
            }
            servicePris -= service.hentPris();
            txfHotelPris.setText(hotelPris + servicePris + ",-");
            txfTotalPris.setText(tilmelding.beregnPris() + ",-");
        });

        Button btnInfo = new Button("Vis info");
        btnInfo.setPrefWidth(100);
        leftPane.add(btnInfo, 1, 4);
        GridPane.setHalignment(btnInfo, HPos.CENTER);

        btnInfo.setOnAction(event -> {
            Service valgteService = lvwAlleServices.getSelectionModel().getSelectedItem();
            if (valgteService != null) {
                GridPane gridPane = new GridPane();
                visServiceScene = new Scene(gridPane);
                VisServiceScene.initVisService(gridPane, window, servicesScene, valgteService);
                window.setScene(ordreScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen service valgt");
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

        TextField txfKonferencePris = new TextField("0,-");
        txfKonferencePris.setAlignment(Pos.BASELINE_RIGHT);
        txfKonferencePris.setEditable(false);
        txfKonferencePris.setFocusTraversable(false);
        txfKonferencePris.setMouseTransparent(true);
        txfKonferencePris.setPrefWidth(100);
        rightPane.add(txfKonferencePris, 1, 1);

        Label lblUdflugterPris = new Label("Udflugter:");
        rightPane.add(lblUdflugterPris, 0, 2);

        TextField txfUdflugterPris = new TextField("0,-");
        txfUdflugterPris.setAlignment(Pos.BASELINE_RIGHT);
        txfUdflugterPris.setEditable(false);
        txfUdflugterPris.setFocusTraversable(false);
        txfUdflugterPris.setMouseTransparent(true);
        txfUdflugterPris.setPrefWidth(100);
        rightPane.add(txfUdflugterPris, 1, 2);

        Label lblHotelPris = new Label("Hotel:");
        rightPane.add(lblHotelPris, 0, 3);

        int hotelPris = tilmelding.hentHotel().hentEnkeltVærelsesPris();
        if (tilmelding.hentLedsager() != null)
            hotelPris = tilmelding.hentHotel().hentDobbeltVærelsesPris();
        txfHotelPris.setText(hotelPris + ",-");
        txfHotelPris.setAlignment(Pos.BASELINE_RIGHT);
        txfHotelPris.setEditable(false);
        txfHotelPris.setFocusTraversable(false);
        txfHotelPris.setMouseTransparent(true);
        txfHotelPris.setPrefWidth(100);
        rightPane.add(txfHotelPris, 1, 3);

        Label lblTotalPris = new Label("Total:");
        rightPane.add(lblTotalPris, 0, 4);

        txfTotalPris.setText(tilmelding.beregnPris() + ",-");
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

        btnNæste.setOnAction(event -> {
            GridPane gridPane = new GridPane();
            ordreScene = new Scene(gridPane);
            OrdreOversigtScene.initOrdreOversigt(gridPane, window, servicesScene, tilmelding);
            window.setScene(ordreScene);
            window.centerOnScreen();
        });
    }

    public static void opdaterFelter() {
        lvwValgteServices.getItems().clear();
        lvwAlleServices.getItems().setAll(tilmelding.hentHotel().hentServices());
    }
}
