package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Forestilling;
import model.Kunde;
import storage.Storage;

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

    public void initContent(GridPane pane) {
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblForestillinger = new Label("Forestillinger");
        pane.add(lblForestillinger, 0, 0);

        ListView<Forestilling> lvwForestillinger = new ListView<>();
        lvwForestillinger.getItems().setAll(Storage.getForestillinger());
        lvwForestillinger.setPrefWidth(300);
        pane.add(lvwForestillinger, 0, 1);

        Label lblKunder = new Label("Kunder");
        pane.add(lblKunder, 1, 0);

        ListView<Kunde> lvwKunder = new ListView<>();
        lvwKunder.getItems().setAll(Storage.getKunder());
        lvwKunder.setPrefWidth(300);
        pane.add(lvwKunder, 1, 1);

        Label lblKundeNavn = new Label("Kunde navn:");
        pane.add(lblKundeNavn, 1, 2);

        TextField txfKundeNavn = new TextField();
        txfKundeNavn.setPrefWidth(300);
        pane.add(txfKundeNavn, 1, 3);

        Label lblKundeMobil = new Label("Kunde mobil:");
        pane.add(lblKundeMobil, 1, 4);

        TextField txfKundeMobil = new TextField();
        txfKundeMobil.setPrefWidth(300);
        pane.add(txfKundeMobil, 1, 5);

        Button btnOpret = new Button("Opret kunde");
        GridPane.setHalignment(btnOpret, HPos.CENTER);
        pane.add(btnOpret, 1, 6);

        Label lblDato = new Label("Dato:");
        pane.add(lblDato, 2, 0);

        TextField txfDato = new TextField();
        txfDato.setPrefWidth(300);
        pane.add(txfDato, 2, 1);

        Button btnVis = new Button("Vis bestilte pladser");
        GridPane.setHalignment(btnVis, HPos.CENTER);
        pane.add(btnVis, 2, 2);

        Label lblBestiltePladser = new Label("Bestilte pladser");
        pane.add(lblBestiltePladser, 2, 3);

        TextArea txaBestiltePladser = new TextArea();
        txaBestiltePladser.setPrefWidth(300);
        pane.add(txaBestiltePladser, 2, 4);


        // button actions
        btnOpret.setOnAction(event -> opretAction());

        btnVis.setOnAction(event -> visAction());

    }

    public void opretAction() {

    }

    public void visAction() {

    }
}


