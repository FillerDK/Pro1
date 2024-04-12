package exarch.gui;

import exarch.controller.Controller;
import exarch.model.Company;
import exarch.model.Employee;
import exarch.storage.Storage;
import javafx.collections.FXCollections;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class EmployeeWindow extends Stage {
    private final Employee employee; // nullable

    public EmployeeWindow(String title, Employee employee) {
        this.initStyle(StageStyle.UTILITY);
        this.initModality(Modality.APPLICATION_MODAL);
        this.setResizable(false);

        this.employee = employee;

        this.setTitle(title);
        GridPane pane = new GridPane();
        this.initContent(pane);

        Scene scene = new Scene(pane);
        this.setScene(scene);
    }

    // -------------------------------------------------------------------------

    private final TextField txfName = new TextField();
    private final TextField txfHourlyWage = new TextField();
    private final Label lblError = new Label();
    private final CheckBox cbxCompany = new CheckBox("Company");
    private final ComboBox comboBox = new ComboBox(FXCollections.observableList(Controller.getCompanies()));

    private void initContent(GridPane pane) {
        pane.setPadding(new Insets(10));
        pane.setHgap(10);
        pane.setVgap(10);
        pane.setGridLinesVisible(false);

        Label lblName = new Label("Name");
        pane.add(lblName, 0, 0);

        pane.add(txfName, 0, 1);
        txfName.setPrefWidth(200);

        Label lblHourlyWage = new Label("Hourly Wage");
        pane.add(lblHourlyWage, 0, 2);

        pane.add(txfHourlyWage, 0, 3);
        pane.add(cbxCompany, 0, 4);
        pane.add(comboBox, 0, 5);
        comboBox.getSelectionModel().selectFirst();
        comboBox.setDisable(true);

        cbxCompany.setOnAction(event -> {
            if (!cbxCompany.isSelected())
                comboBox.setDisable(true);
            else comboBox.setDisable(false);
        });

        Button btnCancel = new Button("Cancel");
        pane.add(btnCancel, 0, 6);
        GridPane.setHalignment(btnCancel, HPos.LEFT);
        btnCancel.setOnAction(event -> this.cancelAction());

        Button btnOK = new Button("OK");
        pane.add(btnOK, 0, 6);
        GridPane.setHalignment(btnOK, HPos.RIGHT);
        btnOK.setOnAction(event -> this.okAction());

        pane.add(lblError, 0, 7);
        lblError.setStyle("-fx-text-fill: red");

        this.initControls();
    }

    // -------------------------------------------------------------------------

    private void initControls() {
        if (employee != null) {
            txfName.setText(employee.getName());
            txfHourlyWage.setText("" + employee.getWage());
            if (employee.getCompany() == null) {
                comboBox.setDisable(true);
            } else {
                comboBox.setDisable(false);
                cbxCompany.setSelected(true);
            }
        } else {
            txfName.clear();
            txfHourlyWage.clear();
        }
    }

    // -------------------------------------------------------------------------

    private void cancelAction() {
        this.hide();
    }

    private void okAction() {
        String name = txfName.getText().trim();
        if (name.length() == 0) {
            lblError.setText("Name is empty");
            return;
        }

        int wage = -1;
        try {
            wage = Integer.parseInt(txfHourlyWage.getText().trim());
        } catch (NumberFormatException ex) {
            // do nothing
        }
        if (wage < 0) {
            lblError.setText("Weekly wage is not a positive number");
            return;
        }

        Company company = (Company) comboBox.getSelectionModel().getSelectedItem();
        if (!cbxCompany.isSelected()) {
            company = null;
        }

        if (employee != null) {
            // update existing employee
            Controller.updateEmployee(employee, name, wage, company);
        } else {
            // create new employee
            Controller.createEmployee(name, wage);
            Controller.addEmployeeToCompany(company, Controller.getEmployees().getLast());
        }

        this.hide();
    }
}
