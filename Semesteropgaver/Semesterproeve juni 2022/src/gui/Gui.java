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
import model.Medarbejder;
import model.Vagt;
import storage.Storage;

public class Gui extends Application {
    // section S11

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("Kantinens vagtplanlægning");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene planlægningScene = new Scene(pane);

        window.setScene(planlægningScene);
        window.show();
    }

    private final ListView<Medarbejder> lvwMedarbejdere = new ListView<>();
    private final ListView<Vagt> lvwVagter = new ListView<>();
    private final TextArea txaValgtVagt = new TextArea();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblAlleMedarbejdere = new Label("Alle medarbejdere");
        pane.add(lblAlleMedarbejdere, 0, 0);

        lvwMedarbejdere.getItems().setAll(Storage.getMedarbejdere());
        lvwMedarbejdere.setPrefWidth(300);
        pane.add(lvwMedarbejdere, 0, 1);

        Label lblAlleVagter = new Label("Alle vagter");
        pane.add(lblAlleVagter, 1, 0);

        lvwVagter.getItems().setAll(Storage.getVagter());
        lvwVagter.setPrefWidth(300);
        pane.add(lvwVagter, 1, 1);

        ChangeListener<Vagt> vagtListener = (ov, o, n) -> vagtChanged();
        lvwVagter.getSelectionModel().selectedItemProperty().addListener(vagtListener);

        Button btnTildel = new Button("Tildel vagt");
        GridPane.setHalignment(btnTildel, HPos.CENTER);
        pane.add(btnTildel, 1, 2);

        Label lblValgtVagt = new Label("Valgt vagt");
        pane.add(lblValgtVagt, 2, 0);

        txaValgtVagt.setPrefWidth(300);
        pane.add(txaValgtVagt, 2, 1);

        Button btnUdskriv = new Button("Udskriv vagt til fil");
        GridPane.setHalignment(btnUdskriv, HPos.CENTER);
        pane.add(btnUdskriv, 2, 2);

        // ========== btn actions =============

        btnTildel.setOnAction(event -> tildelAction());

        btnUdskriv.setOnAction(event -> udskrivAction());

    }

    // ================ actions ===============

    private void tildelAction() {
        Medarbejder medarbejder = lvwMedarbejdere.getSelectionModel().getSelectedItem();
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        try {
            Controller.tildelVagt(medarbejder, vagt);
        } catch (RuntimeException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Vagt kan ikke tildeles");
            alert.setContentText(String.format("%ss overlappende vagter: %s",
                    medarbejder.getNavn(), vagt.getNavn()));
            alert.show();
        }
    }

    private void udskrivAction() {
        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();

        if (vagt != null) {
            Controller.udskrivVagtplan(vagt, vagt.getNavn());
        }
    }

    // =============== listeners ===============

    private void vagtChanged() {
        boolean valid = true;

        Vagt vagt = lvwVagter.getSelectionModel().getSelectedItem();
        if (vagt == null) {
            valid = false;
        } else {
            StringBuilder medarbejderStrB = new StringBuilder();
            for (Medarbejder medarbejder : vagt.getMedarbejdere()) {
                medarbejderStrB.append(medarbejder.getNavn() + " ");
            }

            StringBuilder strB = new StringBuilder();
            strB.append("Navn: " + vagt.getNavn() + "\n" +
                    "Fra: " + vagt.getTidFra() + "\n" +
                    "Til: " + vagt.getTidFra() + "\n" +
                    "Status: " + vagt.status() + "\n" +
                    "Tilknyttede medarbejdere:" + "\n" +
                    medarbejderStrB);

            txaValgtVagt.setText(strB.toString());
        }
    }
}