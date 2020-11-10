package ua.antibyte.analyzer.config;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Value("${file.path}")
    private String filePath;

    @Bean
    public CSVReader getCsvReader() {
        try {
            return new CSVReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("File not found " + filePath, e);
        }
    }
}
