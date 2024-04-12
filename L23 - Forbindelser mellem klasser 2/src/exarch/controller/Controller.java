package exarch.controller;

import exarch.model.Company;
import exarch.model.Employee;
import exarch.storage.Storage;

import java.util.ArrayList;

public abstract class Controller {


    // region # company #
    /**
     * Create a new Company.
     * Pre: name not empty, hours >= 0.
     */
    public static Company createCompany(String name, int hours) {
        Company company = new Company(name, hours);
        Storage.storeCompany(company);
        return company;
    }

    /**
     * Delete the company.
     * Pre: The company has no employees.
     */
    public static void deleteCompany(Company company) {
        Storage.deleteCompany(company);
    }

    /**
     * Update the company.
     * Pre: name not empty, hours >= 0.
     */
    public static void updateCompany(Company company, String name, int hours) {
        company.setName(name);
        company.setHours(hours);
    }

    public static ArrayList<Company> getCompanies() {
        return Storage.getCompanies();
    }

    // endregion

    // region # employee #
    /**
     * Create a new emplyee.
     * Pre: name not empty, wage >= 0.
     */
    public static Employee createEmployee(String name, int wage) {
        Employee employee = new Employee(name, wage);
        Storage.storeEmployee(employee);
        return employee;
    }

    public static void deleteEmployee(Employee employee) {
        Storage.deleteEmployee(employee);
        if (employee.getCompany() != null) {
            employee.getCompany().removeEmployee(employee);
        }
    }

    /**
     * Update the company.
     * Pre: name not empty, hours >= 0.
     */
    public static void updateEmployee(Employee employee, String name, int wage, Company company) {
        employee.setName(name);
        employee.setWage(wage);
        addEmployeeToCompany(company, employee);
    }

    public static ArrayList<Employee> getEmployees() {
        return Storage.getEmployees();
    }

    // endregion

    /**
     * Add the employee to the company.
     * If the employee is connected to a company,
     * this connection is removed first.
     */
    public static void addEmployeeToCompany(Company company, Employee employee) {
        if (employee.getCompany() != null) {
            employee.getCompany().removeEmployee(employee);
        }
        if (company != null) {
            company.addEmployee(employee);
            employee.setCompany(company);
        }
    }
}
