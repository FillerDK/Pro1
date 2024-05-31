package gui;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Arrangement;
import model.Tutor;
import storage.Storage;

import java.util.ArrayList;

public class Gui extends Application {
    // section S12

    @Override
    public void start(Stage mainStage) {
        Stage window = mainStage;
        window.setTitle("Administration af tutorer og arrangementer");
        GridPane pane = new GridPane();

        initContent(pane);
        Scene tutorScene = new Scene(pane);

        window.setScene(tutorScene);
        window.show();
    }

    private final ListView<Tutor> lvwTutorer = new ListView<>();
    private final ListView<Arrangement> lvwArrangementer = new ListView<>();
    private final ListView<Arrangement> lvwAlleArrangementer = new ListView<>();

    private final TextField txfNavn = new TextField();
    private final TextField txfEmail = new TextField();

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblTutorer = new Label("Tutorer");
        pane.add(lblTutorer, 0, 0);

        lvwTutorer.getItems().setAll(Storage.getTutorer());
        lvwTutorer.setPrefWidth(300);
        pane.add(lvwTutorer, 0, 1, 1, 4);

        ChangeListener<Tutor> tutorListener = (ov, o, n) -> tutorChanged();
        lvwTutorer.getSelectionModel().selectedItemProperty().addListener(tutorListener);

        Label lblNavn = new Label("Navn");
        pane.add(lblNavn, 1, 0);

        Label lblEmail = new Label("Email");
        pane.add(lblEmail, 1, 1);

        Label lblArrangementer = new Label("Arrangementer");
        pane.add(lblArrangementer, 1, 2);

        txfNavn.setPrefWidth(300);
        txfNavn.setEditable(false);
        pane.add(txfNavn, 2, 0);

        txfEmail.setPrefWidth(300);
        txfEmail.setEditable(false);
        pane.add(txfEmail, 2, 1);

        lvwArrangementer.setPrefWidth(300);
        pane.add(lvwArrangementer, 2, 2);

        Button btnFjern = new Button("Fjern");
        GridPane.setHalignment(btnFjern, HPos.CENTER);
        pane.add(btnFjern, 2, 3);

        Label lblAlleArrangementer = new Label("Alle mulige arrangementer");
        pane.add(lblAlleArrangementer, 3, 1);

        lvwAlleArrangementer.getItems().setAll(Storage.getArrangementer());
        lvwAlleArrangementer.setPrefWidth(300);
        pane.add(lvwAlleArrangementer, 3, 2);

        Button btnTilføj = new Button("Tilføj");
        GridPane.setHalignment(btnTilføj, HPos.CENTER);
        pane.add(btnTilføj, 3, 3);

        // button actions
        btnFjern.setOnAction(event -> fjernAction());

        btnTilføj.setOnAction(event -> tilføjAction());


    }

    // ================== updaters ===================

    private void tutorChanged() {
        Tutor tutor = lvwTutorer.getSelectionModel().getSelectedItem();
        txfNavn.setText(tutor.getNavn());
        txfEmail.setText(tutor.getEmail());
        lvwArrangementer.getItems().setAll(tutor.getArrangementer());
    }

    // ================ btn actions ==================

    private void fjernAction() {
        Arrangement arrangement = lvwArrangementer.getSelectionModel().getSelectedItem();
        Tutor tutor = lvwTutorer.getSelectionModel().getSelectedItem();
        if (arrangement != null && tutor != null) {
            tutor.removeArrangement(arrangement);
            lvwArrangementer.getItems().setAll(tutor.getArrangementer());
        }
    }

    private void tilføjAction() {
        Arrangement arrangement = lvwAlleArrangementer.getSelectionModel().getSelectedItem();
        Tutor tutor = lvwTutorer.getSelectionModel().getSelectedItem();;
        if (arrangement != null && tutor != null) {
            boolean alleredeTilmeldtArrangement = false;
            ArrayList<Arrangement> arrangementer = tutor.getArrangementer();
            for (int i = 0; !alleredeTilmeldtArrangement && i < arrangementer.size(); i++) {
                if (arrangementer.get(i) == arrangement)
                    alleredeTilmeldtArrangement = true;
            }
            if (!alleredeTilmeldtArrangement) {
                tutor.addArrangement(arrangement);
                lvwArrangementer.getItems().setAll(tutor.getArrangementer());
            }

        }
    }
}


