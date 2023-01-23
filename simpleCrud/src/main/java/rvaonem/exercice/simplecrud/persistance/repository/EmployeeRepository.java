package rvaonem.exercice.simplecrud.persistance.repository;

import org.springframework.stereotype.Repository;
import rvaonem.exercice.simplecrud.persistance.model.Employee;

import java.io.FileNotFoundException;
import java.util.List;

@Repository
public interface EmployeeRepository {

    /**
     * Open cvs file in read.
     */
    void openFile();

    /**
     * @return All employees.
     */
    List<Employee> getEmployeesFromCSV() throws FileNotFoundException;

    /**
     * Write an employee inside the CSV file.
     */
    void writeEmployeeIntoCSV(Employee employee);

    /**
     * Override the CSV File with a list of employees.
     */
    void writeEmployeesIntoCSV(List<Employee> employees);
}