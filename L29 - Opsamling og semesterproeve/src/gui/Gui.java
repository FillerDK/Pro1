package gui;

import controller.Controller;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Fag;
import model.Lektion;

public class Gui extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Ticket Mister");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    private ListView lvwFag = new ListView<>();
    private ListView lvwLektion = new ListView();
    private ListView lvwDeltagelse = new ListView();

    private void initContent(GridPane pane) {
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setPadding(new Insets(20));

        Label lblFag = new Label("Fag");
        pane.add(lblFag, 0, 0);
        pane.add(lvwFag, 0, 1);
        lvwFag.getItems().setAll(Controller.getFag());

        Label lblLektion = new Label("Lektion");
        pane.add(lblLektion, 1, 0);
        pane.add(lvwLektion, 1, 1);
        Fag fag = (Fag) lvwFag.getSelectionModel().getSelectedItem();
        lvwLektion.getItems().setAll(Controller.getLektioner(fag));

        Label lblDeltagelse = new Label("Deltagelse");
        pane.add(lblDeltagelse, 2, 0);
        pane.add(lvwDeltagelse, 2, 1);
        Lektion lektion = (Lektion) lvwLektion.getSelectionModel().getSelectedItem();
        lvwDeltagelse.getItems().setAll(Controller.getDeltagelser(lektion));

        Label lblFraværsårsager = new Label("Fraværsårsager");
        pane.add(lblFraværsårsager, 3, 0);

        Button btnFravær = new Button("Fravær");
        pane.add(btnFravær, 3, 2);
    }
}
