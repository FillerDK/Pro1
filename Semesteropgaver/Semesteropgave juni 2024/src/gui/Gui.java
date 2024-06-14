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
import storage.Storage;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;

public class Gui extends Application {
    // section S11

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("Vi cykler til Sønderhøj");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene mainScene = new Scene(pane);

        window.setScene(mainScene);
        window.show();
    }

    // hold
    private final ListView<Hold> lvwHold = new ListView<>();

    // deltager
    private final ListView<Deltager> lvwDeltagere = new ListView<>();
    private Label lblValgtDeltager = new Label("Valgt deltager: ");
    private Label lblDeltagerKm = new Label("Km i alt: ");
    private Label lblDeltagerMinutter = new Label("Minutter i alt: ");

    // tur
    private final ListView<Tur> lvwTure = new ListView<>();
    private final TextField txfTurDato = new TextField();
    private final TextField txfTurMinutter = new TextField();
    private final TextField txfTurKm = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblHold = new Label("Hold");
        pane.add(lblHold, 0, 0);

        lvwHold.getItems().setAll(Storage.getHold());
        lvwHold.setPrefWidth(300);
        pane.add(lvwHold, 0, 1);

        ChangeListener<Hold> holdListener = (ov, o, n) -> holdÆndret();
        lvwHold.getSelectionModel().selectedItemProperty().addListener(holdListener);

        Label lblDeltagere = new Label("Deltagerre");
        pane.add(lblDeltagere, 1, 0);

        lvwDeltagere.setPrefWidth(300);
        pane.add(lvwDeltagere, 1, 1);

        ChangeListener<Deltager> deltagereListener = (ov, o, n) -> deltagerÆndret();
        lvwDeltagere.getSelectionModel().selectedItemProperty().addListener(deltagereListener);

        pane.add(lblValgtDeltager, 1, 2);

        pane.add(lblDeltagerKm, 1, 3);

        pane.add(lblDeltagerMinutter, 1, 4);

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
        pane.add(txfTurDato, 3, 2);

        Label lblTurMinutter = new Label("Tur minutter:");
        pane.add(lblTurMinutter, 2, 3);

        txfTurMinutter.setPrefWidth(300);
        pane.add(txfTurMinutter, 3, 3);

        Label lblTurKm = new Label("Tur km:");
        pane.add(lblTurKm, 2, 4);

        txfTurKm.setPrefWidth(300);
        pane.add(txfTurKm, 3, 4);

        Button btnOpret = new Button("Opret tur");
        GridPane.setHalignment(btnOpret, HPos.CENTER);
        pane.add(btnOpret, 3, 5);

        btnOpret.setOnAction(event -> opretAction());

    }

    // btn action
    private void opretAction() {
        boolean valid = true;

        int km = 0;
        try {
            km = Integer.parseInt(txfTurKm.getText().trim());
        } catch (NumberFormatException ex) {
            valid = false;
            System.out.println("Dette er ikke et tal!");
        }

        int minutter = 0;
        try {
            minutter = Integer.parseInt(txfTurMinutter.getText().trim());
        } catch (NumberFormatException ex) {
            valid = false;
            System.out.println("Dette er ikke et tal!");
        }

        LocalDate dato = null;
        try {
            dato = LocalDate.parse(txfTurDato.getText().trim());
        } catch (DateTimeParseException ex) {
            valid = false;
            System.out.println("Kunne ikke formateres til en dato!");
        }

        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        if (deltager == null) {
            valid = false;
        }

        if (valid) {
            Controller.createTur(dato, minutter, km, deltager);
            opdaterFelter();
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

        lvwDeltagere.getItems().setAll(hold.getDeltagere());
    }

    private void deltagerÆndret() {
        opdaterDeltagerLabels();
    }

    private void opdaterDeltagerLabels() {
        Deltager deltager = lvwDeltagere.getSelectionModel().getSelectedItem();
        lvwTure.getItems().setAll(deltager.getTure());
        lblValgtDeltager.setText("Valgt deltager: " + deltager.getNavn());
        lblDeltagerKm.setText("Km i alt: " + deltager.kmIAlt());
        lblDeltagerMinutter.setText("Minutter i alt: " + deltager.minIAlt());
    }
}