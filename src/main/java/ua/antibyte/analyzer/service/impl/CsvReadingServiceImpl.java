package ua.antibyte.analyzer.service.impl;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.service.CsvReadingService;

@Service
public class CsvReadingServiceImpl implements CsvReadingService {
    private static final String[] FILE_HEADER = new String[]{
            "Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator",
            "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};

    private final CSVReader csvReader;

    public CsvReadingServiceImpl(CSVReader csvReader) {
        this.csvReader = csvReader;
    }

    @Override
    public List<String[]> read() {
        try {
            List<String[]> lines = new ArrayList<>();
            String[] nextLine;
            while ((nextLine = csvReader.readNext()) != null) {
                if (Arrays.equals(FILE_HEADER, nextLine)) {
                    continue;
                }
                lines.add(nextLine);
            }
            return lines;
        } catch (IOException | CsvValidationException e) {
            throw new RuntimeException("Can't read file ", e);
        }

    }
}
