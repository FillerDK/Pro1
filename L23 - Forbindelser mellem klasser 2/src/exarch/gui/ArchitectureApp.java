package exarch.gui;

import exarch.controller.Controller;
import exarch.model.Company;
import exarch.model.Employee;
import javafx.application.Application;

public class ArchitectureApp {

    public static void main(String[] args) {
        initStorage();
        Application.launch(ArchitectureGui.class);
    }

    public static void initStorage() {
        Company ibm = Controller.createCompany("IBM", 37);
        Company amd = Controller.createCompany("AMD", 40);
        Company sled = Controller.createCompany("SLED", 45);
        Controller.createCompany("Vector", 32);

        Employee mads = Controller.createEmployee("Mads", 300);
        Employee rasmus = Controller.createEmployee("Rasmus", 400);
        Employee jens = Controller.createEmployee("Jens", 250);
        Controller.addEmployeeToCompany(ibm, mads);
        Controller.addEmployeeToCompany(ibm, rasmus);
        Controller.addEmployeeToCompany(amd, jens);

        /*System.out.println(ibm.employeesCount());
        System.out.println(amd.employeesCount());

        System.out.println(mads.getName());
        System.out.println(mads.getCompany());
        System.out.println(mads.getWage());

        System.out.println(rasmus.getName());
        System.out.println(rasmus.getCompany());
        System.out.println(rasmus.getWage());

        System.out.println(ibm.getEmployees());*/
    }
}
