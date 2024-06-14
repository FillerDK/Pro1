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
import model.Deltager;
import model.Hold;
import model.Tur;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Gui extends Application {
    // section S11

    @Override
    public void start(Stage mainStage) {
        mainStage.setTitle("Vi cykler til Sønderhøj");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene mainScene = new Scene(pane);

        mainStage.setScene(mainScene);
        mainStage.show();

        holdOpretVindue = new HoldOpretVindue("Opret hold", mainStage);
    }

    // hold
    private final ListView<Hold> lvwHold = new ListView<>();

    // deltager
    private final ListView<Deltager> lvwDeltagere = new ListView<>();
    private final Label lblValgtDeltager = new Label("Valgt deltager: ");
    private final Label lblDeltagerKm = new Label("Km i alt: ");
    private final Label lblDeltagerMinutter = new Label("Minutter i alt: ");

    // tur
    private final ListView<Tur> lvwTure = new ListView<>();
    private final TextField txfTurDato = new TextField();
    private final TextField txfTurMinutter = new TextField();
    private final TextField txfTurKm = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);


        // hold
        Label lblHold = new Label("Hold");
        pane.add(lblHold, 0, 0);

        lvwHold.getItems().setAll(Controller.getHold());
        lvwHold.setPrefWidth(300);
        pane.add(lvwHold, 0, 1);

        ChangeListener<Hold> holdListener = (ov, o, n) -> holdÆndret();
        lvwHold.getSelectionModel().selectedItemProperty().addListener(holdListener);

        Button btnOpretHold = new Button("Opret hold");
        GridPane.setHalignment(btnOpretHold, HPos.CENTER);
        pane.add(btnOpretHold, 0, 2);

        btnOpretHold.setOnAction(event -> opretHoldAction());

        Button btnFjernHold = new Button("Fjern hold");
        GridPane.setHalignment(btnFjernHold, HPos.CENTER);
        pane.add(btnFjernHold, 0, 3);

        btnFjernHold.setOnAction(event -> fjernHoldAction());


        // deltager
        Label lblDeltagere = new Label("Deltagerre");
        pane.add(lblDeltagere, 1, 0);

        lvwDeltagere.setPrefWidth(300);
        pane.add(lvwDeltagere, 1, 1);

        ChangeListener<Deltager> deltagereListener = (ov, o, n) -> deltagerÆndret();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(deltagereListener);

        pane.add(lblValgtDeltager, 1, 2);

        pane.add(lblDeltagerKm, 1, 3);

        pane.add(lblDeltagerMinutter, 1, 4);

        Button btnFjernDeltager = new Button("Fjern deltager");
        GridPane.setHalignment(btnFjernDeltager, HPos.CENTER);
        pane.add(btnFjernDeltager, 1, 5);

        btnFjernDeltager.setOnAction(event -> fjernDeltagerAction());


        // tur
        Label lblTure = new Label("Ture");
        pane.add(lblTure, 2, 0);

        lvwTure.setPrefWidth(300);
        lvwTure.setEditable(false);
        lvwTure.setFocusTraversable(false);
        lvwTure.setMouseTransparent(true);
        pane.add(lvwTure, 2, 1, 2, 1);

        Label lblTurDato = new Label("Tur dato:");
        pane.add(lblTurDato, 2, 2);

        txfTurDato.setPrefWidth(300);
        txfTurDato.setPromptText("yyyy-mm-dd");
        pane.add(txfTurDato, 3, 2);

        Label lblTurMinutter = new Label("Tur minutter:");
        pane.add(lblTurMinutter, 2, 3);

        txfTurMinutter.setPrefWidth(300);
        txfTurMinutter.setPromptText("antal minutter");
        pane.add(txfTurMinutter, 3, 3);

        Label lblTurKm = new Label("Tur km:");
        pane.add(lblTurKm, 2, 4);

        txfTurKm.setPrefWidth(300);
        txfTurKm.setPromptText("antal km");
        pane.add(txfTurKm, 3, 4);

        Button btnOpretTur = new Button("Opret tur");
        GridPane.setHalignment(btnOpretTur, HPos.CENTER);
        pane.add(btnOpretTur, 3, 5);

        btnOpretTur.setOnAction(event -> opretTurAction());

    }

    // ================= btn action ==============

    HoldOpretVindue holdOpretVindue;

    private void opretHoldAction() {
        holdOpretVindue.showAndWait();

        lvwHold.getItems().setAll(Controller.getHold());
    }

    private void fjernHoldAction() {
        Hold hold = lvwHold.getSelectionModel().getSelectedItem();

        if (hold != null) {
            Controller.fjernHold(hold);
            lvwHold.getItems().setAll(Controller.getHold());
            lvwDeltagere.getItems().setAll();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ingen hold valgt!");
            alert.show();
        }

    }

    private void fjernDeltagerAction() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        Hold hold = lvwHold.getSelectionModel().getSelectedItem();

        if (deltager != null) {
            Controller.fjernDeltager(deltager, hold);
            lvwDeltagere.getItems().setAll(hold.getDeltagere());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Ingen deltager valgt!");
            alert.show();
        }
    }

    private void opretTurAction() {
        boolean valid = true;
        String fejlbesked = "";

        int km = 0;
        try {
            km = Integer.parseInt(txfTurKm.getText().trim());
        } catch (NumberFormatException ex) {
            valid = false;
            if (txfTurKm.getText().isBlank()) {
                fejlbesked = "Indtast venligst et km antal!";
            } else {
                fejlbesked = "Det indtastede er ikke et tal!";
            }
        }

        int minutter = 0;
        try {
            minutter = Integer.parseInt(txfTurMinutter.getText().trim());
        } catch (NumberFormatException ex) {
            valid = false;
            if (txfTurMinutter.getText().isBlank()) {
                fejlbesked = "Indtast venligst et minut antal!";
            } else {
                fejlbesked = "Det indtastede er ikke et tal!";
            }
        }

        LocalDate dato = null;
        try {
            dato = LocalDate.parse(txfTurDato.getText().trim());
        } catch (DateTimeParseException ex) {
            valid = false;
            if (txfTurDato.getText().isBlank()) {
                fejlbesked = "Indtast venligst en dato!";
            } else {
                fejlbesked = "Det indtastede kunne ikke formateres til en dato!\n" +
                             "Brug venligst formatet yyyy-mm-dd!";
            }
        }

        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager == null) {
            valid = false;
            fejlbesked = "Ingen deltager valgt!";
        }

        if (valid) {
            Controller.createTur(dato, minutter, km, deltager);
            opdaterFelter();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Input mangler eller er indtastet forkert!");
            alert.setContentText(fejlbesked);
            alert.show();
        }
    }

    private void opdaterFelter() {
        txfTurDato.setText("");
        txfTurMinutter.setText("");
        txfTurKm.setText("");
        opdaterDeltagerLabels();
    }

    // changelistener metoder
    private void holdÆndret() {
        Hold hold = lvwHold.getSelectionModel().getSelectedItem();

        if (hold != null)
            lvwDeltagere.getItems().setAll(hold.getDeltagere());

        opdaterDeltagerLabels();
    }

    private void deltagerÆndret() {
        opdaterDeltagerLabels();
    }

    private void opdaterDeltagerLabels() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();

        if (deltager != null) {
            lvwTure.getItems().setAll(Controller.getTure(deltager));
            lblValgtDeltager.setText("Valgt deltager: " + deltager.getNavn());
            lblDeltagerKm.setText("Km i alt: " + deltager.kmIAlt());
            lblDeltagerMinutter.setText("Minutter i alt: " + deltager.minIAlt());
        } else {
            lvwTure.getItems().setAll();
            lblValgtDeltager.setText("Valgt deltager:");
            lblDeltagerKm.setText("Km i alt:");
            lblDeltagerMinutter.setText("Minutter i alt:");
        }
    }
}