package rvaonem.exercice.simplecrud.persistance.repository;

import com.opencsv.CSVParserBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVReaderBuilder;
import org.junit.jupiter.api.Test;
import rvaonem.exercice.simplecrud.persistance.model.Employee;

import java.io.FileNotFoundException;
import java.io.FileReader;

import static org.junit.jupiter.api.Assertions.*;

class EmployeeRepositoryImplTest {

//    @Test
//    void FileThatDoesNotExistWillInvokeAnError() throws FileNotFoundException {
//        /* GIVEN */
//        Throwable exception = null;
//        String csvFile = "fake_file.csv";
//        try {
//            /* WHEN */
//            FileReader fileReader = new FileReader(csvFile);
//        } catch (FileNotFoundException e) {
//            exception = assertThrows(FileNotFoundException.class, () -> {
//                throw new FileNotFoundException("File not found");
//            });
//        }
//        /* THEN */
//        assertEquals("File not found", exception.getMessage());
//    }
//
//    /**
//     * In this case the Employee id exist.
//     */
//    @Test
//    void getEmployeeFromCSVCase1() {
//        /* GIVEN */
//        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
//        /* WHEN */
//        Employee testEmployee = employeeRepository.getEmployeeFromCSV(1);
//        /* THEN */
//        assertEquals(1, testEmployee.getId());
//    }
//
//    /**
//     * In this case the Employee id doesn't exist.
//     */
//    @Test
//    void getEmployeeFromCSVCase2() {
//        /* GIVEN */
//        EmployeeRepositoryImpl employeeRepository = new EmployeeRepositoryImpl();
//        Throwable exception = null;
//        Employee testEmployee = null;
//        /* WHEN */
//        testEmployee = employeeRepository.getEmployeeFromCSV(99);
//        /* THEN */
//        assertEquals(testEmployee, null);
//    }

}