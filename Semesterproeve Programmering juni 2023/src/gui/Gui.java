package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bane;
import model.Booking;
import model.Spiller;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Gui extends Application {
    // section S11

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("Bane bookings");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene bookingsScene = new Scene(pane);

        window.setScene(bookingsScene);
        window.show();
    }

    private final ListView<Bane> lvwBaner = new ListView<>();
    private final TextArea txaAntalBookninger = new TextArea();
    private final ListView<Spiller> lvwSpillere = new ListView<>();
    private final TextArea txaSpillerBookinger = new TextArea();
    private final TextField txfDato = new TextField();
    private final TextField txfTid = new TextField();
    private final CheckBox cbxSingle = new CheckBox("Single");

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setVgap(10);
        pane.setHgap(10);

        Label lblBaner = new Label("Baner");
        pane.add(lblBaner, 0, 0);

        lvwBaner.getItems().setAll(Controller.getBaner());
        pane.add(lvwBaner, 0, 1);

        ChangeListener<Bane> baneListener = (ov, o, n) -> valgteBane();
        lvwBaner.getSelectionModel().selectedItemProperty().addListener(baneListener);

        Label lblAntalBookinger = new Label("Antal bookinger på banen");
        pane.add(lblAntalBookinger, 0, 2);

        txaAntalBookninger.setPrefWidth(300);
        txaAntalBookninger.setEditable(false);
        pane.add(txaAntalBookninger, 0, 3, 1, 5);

        Label lblSpillere = new Label("Spillere");
        pane.add(lblSpillere, 1, 0);

        lvwSpillere.getItems().setAll(Controller.getSpillere());
        lvwSpillere.setPrefWidth(150);
        pane.add(lvwSpillere, 1, 1);

        ChangeListener<Spiller> spillerListener = (ov, o, n) -> valgteSpiller();
        lvwSpillere.getSelectionModel().selectedItemProperty().addListener(spillerListener);

        Label lblSpillerBookninger = new Label("Spillerens bookninger");
        pane.add(lblSpillerBookninger, 2, 0, 2, 1);

        txaSpillerBookinger.setPrefWidth(300);
        txaSpillerBookinger.setEditable(false);
        pane.add(txaSpillerBookinger, 2, 1, 2, 1);

        Label lblOpretBookning = new Label("Opret booking:");
        pane.add(lblOpretBookning, 2, 2);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 2, 3);

        pane.add(txfDato, 3, 3);

        Label lblTid = new Label("Tid:");
        pane.add(lblTid, 2, 4);

        pane.add(txfTid, 3, 4);

        pane.add(cbxSingle, 3, 5);

        Button btnBook = new Button("Book bane til spiller");
        pane.add(btnBook, 2, 6, 2, 1);

        btnBook.setOnAction(event -> opretBooking());
    }

    private void valgteSpiller() {
        opdaterSpillerBookinger();
    }

    private void opdaterSpillerBookinger() {
        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        ArrayList<Booking> bookinger = spiller.getBookinger();
        if (!bookinger.isEmpty())
            txaSpillerBookinger.setText(bookinger.get(0).toString() + "\n");
        else txaSpillerBookinger.setText("");
        for (int i = 1; i < bookinger.size(); i++) {
            txaSpillerBookinger.setText(txaSpillerBookinger.getText() +
                    bookinger.get(i).toString() + "\n");
        }
    }

    private void valgteBane() {
        opdaterAntalBookinger();
    }

    private void opdaterAntalBookinger() {
        txaAntalBookninger.setText("");
        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        ArrayList<Booking> bookinger = bane.getBookinger();
        if (bookinger.isEmpty())
            txaAntalBookninger.setText("");

        int tidStart = bane.getFørsteTid().getHour();
        int tidSlut = bane.getSidsteTid().getHour();

        int[] antalBookinger = new int[tidSlut + 1];
        for (Booking booking : bane.getBookinger()) {
            int tid = booking.getTid().getHour();
            antalBookinger[tid]++;
        }

        for (int i = tidStart; i <= tidSlut; i++) {
            String bookForm = String.format("Tid: %-4dantal:%d", i, antalBookinger[i]);
            txaAntalBookninger.setText(txaAntalBookninger.getText() + bookForm + "\n");
        }
    }

    private void opretBooking() {
        boolean validInput = true;

        /* Kunne ikke få dato og tid konverteret til hhv.
         * LocalDate og LocalTime.
         */
        /*LocalDate dato = txfDato.getText();
        LocalTime tid = txfTid;*/
        boolean single;
        if (cbxSingle.isSelected())
            single = true;
        else single = false;
        Spiller spiller = lvwSpillere.getSelectionModel().getSelectedItem();
        if (spiller == null) {
            validInput = false;
            System.out.println("Ingen spiller valgt!");
        }

        Bane bane = lvwBaner.getSelectionModel().getSelectedItem();
        /* Fejlmeddelelse for bane ikke ledig, virker ikke da jeg ikke kunne
         * få dato og tid konverteret til hhv. LocalDate og LocalTime.
         */
        /*if (!bane.tidLedig(dato, tid)) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Booking blev ikke oprettet!");
            alert.setContentText("Bane på dette tidspunkt er ikke ledig!");
            alert.show();
        }*/
        if (bane == null) {
            validInput = false;
            System.out.println("Ingen bane valgt!");
        }

        if (validInput) {
            //Controller.opretBooking(dato, tid, single, spiller, bane);
            txfDato.setText("");
            txfTid.setText("");
            cbxSingle.setSelected(false);
            opdaterAntalBookinger();
            opdaterSpillerBookinger();
        }
    }
}
