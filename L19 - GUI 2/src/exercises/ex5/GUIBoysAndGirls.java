package exercises.ex5;

import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

public class GUIBoysAndGirls extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Boys and girls");
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final ListView<String> lvwNames = new ListView<>();
    private final ArrayList<String> names = new ArrayList<>();
    private final ToggleGroup group = new ToggleGroup();

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);
        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        HBox box = new HBox();
        pane.add(box, 1, 0);

        String[] genderStrings = {"Boy", "Girl"};

        for (int i = 0; i < genderStrings.length; i++) {
            RadioButton rb = new RadioButton("Boy");
            box.getChildren().add(rb);
            rb.setText(genderStrings[i]);
            rb.setPrefWidth(70);
            rb.setToggleGroup(group);
            rb.setOnAction(event -> this.setListviewGender());
        }

        Label lblNames = new Label("Names:");
        pane.add(lblNames, 0, 1);
        GridPane.setValignment(lblNames, VPos.TOP);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 2);

        pane.add(lvwNames, 1, 1);
        lvwNames.setPrefWidth(200);
        lvwNames.setPrefHeight(200);

        pane.add(txfName, 1, 2);

        ChangeListener<String> listener = (ov, oldString, newString) -> this.selectionChanged();
        lvwNames.getSelectionModel().selectedItemProperty().addListener(listener);

        lvwNames.getSelectionModel().clearSelection();

        Button btnAdd = new Button("Add");
        pane.add(btnAdd, 2, 2);
        // btnAdd.setDefaultButton(true);

        btnAdd.setOnAction(event -> this.addAction());
    }

    // -------------------------------------------------------------------------
    // Button actions

    private void addAction() {
        String name = txfName.getText().trim();
        if (name.length() > 0) {
            names.add(name);
            txfName.clear();
            txfName.requestFocus();
            lvwNames.getItems().setAll(names);
        }
    }

    // -------------------------------------------------------------------------
    // RadioButton action

    private void setListviewGender() {
        RadioButton rb = (RadioButton) group.getSelectedToggle();
        lvwNames.getItems().clear();
        for (int i = 0; i < names.size(); i++) {
    //        lvwNames.getItems().set(i, );
        }
    }

    // -------------------------------------------------------------------------
    // Selection changed actions

    private void selectionChanged() {
        String selected = String.valueOf(lvwNames.getSelectionModel().getSelectedItem());
        if (selected != null) {
            txfName.setText(selected);
        } else {
            txfName.clear();
        }
    }
}
