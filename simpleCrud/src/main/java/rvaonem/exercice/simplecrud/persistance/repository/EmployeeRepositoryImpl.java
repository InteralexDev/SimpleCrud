package rvaonem.exercice.simplecrud.persistance.repository;

import com.opencsv.*;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Repository;
import rvaonem.exercice.simplecrud.persistance.model.Employee;
import rvaonem.exercice.simplecrud.persistance.model.EmployeeWrapper;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

import static rvaonem.exercice.simplecrud.config.ApplicationConfig.*;

@Getter
@Setter
@Repository
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeRepositoryImpl implements EmployeeRepository {

    private FileReader fileReader;

    private CSVReader csvReader;

    private final String csvFile = PROJECT_DIRECTORY + CSV_DIRECTORY;

    @Override
    public void openFile() {
        try {
            this.fileReader = new FileReader(this.csvFile);
            this.csvReader = new CSVReaderBuilder(this.fileReader)
                    .withCSVParser(new CSVParserBuilder().withSeparator(CSV_DELIMITER).build())
                    .build();
        } catch (FileNotFoundException exception) {
            throw new RuntimeException(exception);
        }
    }

    @Override
    public void writeEmployeeIntoCSV(Employee employee) {
        try (Writer writer = Files.newBufferedWriter(Paths.get(csvFile), StandardOpenOption.APPEND)) {
            CSVWriter csvWriter = new CSVWriter(writer, CSV_DELIMITER, CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.NO_ESCAPE_CHARACTER, "\n");
            csvWriter.writeNext(employee.toStringArray(), false);
            csvWriter.flush();
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

    @Override
    public List<Employee> getEmployeesFromCSV() {
        openFile();

        CsvToBean<Employee> csvToBean = new CsvToBeanBuilder<Employee>(fileReader)
                .withType(Employee.class)
                .withIgnoreLeadingWhiteSpace(true)
                .withSeparator(CSV_DELIMITER)
                .build();
        List<Employee> employees = csvToBean.parse();

        return employees;
    }

    public void writeEmployeesIntoCSV(List<Employee> employees) {
        try (Writer writer = new FileWriter(this.csvFile)) {
            List<EmployeeWrapper> employeeWrappers = new ArrayList<>();
            for (Employee employee : employees) {
                employeeWrappers.add(new EmployeeWrapper(employee));
            }
            CSVWriter csvWriter = new CSVWriter(writer, CSV_DELIMITER, CSVWriter.NO_QUOTE_CHARACTER,
                    CSVWriter.NO_ESCAPE_CHARACTER, "\n");
            StatefulBeanToCsv<EmployeeWrapper> beanToCsv = new StatefulBeanToCsvBuilder<EmployeeWrapper>(csvWriter)
                    .withSeparator(CSV_DELIMITER)
                    .build();
            beanToCsv.write(employeeWrappers);
        } catch (CsvRequiredFieldEmptyException | CsvDataTypeMismatchException | IOException exception) {
            exception.printStackTrace();
        }
    }
}
