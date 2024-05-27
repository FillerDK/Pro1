package gui;

import controller.Controller;
import javafx.beans.value.ChangeListener;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import model.Konference;


public class ListerPane extends GridPane {


    private final TextArea txaDeltagere = new TextArea();
    private final ChoiceBox cbxKonferencer = new ChoiceBox<>();
    private final TextArea txaUdflugter = new TextArea();
    private final ChoiceBox cbxUdflugter = new ChoiceBox<>();
    private final TextArea txaHoteller = new TextArea();


    public ListerPane() {

        Gui.gPaneDefault(this);

        /**
         * Liste Deltagere
         * */

        Label lblDeltagere = new Label("Liste over deltagere for en konference");
        this.add(lblDeltagere, 0, 0);

        Label lblKonference = new Label("Konfernece");
        this.add(lblKonference, 0, 1);
        this.add(cbxKonferencer, 0, 2);
        cbxKonferencer.getItems().addAll(Controller.hentKonferencer());

        this.add(txaDeltagere, 0, 3);
        txaDeltagere.setEditable(false);

        ChangeListener<Konference> Konferencelistener = (ov, o, n) -> selectedKonferenceChanged();
        cbxKonferencer.getSelectionModel().selectedItemProperty().addListener(Konferencelistener);


        /**
         * Liste Udlufter
         * */

        Label lblUdflugter = new Label("Liste over alle udflugter for en konference");
        this.add(lblUdflugter, 1, 0);

        Label lblKonference1 = new Label("Konference");
        this.add(lblKonference1, 1, 1);
        this.add(cbxUdflugter, 1, 2);
        cbxUdflugter.getItems().addAll(Controller.hentKonferencer());

        this.add(txaUdflugter, 1, 3);
        txaUdflugter.setEditable(false);

        ChangeListener<Konference> udflugtListener = (ov, o, n) -> selectedUdflugtChanged();
        cbxUdflugter.getSelectionModel().selectedItemProperty().addListener(udflugtListener);


        /**
         * Liste Hoteller
         * */

        Label lblHoteller = new Label("Liste over alle hoteller for alle konferencer");
        this.add(lblHoteller, 2, 0);
        this.add(txaHoteller, 2, 3);

        Button btnOpdater = new Button("Opdatere");
        this.add(btnOpdater, 2, 2);
        btnOpdater.setOnAction(event -> btnOpdaterOnAction());

    }

    private void btnOpdaterOnAction() {
        StringBuilder s = new StringBuilder();

        for (String string : Controller.listeAfHoteller()) {
            s.append(string + "\n");
        }

        txaHoteller.setText(s + "");
    }

    private void selectedUdflugtChanged() {

        StringBuilder s = new StringBuilder();

        for (String string : Controller.listeAfUdflugterForKonference(
                (Konference) cbxUdflugter.getSelectionModel().getSelectedItem())
        ) {
            s.append(string + "\n");
        }

        txaUdflugter.setText(s + "");

    }

    private void selectedKonferenceChanged() {

        StringBuilder s = new StringBuilder();

        for (String string : Controller.listeAfDeltagereForKonference(
                (Konference) cbxKonferencer.getSelectionModel().getSelectedItem())
        ) {
            s.append(string + "\n");
        }

        txaDeltagere.setText(s + "");
    }
}
