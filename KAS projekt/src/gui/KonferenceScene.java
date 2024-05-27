package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Deltager;
import model.Konference;
import model.Tilmelding;

import java.time.LocalDate;
import java.time.Period;

public class KonferenceScene {

    private static Stage window;
    private static Scene minScene, konferenceScene, visKonferenceScene, ledsagerScene;

    private final static ListView<Konference> lvwKonferencer = new ListView<>();
    private final static DatePicker dpAnkomst = new DatePicker();
    private final static DatePicker dpAfrejse = new DatePicker();
    private final static TextField txfKonferencePris = new TextField("0,-");
    private final static TextField txfTotalPris = new TextField("0,-");
    private final static CheckBox cbxForedragsholder = new CheckBox("Foredragsholder");

    public static void initKonferenceScene(GridPane pane,
                                           Stage stage,
                                           Scene forrigeScene,
                                           Scene nuværendeScene,
                                           Deltager deltager
    ) {
        window = stage;
        minScene = forrigeScene;
        konferenceScene = nuværendeScene;

        // Venstre side, konferencer
        GridPane leftPane = new GridPane();
        leftPane.setPadding(new Insets(20));
        leftPane.setHgap(10);
        leftPane.setVgap(10);
        leftPane.setGridLinesVisible(false);
        pane.add(leftPane, 0, 1);

        Label lblKonference = new Label("Konference");
        lblKonference.setFont(new Font(20));
        leftPane.add(lblKonference, 0, 0, 2, 1);
        GridPane.setHalignment(lblKonference, HPos.CENTER);

        lvwKonferencer.setPrefHeight(250);
        leftPane.add(lvwKonferencer, 0, 1, 2, 1);

        // Henter konferencer
        lvwKonferencer.getItems().setAll(Controller.hentKonferencer());

        ChangeListener<Konference> konferenceListener = (ov, o, n) -> valgteKonferenceÆndret();
        lvwKonferencer.getSelectionModel().selectedItemProperty().addListener(konferenceListener);

        Label lblAnkomst = new Label("Ankomstdato:");
        leftPane.add(lblAnkomst, 0, 2);

        dpAnkomst.setEditable(false);
        leftPane.add(dpAnkomst, 0, 3, 2, 1);

        Label lblAfrejse = new Label("Afrejsedato:");
        leftPane.add(lblAfrejse, 0, 4);

        dpAfrejse.setEditable(false);
        leftPane.add(dpAfrejse, 0, 5, 2, 1);

        ChangeListener<LocalDate> datoListener = (ov, o, n) -> valgtePeriodeÆndret();
        dpAnkomst.valueProperty().addListener(datoListener);
        dpAfrejse.valueProperty().addListener(datoListener);

        leftPane.add(cbxForedragsholder, 0, 6, 2, 1);

        ChangeListener<Boolean> foredragsholderListener = (ov, o, n) -> valgtePeriodeÆndret();
        cbxForedragsholder.selectedProperty().addListener(foredragsholderListener);

        Button btnTilbage = new Button("Tilbage");
        btnTilbage.setPrefWidth(75);
        leftPane.add(btnTilbage, 0, 7);
        GridPane.setHalignment(btnTilbage, HPos.CENTER);

        btnTilbage.setOnAction(event -> {
            window.setScene(KonferenceScene.minScene);
            window.centerOnScreen();
        });

        Button btnInfo = new Button("Vis info");
        btnInfo.setPrefWidth(75);
        leftPane.add(btnInfo, 1, 7);
        GridPane.setHalignment(btnInfo, HPos.CENTER);

        btnInfo.setOnAction(event -> {
            Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
            if (konference != null) {
                GridPane gridPane = new GridPane();
                visKonferenceScene = new Scene(gridPane);
                VisKonferenceScene.initVisKonf(gridPane, window, nuværendeScene, konference);
                window.setScene(visKonferenceScene);
                window.centerOnScreen();
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen konference valgt!");
                alert.show();
            }
        });


        // Højre side, oplysninger
        GridPane rightPane = new GridPane();
        Gui.gPaneDefault(rightPane);
        pane.add(rightPane, 2, 1);

        Label lblOplysninger = new Label("Oplysninger");
        lblOplysninger.setFont(new Font(20));
        rightPane.add(lblOplysninger, 0, 0, 2, 1);
        GridPane.setHalignment(lblOplysninger, HPos.CENTER);

        Label lblKonferencePris = new Label("Konference:");
        rightPane.add(lblKonferencePris, 0, 1);

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

        TextField txfHotelPris = new TextField("0,-");
        txfHotelPris.setAlignment(Pos.BASELINE_RIGHT);
        txfHotelPris.setEditable(false);
        txfHotelPris.setFocusTraversable(false);
        txfHotelPris.setMouseTransparent(true);
        txfHotelPris.setPrefWidth(100);
        rightPane.add(txfHotelPris, 1, 3);

        Label lblTotalPris = new Label("Total:");
        rightPane.add(lblTotalPris, 0, 4);

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
            Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
            if (konference != null) {
                if (((dpAnkomst.getValue().isBefore(dpAfrejse.getValue())) ||
                        dpAnkomst.getValue().equals(dpAfrejse.getValue())) &&
                        dpAnkomst.getValue().isAfter(
                                konference.hentStartDato().minusDays(1)) &&
                        dpAfrejse.getValue().isBefore(
                                konference.hentSlutDato().plusDays(1))) {
                    boolean foredragsholder = cbxForedragsholder.isSelected();
                    LocalDate ankomstDato = dpAnkomst.getValue();
                    LocalDate afrejseDato = dpAfrejse.getValue();
                    Tilmelding tilmelding = Controller.opretTilmelding(
                            foredragsholder, ankomstDato, afrejseDato, deltager, konference
                    );

                    GridPane gridPane = new GridPane();
                    ledsagerScene = new Scene(gridPane);
                    LedsagerScene.initLedsager(
                            gridPane, window, konferenceScene, ledsagerScene, tilmelding
                    );
                    window.setScene(ledsagerScene);
                    window.centerOnScreen();
                } else {
                    Alert alert = new Alert(Alert.AlertType.ERROR);
                    alert.setHeaderText("Vælg venligst gyldige datoer!");
                    alert.show();
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Ingen konference valgt!");
                alert.show();
            }
        });
    }

    private static void valgteKonferenceÆndret() {
        opdaterFelter();
    }

    private static void opdaterFelter() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            dpAnkomst.setValue(konference.hentStartDato());
            dpAfrejse.setValue(konference.hentSlutDato());
            int days = Period.between(dpAnkomst.getValue(), dpAfrejse.getValue()).getDays() + 1;
            int konferenceAfgift = konference.hentKonferenceAfgift();
            int totalKonferencePris = konferenceAfgift * days;
            txfKonferencePris.setText(totalKonferencePris + ",-");
            int total = totalKonferencePris;
            txfTotalPris.setText(total + ",-");
        }
    }

    private static void valgtePeriodeÆndret() {
        Konference konference = lvwKonferencer.getSelectionModel().getSelectedItem();
        if (konference != null) {
            if (dpAnkomst.getValue() == null || dpAfrejse.getValue() == null) {

            } else {
                int days = Period.between(dpAnkomst.getValue(), dpAfrejse.getValue()).getDays() + 1;
                int konferenceAfgift = 0;
                if (!cbxForedragsholder.isSelected()) {
                    konferenceAfgift = konference.hentKonferenceAfgift();
                }
                int totalKonferencePris = konferenceAfgift * days;
                txfKonferencePris.setText(totalKonferencePris + ",-");
                int total = totalKonferencePris;
                txfTotalPris.setText(total + ",-");
            }
        }
    }
}
