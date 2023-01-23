package rvaonem.exercice.simplecrud.config;

import lombok.Getter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Getter
@Configuration
@ComponentScan
public class ApplicationConfig {

    /**
     * Project directory from absolute path.
     */
    public static final String PROJECT_DIRECTORY = "C:\\javadev\\projets\\SimpleCrud\\simpleCrud\\src\\main\\";

    /**
     * CSV file directory from project directory path.
     */
    public static final String CSV_DIRECTORY = "resources\\csv\\DATABASE_SIMPLE_CRUD_EMPLOYEES.csv";

    /**
     * CSV column delimiter/separator.
     */
    public static final char CSV_DELIMITER = ';';

    /**
     * Frontend access point.
     */
    public static final String FRONTEND_ACP = "http://localhost:4200";

}
