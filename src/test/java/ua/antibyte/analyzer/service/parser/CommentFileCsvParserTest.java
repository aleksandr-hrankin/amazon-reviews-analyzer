package ua.antibyte.analyzer.service.parser;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;

class CommentFileCsvParserTest {
    private static final String WRONG_FILE_PATH = "random/path";
    private static final String EMPTY_FILE = "src/test/resources/test_empty_file.csv";
    private static final String EMPTY_FILE_WITH_HEADER
            = "src/test/resources/test_empty_file_with_header.csv";
    private static final String FILE_PATH = "src/test/resources/test_file.csv";
    private static final String FILE_PATH_WITHOUT_HEADER
            = "src/test/resources/test_file_without_header.csv";
    private static final List<CommentRequestDto> EXPECTED_COMMENT_DTOS = List.of(
            CommentRequestDto.builder()
                    .id(1L)
                    .productId("B00813GRG4")
                    .userId("A1D87F6ZCVE5NK")
                    .profileName("dll pa")
                    .helpfulnessNumerator(0)
                    .helpfulnessDenominator(0)
                    .score(1)
                    .time(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                            ZoneId.systemDefault()))
                    .summary("Not as Advertised")
                    .text("Product arrived labeled as Jumbo Salted Peanuts...the "
                            + "peanuts were actually small sized unsalted. Not sure if "
                            + "this was an error or if the vendor intended to represent "
                            + "the product as 'Jumbo'.")
                    .build(),
            CommentRequestDto.builder()
                    .id(2L)
                    .productId("B001E4KFG0")
                    .userId("A3SGXH7AUHU8GW")
                    .profileName("delmartian")
                    .helpfulnessNumerator(1)
                    .helpfulnessDenominator(1)
                    .score(5)
                    .time(LocalDateTime.ofInstant(Instant.ofEpochSecond(1303862400),
                            ZoneId.systemDefault()))
                    .summary("Good Quality Dog Food")
                    .text("I have bought several of the Vitality canned dog food products and "
                            + "have found them all to be of good quality. The product "
                            + "looks more like a stew than a processed meat and it "
                            + "smells better. My Labrador is finicky "
                            + "and she appreciates this product better than  most.")
                    .build()
    );

    private static FileCsvParser<CommentRequestDto> fileCsvParser;

    @BeforeAll
    static void beforeAll() {
        fileCsvParser = new CommentFileCsvParser();
    }

    @Test
    public void getExceptionWhenInvalidFilePathTest() {
        assertThrows(RuntimeException.class, () -> {
            fileCsvParser.parse(WRONG_FILE_PATH);
        });
    }

    @Test
    public void parsingWhenEmptyFileTest() {
        List<CommentRequestDto> expected = Collections.emptyList();
        List<CommentRequestDto> actual = fileCsvParser.parse(EMPTY_FILE);
        assertEquals(expected, actual);
    }

    @Test
    public void parsingWhenEmptyFileWithHeaderTest() {
        List<CommentRequestDto> expected = Collections.emptyList();
        List<CommentRequestDto> actual = fileCsvParser.parse(EMPTY_FILE_WITH_HEADER);
        assertEquals(expected, actual);
    }

    @Test
    public void correctParsingFromFileTest() {
        List<CommentRequestDto> actualData = fileCsvParser.parse(FILE_PATH);
        equalsCommentDtoLists(EXPECTED_COMMENT_DTOS, actualData);
    }

    @Test
    public void parsingFromFileWithoutHeaderTest() {
        assertThrows(RuntimeException.class, () -> {
            fileCsvParser.parse(FILE_PATH_WITHOUT_HEADER);
        });
    }

    private void equalsCommentDtoLists(List<CommentRequestDto> expected,
                                       List<CommentRequestDto> actual) {
        for (int i = 0; i < actual.size(); i++) {
            assertEquals(expected.get(i), actual.get(i));
        }
    }
}
