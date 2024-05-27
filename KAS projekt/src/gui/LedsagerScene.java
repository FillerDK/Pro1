package gui;

import controller.Controller;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import model.Ledsager;
import model.Tilmelding;

import java.time.Period;

public class LedsagerScene {
    private static Stage window;
    private static Scene konferenceScene, ledsagerScene, udflugterScene, hotellerScene;

    public static void initLedsager(GridPane pane,
                                    Stage stage,
                                    Scene forrigeScene,
                                    Scene nuværendeScene,
                                    Tilmelding tilmelding
    ) {
        window = stage;
        konferenceScene = forrigeScene;
        ledsagerScene = nuværendeScene;

        // Venstre side
        GridPane leftPane = new GridPane();
        Gui.gPaneDefault(leftPane);
        pane.add(leftPane, 0, 1);

        Label lblLedsager = new Label("Ledsager");
        lblLedsager.setFont(new Font(20));
        leftPane.add(lblLedsager, 0, 0);
        GridPane.setHalignment(lblLedsager, HPos.CENTER);

        CheckBox cbxLedsager = new CheckBox("Ingen ledsager");
        leftPane.add(cbxLedsager, 0, 1);

        TextField txfLedsagerNavn = new TextField();
        txfLedsagerNavn.setPromptText("Ledsagernavn");
        txfLedsagerNavn.setPrefWidth(150);
        leftPane.add(txfLedsagerNavn, 0, 2);

        TextField txfTlfNr = new TextField();
        txfTlfNr.setPromptText("Tlr. nr.");
        leftPane.add(txfTlfNr, 0, 3);

        TextField txfEmail = new TextField();
        txfEmail.setPromptText("Email");
        leftPane.add(txfEmail, 0, 4);

        TextField txfAdresse = new TextField();
        txfAdresse.setPromptText("Adresse");
        leftPane.add(txfAdresse, 0, 5);

        Button btnForrige = new Button("Forrige");
        btnForrige.setPrefWidth(100);
        leftPane.add(btnForrige, 0, 6);
        GridPane.setHalignment(btnForrige, HPos.CENTER);


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

        btnForrige.setOnAction(event -> {
            Controller.fjernTilmelding(tilmelding);
            cbxLedsager.setSelected(false);
            window.setScene(konferenceScene);
            window.centerOnScreen();
        });

        btnNæste.setOnAction(event -> {
            Boolean altOK = true;
            String fejlbesked = "";

            String adresse = txfAdresse.getText().trim();
            if (adresse.equalsIgnoreCase("")) {
                altOK = false;
                fejlbesked = "Indtast venligst en adresse!";
            }

            String email = txfEmail.getText().trim();
            if (email.equalsIgnoreCase("")) {
                altOK = false;
                fejlbesked = "Indtast venligst en email";
            }

            String tlf = txfTlfNr.getText().trim();
            if (tlf.equalsIgnoreCase("")) {
                altOK = false;
                fejlbesked = "Indtast venligst et tlf. nr!";
            }

            String navn = txfLedsagerNavn.getText().trim();
            if (navn.equalsIgnoreCase("")) {
                altOK = false;
                fejlbesked = "Indtast venligst et navn!";
            }

            if (cbxLedsager.isSelected())
                altOK = true;

            if (!altOK) {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(fejlbesked);
                alert.show();
            } else {
                if (!cbxLedsager.isSelected()) {
                    Ledsager ledsager = Controller.opretLedsager(navn, tlf, email, adresse);
                    Controller.addLedsagerTilTilmelding(tilmelding, ledsager);

                    GridPane gridPane = new GridPane();
                    udflugterScene = new Scene(gridPane);
                    UdflugterScene.initUdflugter(
                            gridPane, window, ledsagerScene, udflugterScene, tilmelding
                    );
                    window.setScene(udflugterScene);
                    window.centerOnScreen();
                } else {
                    GridPane gridPane = new GridPane();
                    hotellerScene = new Scene(gridPane);
                    HotellerScene.initHoteller(
                            gridPane, window, ledsagerScene, hotellerScene, tilmelding
                    );
                    window.setScene(hotellerScene);
                    window.centerOnScreen();
                }
            }
        });
    }
}
