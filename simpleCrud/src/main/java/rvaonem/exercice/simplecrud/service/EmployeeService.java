package rvaonem.exercice.simplecrud.service;

import org.springframework.stereotype.Service;
import rvaonem.exercice.simplecrud.persistance.model.Employee;
import java.util.List;

@Service
public interface EmployeeService {

    List<Employee> getEmployees();

    /**
     * @return An employee based on its id.
     */
    Employee getEmployee(int id);

    void addEmployee(Employee employee);

    void removeEmployee(Employee employee);

    /**
     * Edit an employee from the CSV file.
     */
    void editEmployee(Employee employee);

}
