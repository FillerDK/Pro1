package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Bestilling;
import model.Forestilling;
import model.Kunde;
import model.Plads;
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;

public class Gui extends Application {
    // section S12

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("Teater bestilling");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene teaterBestillingScene = new Scene(pane);

        window.setScene(teaterBestillingScene);
        window.show();
    }
    // Forestillinger
    private final ListView<Forestilling> lvwForestillinger = new ListView<>();

    // Kunder
    private final ListView<Kunde> lvwKunder = new ListView<>();
    private final TextField txfKundeNavn = new TextField();
    private final TextField txfKundeMobil = new TextField();

    // Dato
    private final TextField txfDato = new TextField();
    private final TextArea txaBestiltePladser = new TextArea();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // Forestillinger
        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);

        lvwForestillinger.getItems().setAll(Storage.getForestillinger());
        lvwForestillinger.setPrefWidth(300);
        pane.add(lvwForestillinger, 0, 1, 1, 4);

        // Kunder
        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 1, 0);

        lvwKunder.getItems().setAll(Storage.getKunder());
        lvwKunder.setPrefWidth(300);
        pane.add(lvwKunder, 1, 1, 1, 4);

        Label lblKundeNavn = new Label("Kunde navn:");
        pane.add(lblKundeNavn, 1, 5);

        txfKundeNavn.setPrefWidth(300);
        pane.add(txfKundeNavn, 1, 6);

        Label lblKundeMobil = new Label("Kunde mobil:");
        pane.add(lblKundeMobil, 1, 7);

        txfKundeMobil.setPrefWidth(300);
        pane.add(txfKundeMobil, 1, 8);

        Button btnOpret = new Button("Opret kunde");
        GridPane.setHalignment(btnOpret, HPos.CENTER);
        pane.add(btnOpret, 1, 9);

        // Dato
        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 2, 0);

        txfDato.setPrefWidth(300);
        pane.add(txfDato, 2, 1);

        Button btnVis = new Button("Vis bestilte pladser");
        GridPane.setHalignment(btnVis, HPos.CENTER);
        pane.add(btnVis, 2, 2);

        Label lblBestiltePladser = new Label("Bestilte pladser");
        pane.add(lblBestiltePladser, 2, 3);

        txaBestiltePladser.setPrefWidth(300);
        txaBestiltePladser.setEditable(false);
        pane.add(txaBestiltePladser, 2, 4);

        // button actions
        btnOpret.setOnAction(event -> opretAction());

        btnVis.setOnAction(event -> visAction());

    }

    private void visAction() {
        boolean validInput = true;

        Forestilling forestilling = lvwForestillinger.getSelectionModel().getSelectedItem();
        if (forestilling == null) {
            validInput = false;
        }

        Kunde kunde = lvwKunder.getSelectionModel().getSelectedItem();
        if (kunde == null) {
            validInput = false;
        }

        LocalDate dato = null;
        try {
            dato = LocalDate.parse(txfDato.getText());
        } catch (DateTimeParseException ex){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText("Dato er ikke i rigtigt format!");
            alert.setContentText("Prøv med en ny dato!");
            alert.show();
        }

        if (validInput) {
            StringBuilder str = new StringBuilder();
            for (Plads plads : kunde.bestiltePladserTilForestillingPåDag(forestilling, dato)) {
                str.append(String.format("Række: %d, nr: %d, kr %d\n", plads.getRække(), plads.getNr(), plads.getPris()));
            }
            txaBestiltePladser.setText(str.toString());
        }
    }

    public void opretAction() {
        boolean validInput = true;

        String navn = txfKundeNavn.getText().trim();
        if (navn.isBlank()) {
            validInput = false;
        }

        String mobil = txfKundeMobil.getText().trim();
        if (mobil.isBlank()) {
            validInput = false;
        }

        if (validInput) {
            Controller.opretKunde(navn, mobil);
            opdaterFelterKunde();
        }
    }

    public void opdaterFelterKunde() {
        lvwKunder.getItems().setAll(Storage.getKunder());
        txfKundeNavn.setText("");
        txfKundeMobil.setText("");
    }
}


