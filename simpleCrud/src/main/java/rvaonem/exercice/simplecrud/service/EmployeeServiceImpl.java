package rvaonem.exercice.simplecrud.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import rvaonem.exercice.simplecrud.persistance.model.Employee;
import rvaonem.exercice.simplecrud.persistance.repository.EmployeeRepositoryImpl;

import java.util.List;
@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepositoryImpl employeeRepository;

    @Override
    public List<Employee> getEmployees() {
        return employeeRepository.getEmployeesFromCSV();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee searchedEmployee = null;

        for (Employee employee: employeeRepository.getEmployeesFromCSV()) {
            if (employee.getId() == id) {
                searchedEmployee = employee;
                break;
            }
        }

        return searchedEmployee;
    }

    @Override
    public void addEmployee(Employee employee) {
        employee.setId(findAvailableId());
        this.employeeRepository.writeEmployeeIntoCSV(employee);
    }

    @Override
    public void removeEmployee(Employee employee) {
        List<Employee> employees = employeeRepository.getEmployeesFromCSV();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.remove(i);
                break;
            }
        }

        employeeRepository.writeEmployeesIntoCSV(employees);
    }

    @Override
    public void editEmployee(Employee employee) {
        List<Employee> employees = employeeRepository.getEmployeesFromCSV();

        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getId() == employee.getId()) {
                employees.set(i, employee);
                break;
            }
        }

        employeeRepository.writeEmployeesIntoCSV(employees);
    }

    private int findAvailableId() {
        int higherFoundedId = 0;

        for (Employee employee: employeeRepository.getEmployeesFromCSV()) {
            if (employee.getId() > higherFoundedId) {
                higherFoundedId = employee.getId();
            }
        }

        return (higherFoundedId + 1);
    }
}
