package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Tilmelding;
import model.Udflugt;

import java.time.Period;

public class UdflugterScene {
    private static Stage window;
    private static Scene udflugterScene, ledsagerScene, visUdflugtScene, hotellerScene;
    private static Tilmelding tilmelding;

    private final static ListView<Udflugt> lvwAlleUdflugter = new ListView<>();
    private final static ListView<Udflugt> lvwValgteUdflugter = new ListView<>();

    public static void initUdflugter(GridPane pane,
                                     Stage stage,
                                     Scene forrigeScene,
                                     Scene nuværendeScene,
                                     Tilmelding tilmelding
    ) {
        window = stage;
        ledsagerScene = forrigeScene;
        udflugterScene = nuværendeScene;
        UdflugterScene.tilmelding = tilmelding;
        // Venstre side
        GridPane leftPane = new GridPane();
        Gui.gPaneDefault(leftPane);
        pane.add(leftPane, 0, 1);

        Label lblUdflugter = new Label("Udflugter");
        lblUdflugter.setFont(new Font(20));
        leftPane.add(lblUdflugter, 0, 0, 2, 1);
        GridPane.setHalignment(lblUdflugter, HPos.CENTER);


        // Alle udflugter
        Label lblAlleUdflugter = new Label("Alle udflugter:");
        leftPane.add(lblAlleUdflugter, 0, 1);

        lvwAlleUdflugter.getItems().setAll(tilmelding.hentKonference().hentUdflugter());
        leftPane.add(lvwAlleUdflugter, 0, 2);

        Button btnTilføj = new Button("Tilføj");
        btnTilføj.setPrefWidth(100);
        leftPane.add(btnTilføj, 0, 3);
        GridPane.setHalignment(btnTilføj, HPos.CENTER);

        Button btnForrige = new Button("Forrige");
        btnForrige.setPrefWidth(100);
        leftPane.add(btnForrige, 0, 4);
        GridPane.setHalignment(btnForrige, HPos.CENTER);

        btnForrige.setOnAction(event -> {
            Controller.fjernLedsagerFraTilmelding(tilmelding, tilmelding.hentLedsager());
            window.setScene(ledsagerScene);
            window.centerOnScreen();
        });

        // Valgte udflugter
        Label lblValgteUdflugter = new Label("Alle udflugter:");
        leftPane.add(lblValgteUdflugter, 1, 1);

        leftPane.add(lvwValgteUdflugter, 1, 2);

        Button btnFjern = new Button("Fjern");
        btnFjern.setPrefWidth(100);
        leftPane.add(btnFjern, 1, 3);
        GridPane.setHalignment(btnFjern, HPos.CENTER);

        Button btnInfo = new Button("Vis info");
        btnInfo.setPrefWidth(100);
        leftPane.add(btnInfo, 1, 4);
        GridPane.setHalignment(btnInfo, HPos.CENTER);

        btnInfo.setOnAction(event -> {
            Udflugt udflugt = lvwAlleUdflugter.getSelectionModel().getSelectedItem();
            if (udflugt != null) {
                GridPane gridPane = new GridPane();
                visUdflugtScene = new Scene(gridPane);
                VisUdflugtScene.initVisUdflugt(gridPane, window, udflugterScene, udflugt);
                window.setScene(visUdflugtScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen udflugt valgt!");
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
                    (Period.between(
                            tilmelding.hentAnkomstDato(),
                            tilmelding.hentAfrejseDato()).getDays() + 1
                    );
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
        txfUdflugterPris.setText(tilmelding.hentLedsager().prisForUdflugter() + ",-");
        txfUdflugterPris.setAlignment(Pos.BASELINE_RIGHT);
        txfUdflugterPris.setEditable(false);
        txfUdflugterPris.setFocusTraversable(false);
        txfUdflugterPris.setMouseTransparent(true);
        txfUdflugterPris.setPrefWidth(100);
        rightPane.add(txfUdflugterPris, 1, 2);

        Label lblHotelPris = new Label("Hotel:");
        rightPane.add(lblHotelPris, 0, 3);

        TextField txfHotelPris = new TextField("0,-");
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

        Button btnNæste = new Button("Næste");
        btnNæste.setPrefWidth(100);
        rightPane.add(btnNæste, 0, 5, 2, 1);
        GridPane.setHalignment(btnNæste, HPos.CENTER);


        // Knapper
        btnTilføj.setOnAction(event -> {
            Udflugt udflugt = lvwAlleUdflugter.getSelectionModel().getSelectedItem();
            if (udflugt != null) {
                Controller.addLedsagerTilUdflugt(udflugt, tilmelding.hentLedsager());
                lvwValgteUdflugter.getItems().add(
                        lvwAlleUdflugter.getSelectionModel().getSelectedItem()
                );
                lvwAlleUdflugter.getItems().remove(
                        lvwAlleUdflugter.getSelectionModel().getSelectedItem()
                );
                txfUdflugterPris.setText(tilmelding.hentLedsager().prisForUdflugter() + ",-");
                txfTotalPris.setText(tilmelding.beregnPris() + ",-");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen udflugt er valgt!");
                alert.show();
            }
        });

        btnFjern.setOnAction(event -> {
            Udflugt udflugt = lvwValgteUdflugter.getSelectionModel().getSelectedItem();
            if (udflugt != null) {
                Controller.fjernLedsagerFraUdflugt(udflugt, tilmelding.hentLedsager());
                lvwAlleUdflugter.getItems().add(
                        lvwValgteUdflugter.getSelectionModel().getSelectedItem()
                );
                lvwValgteUdflugter.getItems().remove(
                        lvwValgteUdflugter.getSelectionModel().getSelectedItem()
                );
                txfUdflugterPris.setText(tilmelding.hentLedsager().prisForUdflugter() + ",-");
                txfTotalPris.setText(tilmelding.beregnPris() + ",-");
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen udflugt er valgt!");
                alert.show();
            }
        });

        btnNæste.setOnAction(event -> {
            GridPane gridPane = new GridPane();
            hotellerScene = new Scene(gridPane);
            HotellerScene.initHoteller(gridPane, window, udflugterScene, hotellerScene, tilmelding);
            window.setScene(hotellerScene);
            window.centerOnScreen();
        });
    }

    public static void opdaterFelter() {
        lvwValgteUdflugter.getItems().clear();
        lvwAlleUdflugter.getItems().setAll(tilmelding.hentLedsager().hentUdflugter());
    }
}
