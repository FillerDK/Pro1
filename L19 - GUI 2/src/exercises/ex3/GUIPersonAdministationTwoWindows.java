package exercises.ex3;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUIPersonAdministationTwoWindows extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Person administration");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();

        personWindow = new PersonInputWindow("Person Information", stage);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfTitle = new TextField();
    private final ListView<Person> lvwPersons = new ListView<>();
    private final ArrayList<Person> persons = new ArrayList<>();
    private final CheckBox cbxSenior = new CheckBox("Senior");
    private PersonInputWindow personWindow;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        Label lblPersons = new Label("Persons:");
        pane.add(lblPersons, 0, 0);
        GridPane.setValignment(lblPersons, VPos.TOP);

        pane.add(lvwPersons, 0, 1);
        lvwPersons.setPrefWidth(200);
        lvwPersons.setPrefHeight(200);
        lvwPersons.setMouseTransparent(true);
        lvwPersons.setFocusTraversable(false);

        Button btnAddPerson = new Button("Add person");
        pane.add(btnAddPerson, 1, 1);
       // btnAdd.setDefaultButton(true);

        btnAddPerson.setOnAction(event -> this.addPersonAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addPersonAction() {
        personWindow.showAndWait();

        if (personWindow.getActualPerson() != null) {
            Person person = personWindow.getActualPerson();
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        }




        /*String name = txfName.getText().trim();
        String title = txfTitle.getText().trim();
        boolean senior = cbxSenior.isSelected();
        if (name.length() > 0 && title.length() > 0) {
            Person person = new Person(name, title, senior);
            persons.add(person);
            lvwPersons.getItems().setAll(persons);
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Missing input");
            alert.setHeaderText("Input both a name and a title");
            if (name.length() <= 0 && title.length() <= 0) {
                alert.setContentText("Input both name and title!");
            } else if (name.length() <= 0) {
                alert.setContentText("Input a name!");
            } else {
                alert.setContentText("Input a title!");
            }
            alert.show();
        }*/
    }
}
