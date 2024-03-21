package exercises.ex1;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUIPersonAdministration extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Add person");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final CheckBox cbxSenior = new CheckBox("Senior");

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 0);

        Label lblTitle = new Label("Title:");
        pane.add(lblTitle, 0, 1);

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 3);
        GridPane.setValignment(lblPersons, VPos.TOP);

        pane.add(txfName, 1, 0);

        pane.add(txfTitle, 1, 1);

        pane.add(cbxSenior, 1, 2);

        pane.add(lvwPersons, 1, 3);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);

        ChangeListener<Person> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwPersons.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwPersons.getSelectionModel().clearSelection();

        Button btnAddPerson = new Button("Add person");
        pane.add(btnAddPerson, 2, 2);
       // btnAdd.setDefaultButton(true);

        btnAddPerson.setOnAction(event -> this.addAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = cbxSenior.isSelected();
        if (name.length() > 0) {
            Person person = new Person(name, title, senior);
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        }
    }

    // -------------------------------------------------------------------------
    // Selection changed actions

    private void selectionChanged() {
        String selected = String.valueOf(lvwPersons.getSelectionModel().getSelectedItem());
        if (selected != null) {
            txfName.setText(selected);
        } else {
            txfName.clear();
        }
    }
}
