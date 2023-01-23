package rvaonem.exercice.simplecrud.persistance.model;

import lombok.Getter;

/**
 * This class is used for compatibility with openCSV wrapper,
 * it is a simple-way to regenerate Employees as writable element into the CSV.
 */
@Getter
public class EmployeeWrapper {
    private final int id;
    private final String name;
    private final String skills;
    private final String phoneNbr;
    private final String notes;

    public EmployeeWrapper(Employee employee) {
        this.id = employee.getId();
        this.name = employee.getName();
        this.skills = (employee.getSkills() != null) ? String.join(" ", employee.getSkills()) : "";
        this.notes = employee.getNotes();
        this.phoneNbr = employee.getPhoneNbr();
    }
}
