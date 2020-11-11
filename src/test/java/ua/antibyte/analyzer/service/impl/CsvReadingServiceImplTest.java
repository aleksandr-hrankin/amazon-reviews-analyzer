package ua.antibyte.analyzer.service.impl;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.opencsv.CSVReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.service.CsvReadingService;

class CsvReadingServiceImplTest {
    private static final String FILE_PATH = "src/test/resources/test_file.csv";
    private static final String FILE_PATH_WITHOUT_HEADER = "src/test/resources/test_file_without_header.csv";
    private static final String WRONG_FILE_PATH = "random/path";
    private static final List<String[]> EXPECTED_DATA_FOR_CORRECT_READING_FROM_FILE = List.of(new String[]{
            "1", "B00813GRG4", "A1D87F6ZCVE5NK", "dll pa", "0", "0", "1", "1346976000",
            "Not as Advertised", "Product arrived labeled as Jumbo Salted Peanuts...the "
            + "peanuts were actually small sized unsalted. Not sure if this was an error or "
            + "if the vendor intended to represent the product as 'Jumbo'."
    }, new String[]{
            "2", "B001E4KFG0", "A3SGXH7AUHU8GW", "delmartian", "1", "1", "5", "1303862400",
            "Good Quality Dog Food", "I have bought several of the Vitality canned dog food "
            + "products and have found them all to be of good quality. The product looks more like "
            + "a stew than a processed meat and it smells better. My Labrador is finicky and she "
            + "appreciates this product better than  most."
    });

    @Test
    public void getExceptionWhenInvalidFilePath() {
        assertThrows(FileNotFoundException.class, () -> {
            new CsvReadingServiceImpl(new CSVReader(new FileReader(WRONG_FILE_PATH)));
        });
    }

    @Test
    public void correctReadingFromFile() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(FILE_PATH));
            CsvReadingService csvReadingService = new CsvReadingServiceImpl(csvReader);
            List<String[]> actualData = csvReadingService.read();
            for (int i = 0; i < actualData.size(); i++) {
                assertArrayEquals(EXPECTED_DATA_FOR_CORRECT_READING_FROM_FILE.get(i), actualData.get(i));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't to run test, file not found " + FILE_PATH, e);
        }
    }

    @Test
    public void correctReadingFromFileWithoutHeader() {
        try {
            CSVReader csvReader = new CSVReader(new FileReader(FILE_PATH_WITHOUT_HEADER));
            CsvReadingService csvReadingService = new CsvReadingServiceImpl(csvReader);
            List<String[]> actualData = csvReadingService.read();
            for (int i = 0; i < actualData.size(); i++) {
                assertArrayEquals(EXPECTED_DATA_FOR_CORRECT_READING_FROM_FILE.get(i), actualData.get(i));
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException("Can't to run test, file not found " + FILE_PATH_WITHOUT_HEADER, e);
        }
    }
}
