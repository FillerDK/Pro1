package exarch.storage;

import exarch.model.Company;
import exarch.model.Employee;

import java.util.ArrayList;

public class Storage {
    private static final ArrayList<Company> companies = new ArrayList<>();
    private static final ArrayList<Employee> employees = new ArrayList<>();

    // region # company #
    public static ArrayList<Company> getCompanies() {
        return new ArrayList<>(companies);
    }

    public static void storeCompany(Company company) {
        companies.add(company);
    }

    public static void deleteCompany(Company company) {
        companies.remove(company);
    }

    // endregion

    // region # employee #

    public static ArrayList<Employee> getEmployees() {
        return new ArrayList<>(employees);
    }

    public static void storeEmployee(Employee employee) {
        employees.add(employee);
    }

    public static void deleteEmployee(Employee employee) {
        employees.remove(employee);
    }

    // endregion
}
