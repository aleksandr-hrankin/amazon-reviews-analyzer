package ua.antibyte.analyzer.service.parser;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.dto.request.CommentReqDto;

@Service
public class CommentFileCsvParser implements FileCsvParser<CommentReqDto> {
    private static final String[] FILE_HEADER = new String[]{
            "Id", "ProductId", "UserId", "ProfileName", "HelpfulnessNumerator",
            "HelpfulnessDenominator", "Score", "Time", "Summary", "Text"};

    @Override
    public List<CommentReqDto> parse(String path) {
        try {
            CSVParser csvParser = getCsvParser(Files.newBufferedReader(Paths.get(path)));
            List<CommentReqDto> commentReqDtos = new ArrayList<>();
            for (CSVRecord csvRecord : csvParser) {
                CommentReqDto commentReqDto = mapCsvRecordToCommentDto(csvRecord);
                commentReqDtos.add(commentReqDto);
            }
            return commentReqDtos;
        } catch (IOException e) {
            throw new RuntimeException("Can't parse file by path: " + path, e);
        }
    }

    private CSVParser getCsvParser(Reader reader) throws IOException {
        return CSVFormat.DEFAULT
                .withHeader(FILE_HEADER)
                .withFirstRecordAsHeader()
                .parse(reader);
    }

    private CommentReqDto mapCsvRecordToCommentDto(CSVRecord csvRecord) {
        return CommentReqDto.builder()
                .id(Long.parseLong(csvRecord.get(FILE_HEADER[0])))
                .productId(csvRecord.get(FILE_HEADER[1]))
                .userId(csvRecord.get(FILE_HEADER[2]))
                .profileName(csvRecord.get(FILE_HEADER[3]))
                .helpfulnessNumerator(Integer.parseInt(csvRecord.get(FILE_HEADER[4])))
                .helpfulnessDenominator(Integer.parseInt(csvRecord.get(FILE_HEADER[5])))
                .score(Integer.parseInt(csvRecord.get(FILE_HEADER[6])))
                .time(LocalDateTime.ofInstant(
                        Instant.ofEpochSecond(Long.parseLong(csvRecord.get(FILE_HEADER[7]))),
                        ZoneId.systemDefault()))
                .summary(csvRecord.get(FILE_HEADER[8]))
                .text(csvRecord.get(FILE_HEADER[9]))
                .build();
    }
}
