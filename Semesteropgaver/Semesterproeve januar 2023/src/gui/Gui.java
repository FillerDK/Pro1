package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Salgsannonce;
import model.Vare;
import storage.Storage;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class Gui extends Application {
    // section S10

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("Handelseplatform");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene salgsScene = new Scene(pane);

        window.setScene(salgsScene);
        window.show();
    }

    private final ListView<Vare> lvwVarer = new ListView<>();
    private final TextField txfKøber = new TextField();
    private final TextField txfAftaltPris = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblAktiveAnnoncer = new Label("Aktive annoncer");
        pane.add(lblAktiveAnnoncer, 0, 0);

        ListView<Salgsannonce> lvwSalgsannoncer = new ListView<>();
        lvwSalgsannoncer.getItems().setAll(Controller.getSalgsannoncer());
        lvwSalgsannoncer.setPrefWidth(300);
        pane.add(lvwSalgsannoncer, 0, 1, 1, 4);

        Label lblVarer = new Label("Varer");
        pane.add(lblVarer, 1, 0);

        lvwVarer.getItems().setAll(Storage.getVarer());
        lvwVarer.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        lvwVarer.setPrefWidth(300);
        pane.add(lvwVarer, 1, 1, 1, 4);

        Label lblKøber = new Label("Køber");
        pane.add(lblKøber, 2, 1);

        txfKøber.setPrefWidth(150);
        pane.add(txfKøber, 3, 1);

        Label lblAftaltPris = new Label("Aftalt pris");
        pane.add(lblAftaltPris, 2, 2);

        txfAftaltPris.setPrefWidth(150);
        pane.add(txfAftaltPris, 3, 2);

        Button btnOpretSalg = new Button("Opret salg");
        GridPane.setHalignment(btnOpretSalg, HPos.CENTER);
        pane.add(btnOpretSalg, 2, 3);

        Label lblFilNavn = new Label("Fil navn");
        pane.add(lblFilNavn, 2, 5);

        TextField txfFilNavn = new TextField();
        txfFilNavn.setPrefWidth(150);
        pane.add(txfFilNavn, 3, 5);

        Button btnSalgsFil = new Button("Salgs fil");
        GridPane.setHalignment(btnSalgsFil, HPos.CENTER);
        pane.add(btnSalgsFil, 2, 6);

        // button actions
        btnOpretSalg.setOnAction(event -> opretSalgAction());

        btnSalgsFil.setOnAction(event -> {
            String filnavn = txfFilNavn.getText().trim();
            if (!filnavn.isBlank()) {
                Controller.salgTilFil(filnavn);
                txfFilNavn.setText("");
            }
        });
    }

    // button actions
    private void opretSalgAction() {
        boolean validInput = true;
        String fejlBesked = "";

        ArrayList<Vare> varer = new ArrayList<>(lvwVarer.getSelectionModel().getSelectedItems());
        if (varer.isEmpty()) {
            validInput = false;
            fejlBesked = "Vælg venligst varer!";
        } else {
            for (int i = 0; validInput && i < varer.size(); i++) {
                if (varer.get(i).isSolgt()) {
                    validInput = false;
                    fejlBesked = "En eller flere af valgte varer er allerede solgt!";
                }
            }
        }

        int aftaltSamletPris = 0;
        try {
            aftaltSamletPris = Integer.parseInt(txfAftaltPris.getText().trim());
        } catch (NumberFormatException ex) {
            validInput = false;
            fejlBesked = "Indtast venligst en aftalt pris!";
        }

        String købersNavn = txfKøber.getText().trim();
        if (købersNavn.isBlank()) {
            validInput = false;
            fejlBesked = "Hvem er køber af denne vare?";
        }

        if (validInput) {
            Controller.createSalg(købersNavn, aftaltSamletPris, varer);
            opdaterFelter();
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setHeaderText(fejlBesked);
            alert.show();
        }
    }

    private void opdaterFelter() {
        txfKøber.setText("");
        txfAftaltPris.setText("");

        lvwVarer.getItems().setAll(Storage.getVarer());
    }
}


