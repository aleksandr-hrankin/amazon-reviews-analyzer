package ua.antibyte.analyzer.service.impl;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.dto.CommentDto;
import ua.antibyte.analyzer.service.FileParser;

@Service
public class FileCsvParser implements FileParser<CommentDto> {
    private static final String[] FILE_HEADER = new String[]{
            "Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator",
            "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};

    @Override
    public List<CommentDto> parse(String path) {
        try {
            CSVParser csvParser = getCsvParser(Files.newBufferedReader(Paths.get(path)));
            List<CommentDto> commentDtos = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                if (FILE_HEADER[0].equals(csvRecord.get(FILE_HEADER[0]))) {
                    continue;
                }
                CommentDto commentDto = mapCsvRecordToCommentDto(csvRecord);
                commentDtos.add(commentDto);
            }
            return commentDtos;
        } catch (IOException e) {
            throw new RuntimeException("Can't parse file by path" + path, e);
        }
    }

    private CSVParser getCsvParser(Reader reader) throws IOException {
        return CSVFormat.DEFAULT
                .withHeader(FILE_HEADER)
                .withIgnoreHeaderCase()
                .parse(reader);
    }

    private CommentDto mapCsvRecordToCommentDto(CSVRecord csvRecord) {
        return CommentDto.builder()
                .id(csvRecord.get(FILE_HEADER[0]))
                .productId(csvRecord.get(FILE_HEADER[1]))
                .userId(csvRecord.get(FILE_HEADER[2]))
                .profileName(csvRecord.get(FILE_HEADER[3]))
                .helpfulnessNumerator(csvRecord.get(FILE_HEADER[4]))
                .helpfulnessDenominator(csvRecord.get(FILE_HEADER[5]))
                .score(csvRecord.get(FILE_HEADER[6]))
                .time(csvRecord.get(FILE_HEADER[7]))
                .summary(csvRecord.get(FILE_HEADER[8]))
                .text(csvRecord.get(FILE_HEADER[9]))
                .build();
    }
}
