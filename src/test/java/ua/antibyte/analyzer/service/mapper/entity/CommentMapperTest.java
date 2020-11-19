package ua.antibyte.analyzer.service.mapper.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.dto.request.CommentReqDto;

class CommentMapperTest {
    private static final CommentReqDto FULL_COMMENT_DTO = CommentReqDto.builder()
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
            .build();
    private static final CommentReqDto COMMENT_DTO_WITHOUT_COMMENT_FIELDS = CommentReqDto.builder()
            .productId("B00813GRG4")
            .userId("A1D87F6ZCVE5NK")
            .profileName("dll pa")
            .build();
    private static final CommentReqDto INCOMPLETE_COMMENT_DTO = CommentReqDto.builder()
            .id(1L)
            .productId("B00813GRG4")
            .userId("A1D87F6ZCVE5NK")
            .profileName("dll pa")
            .score(1)
            .time(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                    ZoneId.systemDefault()))
            .summary("Not as Advertised")
            .build();
    private static final CommentReqDto EMPTY_COMMENT_DTO = CommentReqDto.builder().build();
    private static CommentMapper commentMapper;

    @BeforeAll
    public static void beforeAll() {
        commentMapper = new CommentMapper();
    }

    @Test
    public void mappingFullCommentDtoTest() {
        Comment expectedComment = new Comment();
        expectedComment.setHelpfulnessNumerator(0);
        expectedComment.setHelpfulnessDenominator(0);
        expectedComment.setScore(1);
        expectedComment.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                ZoneId.systemDefault()));
        expectedComment.setSummary("Not as Advertised");
        expectedComment.setText("Product arrived labeled as Jumbo Salted Peanuts...the "
                + "peanuts were actually small sized unsalted. Not sure if "
                + "this was an error or if the vendor intended to represent "
                + "the product as 'Jumbo'.");

        Comment actualComment = commentMapper.map(FULL_COMMENT_DTO);
        assertEquals(expectedComment, actualComment);
    }

    @Test
    public void mappingCommentDtoWithoutCommentFieldsTest() {
        Comment expectedComment = new Comment();
        Comment actualComment = commentMapper.map(COMMENT_DTO_WITHOUT_COMMENT_FIELDS);
        assertEquals(expectedComment, actualComment);
    }

    @Test
    public void mappingIncompleteCommentDtoTest() {
        Comment expectedComment = new Comment();
        expectedComment.setScore(1);
        expectedComment.setTime(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                ZoneId.systemDefault()));
        expectedComment.setSummary("Not as Advertised");

        Comment actualComment = commentMapper.map(INCOMPLETE_COMMENT_DTO);
        assertEquals(expectedComment, actualComment);
    }

    @Test
    public void mappingEmptyCommentDtoTest() {
        Comment expectedComment = new Comment();
        Comment actualComment = commentMapper.map(EMPTY_COMMENT_DTO);
        assertEquals(expectedComment, actualComment);
    }
}
