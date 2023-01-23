package rvaonem.exercice.simplecrud.persistance.model;

import com.opencsv.bean.CsvBindByName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Arrays;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @CsvBindByName(writeLocale = "ID")
    private int id;
    @CsvBindByName(writeLocale = "NAME")
    private String name;
    @CsvBindByName(writeLocale = "SKILLS")
    private String[] skills;
    @CsvBindByName(writeLocale = "PHONENBR")
    private String phoneNbr;
    @CsvBindByName(writeLocale = "NOTES")
    private String notes;

    public Employee(int id, String name, String phoneNbr, String[] skills, String notes) {
        this.id = id;
        this.name = name;
        this.phoneNbr = phoneNbr;
        this.skills = skills;
        this.notes = notes;
    }

    public String[] toStringArray() {
        return new String[] {
                Integer.toString(id),
                name,
                notes,
                phoneNbr,
                Arrays.toString(skills).replace("[", "").replace("]", ""),
        };
    }
}
