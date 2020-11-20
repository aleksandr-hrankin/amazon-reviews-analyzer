package ua.antibyte.analyzer.service.mapper.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;

class ProductMapperTest {
    private static final CommentRequestDto FULL_COMMENT_DTO = CommentRequestDto.builder()
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
    private static final CommentRequestDto COMMENT_DTO_WITHOUT_PRODUCT_FIELDS
            = CommentRequestDto.builder()
            .id(1L)
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
    private static final CommentRequestDto EMPTY_COMMENT_DTO = CommentRequestDto.builder().build();
    private static ProductMapper productMapper;

    @BeforeAll
    public static void beforeAll() {
        productMapper = new ProductMapper();
    }

    @Test
    public void mappingFullCommentDtoTest() {
        Product expectedProduct = new Product("B00813GRG4");
        Product actualProduct = productMapper.map(FULL_COMMENT_DTO);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void mappingCommentDtoWithoutProductFieldsTest() {
        Product expectedProduct = new Product();
        Product actualProduct = productMapper.map(COMMENT_DTO_WITHOUT_PRODUCT_FIELDS);
        assertEquals(expectedProduct, actualProduct);
    }

    @Test
    public void mappingEmptyCommentDtoTest() {
        Product expectedProduct = new Product();
        Product actualProduct = productMapper.map(EMPTY_COMMENT_DTO);
        assertEquals(expectedProduct, actualProduct);
    }
}
