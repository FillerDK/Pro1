package gui;

import controller.Controller;
import javafx.geometry.Insets;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import model.Konference;

public class KonferencePane extends GridPane {
    ListView<Konference> lvwKonference = new ListView<>();

    public KonferencePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        lvwKonference.getItems().setAll(Controller.hentKonferencer());
        this.add(lvwKonference, 0, 0);
    }

}
