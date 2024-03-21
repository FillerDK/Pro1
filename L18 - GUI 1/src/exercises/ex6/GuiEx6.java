package exercises.ex6;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

public class GuiEx6 extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("Student info App");
        GridPane pane = new GridPane();
        this.initContent(pane);
        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.show();
    }

    // -------------------------------------------------------------------------
    private final TextArea txaStudentInfo = new TextArea();
    private final TextField txfName = new TextField();
    private final TextField txfAge = new TextField();
    private final CheckBox cbxActive = new CheckBox();
    private Student student;

    private void initContent(GridPane pane) {
        pane.setGridLinesVisible(false);

        pane.setPadding(new Insets(20));
        pane.setHgap(10);
        pane.setVgap(10);

        // labels
        Label lblStudentInfo = new Label("Student info:");
        pane.add(lblStudentInfo, 0, 0, 2, 1);

        Label lblName = new Label("Name:");
        pane.add(lblName, 0, 2);

        Label lblAge = new Label("Age:");
        pane.add(lblAge, 0, 3);

        Label lblActive = new Label("Active:");
        pane.add(lblActive, 0, 4);

        // textareas
        pane.add(txaStudentInfo, 0, 1, 5, 1);
        txaStudentInfo.setPrefWidth(100);
        txaStudentInfo.setEditable(false);
        txaStudentInfo.setMouseTransparent(true);
        txaStudentInfo.setFocusTraversable(false);

        // textfields
        pane.add(txfName, 1, 2, 2, 1);
        txfName.setPrefWidth(145);

        pane.add(txfAge, 1, 3);
        txfAge.setPrefWidth(85);

        // buttons
        Button btnInc = new Button("Inc");
        pane.add(btnInc, 2, 3);

        Button btnReset = new Button("Reset");
        pane.add(btnReset, 3, 3);

        // checkboxes
        pane.add(cbxActive, 1, 4);

        // more buttons
        Button btnCreate = new Button("Create");
        pane.add(btnCreate, 0, 5, 2, 1);
        GridPane.setMargin(btnCreate, new Insets(0, 0, 0, 27));

        Button btnUpdate = new Button("Update");
        pane.add(btnUpdate, 1, 5, 2, 1);
        GridPane.setHalignment(btnUpdate, HPos.CENTER);
        GridPane.setMargin(btnUpdate, new Insets(0, 0, 0, 20));

        Button btnDelete = new Button("Delete");
        pane.add(btnDelete, 2, 5, 2, 1);
        GridPane.setHalignment(btnDelete, HPos.CENTER);
        GridPane.setMargin(btnDelete, new Insets(0, 0, 0, 20));

        // actions
        cbxActive.setOnAction(event -> this.activeAction());
        btnInc.setOnAction(event -> this.incAction());
        btnReset.setOnAction(event -> this.resetAction());
        btnUpdate.setOnAction(event -> this.updateAction());
        btnCreate.setOnAction(event -> {
            this.createAction();
            if (student != null) {
                btnCreate.setDisable(true);
                btnReset.setDisable(false);
                btnUpdate.setDisable(false);
                btnDelete.setDisable(false);
            }
        });
        btnDelete.setOnAction(event -> {
            this.deleteAction();
            btnReset.setDisable(true);
            btnCreate.setDisable(false);
            btnUpdate.setDisable(true);
            btnDelete.setDisable(true);
        });

        // buttons disabled
        btnUpdate.setDisable(true);
        btnReset.setDisable(true);
        btnDelete.setDisable(true);
    }

    private void incAction() {
        if (txfAge.getText().equals(""))
            txfAge.setText("0");
        int newAge = Integer.parseInt(txfAge.getText()) + 1;
        txfAge.setText(Integer.toString(newAge));
    }

    private void resetAction() {
        txfName.setText(student.getName());
        txfAge.setText(Integer.toString(student.getAge()));
        cbxActive.setSelected(student.isActive());
    }

    private void activeAction() {
        if (student != null) {
            if (cbxActive.isSelected())
                student.setActive(true);
            else student.setActive(false);
        }
    }

    private void createAction() {
        if (!txfName.getText().trim().equals("") && !txfAge.getText().equals("")) {
            student = new Student();
            student.setName(txfName.getText().trim());
            student.setAge(Integer.parseInt(txfAge.getText().trim()));
            student.setActive(cbxActive.isSelected());
            String isActive = student.isActive() ? "Yes" : "No";
            txaStudentInfo.setText("Name: " + student.getName()
                    + "\nAge: " + student.getAge()
                    + "\nActive: " + isActive);
            txfName.clear();
            txfAge.clear();
            cbxActive.setSelected(false);
        } else {
            txaStudentInfo.setText("Please input name and age\nto create a student");
        }
    }

    private void updateAction() {
        if (!student.getName().equals("") && student.getAge() != 0) {
            if (!txfName.getText().equals(""))
                student.setName(txfName.getText().trim());
            if (!txfAge.getText().equals(""))
                student.setAge(Integer.parseInt(txfAge.getText().trim()));
            student.setActive(cbxActive.isSelected());
            String isActive = cbxActive.isSelected() ? "Yes" : "No";
            txaStudentInfo.setText("Name: " + student.getName()
                    + "\nAge: " + student.getAge()
                    + "\nActive: " + isActive);
            txfName.clear();
            txfAge.clear();
            cbxActive.setSelected(false);
        }
    }

    private void deleteAction() {
        student = null;
        /*
        student.setName("");
        student.setAge(0);
        student.setActive(false);
        */
        txaStudentInfo.clear();
        txfName.clear();
        txfAge.clear();
        cbxActive.setSelected(false);
    }
}
