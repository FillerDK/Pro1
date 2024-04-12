package exarch.gui;

import exarch.controller.Controller;
import exarch.model.Company;
import exarch.model.Employee;
import javafx.beans.value.ChangeListener;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;

import java.util.Optional;

public class EmployeePane extends GridPane {
    private final TextField txfName = new TextField();
    private final TextField txfHourlyWage = new TextField();
    private final TextField txfCompany = new TextField();
    private final TextField txfWeeklySalary = new TextField();
    private final ListView<Employee> lvwEmployees = new ListView();

    public EmployeePane() {
        this.setPadding(new Insets(20));
        this.setHgap(20);
        this.setVgap(10);
        this.setGridLinesVisible(false);

        Label lblEmployees = new Label("Employees");
        this.add(lblEmployees, 0, 0);

        this.add(lvwEmployees, 0, 1, 1, 5);
        lvwEmployees.setPrefWidth(200);
        lvwEmployees.setPrefHeight(200);
        lvwEmployees.getItems().setAll(Controller.getEmployees());

        ChangeListener<Employee> listener = (ov, o, n) -> this.selectedEmployeeChanged();
        lvwEmployees.getSelectionModel().selectedItemProperty().addListener(listener);

        Label lblName = new Label("Name:");
        this.add(lblName, 1, 1);

        this.add(txfName, 2, 1);
        txfName.setEditable(false);
        txfName.setPrefWidth(200);

        Label lblHourlyWage = new Label("Hourly Wage:");
        this.add(lblHourlyWage, 1, 2);

        this.add(txfHourlyWage, 2, 2);
        txfHourlyWage.setEditable(false);

        Label lblCompany = new Label("Company:");
        this.add(lblCompany, 1, 3);

        this.add(txfCompany, 2, 3);
        txfCompany.setEditable(false);

        Label lblWeeklySalary = new Label("Weekly Salary:");
        this.add(lblWeeklySalary, 1, 4);

        this.add(txfWeeklySalary, 2, 4);
        txfWeeklySalary.setEditable(false);

        HBox hbxButtons = new HBox(40);
        this.add(hbxButtons, 0, 6, 3, 1);
        hbxButtons.setPadding(new Insets(10, 0, 0, 0));
        hbxButtons.setAlignment(Pos.BASELINE_CENTER);

        Button btnCreate = new Button("Create");
        hbxButtons.getChildren().add(btnCreate);
        btnCreate.setOnAction(event -> this.createAction());

        Button btnUpdate = new Button("Update");
        hbxButtons.getChildren().add(btnUpdate);
        btnUpdate.setOnAction(event -> this.updateAction());

        Button btnDelete = new Button("Delete");
        hbxButtons.getChildren().add(btnDelete);
        btnDelete.setOnAction(event -> this.deleteAction());

        if (!lvwEmployees.getItems().isEmpty())
            lvwEmployees.getSelectionModel().select(0);
    }

    // -------------------------------------------------------------------------

    private void createAction() {
        EmployeeWindow dialog = new EmployeeWindow("Create Employee", null);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        lvwEmployees.getItems().setAll(Controller.getEmployees());
        int index = lvwEmployees.getItems().size() - 1;
        lvwEmployees.getSelectionModel().select(index);
    }

    private void updateAction() {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee == null)
            return;

        EmployeeWindow dialog = new EmployeeWindow("Update employee", employee);
        dialog.showAndWait();

        // Wait for the modal dialog to close

        int selectIndex = lvwEmployees.getSelectionModel().getSelectedIndex();
        lvwEmployees.getItems().setAll(Controller.getEmployees());
        lvwEmployees.getSelectionModel().select(selectIndex);
    }

    private void deleteAction() {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee == null)
            return;

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.initOwner(this.getScene().getWindow());
        alert.setTitle("Delete Employee");
        alert.setHeaderText("Are you sure?");
        Optional<ButtonType> result = alert.showAndWait();

        // wait for the modal dialog to close

        if (result.isPresent() && (result.get() == ButtonType.OK)) {
            Controller.deleteEmployee(employee);
            lvwEmployees.getItems().setAll(Controller.getEmployees());
            this.updateControls();
        }
    }

    // -------------------------------------------------------------------------

    private void selectedEmployeeChanged() {
        this.updateControls();
    }

    public void updateControls() {
        Employee employee = lvwEmployees.getSelectionModel().getSelectedItem();
        if (employee != null) {
            txfName.setText(employee.getName());
            txfHourlyWage.setText("" + employee.getWage());
            if (employee.getCompany() != null) {
                txfCompany.setText(employee.getCompany().toString());
                txfWeeklySalary.setText("" + employee.getWeeklySalary());
            } else {
                txfCompany.setText("");
                txfWeeklySalary.setText("");
            }
        } else {
            txfName.clear();
            txfHourlyWage.clear();
            txfCompany.clear();
            txfWeeklySalary.clear();
        }
    }
}
