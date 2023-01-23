package rvaonem.exercice.simplecrud.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import rvaonem.exercice.simplecrud.persistance.model.Employee;
import rvaonem.exercice.simplecrud.service.EmployeeServiceImpl;

import java.util.List;

import static rvaonem.exercice.simplecrud.config.ApplicationConfig.FRONTEND_ACP;

@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = FRONTEND_ACP)
public class EmployeeController {
    private final EmployeeServiceImpl employeeService;

    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getEmployees();
    }

    @GetMapping("/employees/{id}")
    public Employee getEmployee(@PathVariable int id) { return employeeService.getEmployee(id); }

    @PostMapping("/employees/add")
    public void addEmployee(@RequestBody Employee employee) {
        this.employeeService.addEmployee(employee);
    }

    @PostMapping("/employees/remove")
    public void removeEmployee(@RequestBody Employee employee) {
        this.employeeService.removeEmployee(employee);
    }

    @PostMapping("/employees/edit")
    public void editEmployee(@RequestBody Employee employee) {
        this.employeeService.editEmployee(employee);
    }
}
