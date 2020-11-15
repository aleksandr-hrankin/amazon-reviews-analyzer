package ua.antibyte.analyzer.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.antibyte.analyzer.dto.CommentDto;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.Role;
import ua.antibyte.analyzer.entity.User;

class CommentMapperTest {
    private static final CommentDto FULL_COMMENT_DTO = CommentDto.builder()
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
    private static final CommentDto COMMENT_DTO_WITHOUT_COMMENT_FIELDS = CommentDto.builder()
            .productId("B00813GRG4")
            .userId("A1D87F6ZCVE5NK")
            .profileName("dll pa")
            .build();
    private static final CommentDto INCOMPLETE_COMMENT_DTO = CommentDto.builder()
            .id(1L)
            .productId("B00813GRG4")
            .userId("A1D87F6ZCVE5NK")
            .profileName("dll pa")
            .score(1)
            .time(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                    ZoneId.systemDefault()))
            .summary("Not as Advertised")
            .build();
    private static final CommentDto EMPTY_COMMENT_DTO = CommentDto.builder().build();
    private static ProductMapper productMapper;
    private static UserMapper userMapper;
    private static CommentMapper commentMapper;

    @BeforeAll
    public static void beforeAll() {
        productMapper = Mockito.mock(ProductMapper.class);
        userMapper = Mockito.mock(UserMapper.class);
        commentMapper = new CommentMapper(productMapper, userMapper);
    }

    @Test
    public void mappingFullCommentDtoTest() {
        Comment expectedComment = createCommentWithUserAndProduct(FULL_COMMENT_DTO);
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
        Comment expectedComment = createCommentWithUserAndProduct(COMMENT_DTO_WITHOUT_COMMENT_FIELDS);
        Comment actualComment = commentMapper.map(COMMENT_DTO_WITHOUT_COMMENT_FIELDS);
        assertEquals(expectedComment, actualComment);
    }

    @Test
    public void mappingIncompleteCommentDtoTest() {
        Comment expectedComment = createCommentWithUserAndProduct(INCOMPLETE_COMMENT_DTO);
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

    private Comment createCommentWithUserAndProduct(CommentDto commentDto) {
        Product product = new Product("B00813GRG4");
        when(productMapper.map(commentDto)).thenReturn(product);

        User user = new User("1111", Set.of(Role.of("USER")));
        user.setExternalId("A1D87F6ZCVE5NK");
        user.setProfileName("dll pa");
        when(userMapper.map(commentDto)).thenReturn(user);

        Comment comment = new Comment();
        comment.setProduct(product);
        comment.setUser(user);
        return comment;
    }
}
