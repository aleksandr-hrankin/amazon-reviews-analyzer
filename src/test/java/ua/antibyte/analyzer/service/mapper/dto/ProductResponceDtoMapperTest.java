package ua.antibyte.analyzer.service.mapper.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.response.ProductResponceDto;

class ProductResponceDtoMapperTest {
    private static final ProductResponceDto EXPECTED_PRODUCT_RESP_DTO
            = new ProductResponceDto("B00813GRG4");
    private static final Product CORRECT_PRODUCT = new Product("B00813GRG4");
    private static final Product INCORRECT_EXTERNAL_ID_PRODUCT = new Product("incorrect");
    private static final Product EMPTY_EXTERNAL_ID_PRODUCT = new Product("");
    private static ProductResponseDtoMapper productResponseDtoMapper;

    @BeforeAll
    public static void before() {
        productResponseDtoMapper = new ProductResponseDtoMapper();
    }

    @Test
    public void mappingCorrectTest() {
        ProductResponceDto actualProductResponceDto = productResponseDtoMapper.map(CORRECT_PRODUCT);
        assertEquals(EXPECTED_PRODUCT_RESP_DTO, actualProductResponceDto);
    }

    @Test
    public void mappingIncorrectTest() {
        ProductResponceDto actualProductResponceDto
                = productResponseDtoMapper.map(INCORRECT_EXTERNAL_ID_PRODUCT);
        assertNotEquals(EXPECTED_PRODUCT_RESP_DTO, actualProductResponceDto);
    }

    @Test
    public void mappingEmptyProductExternalIdTest() {
        ProductResponceDto actualProductResponceDto
                = productResponseDtoMapper.map(EMPTY_EXTERNAL_ID_PRODUCT);
        assertNotEquals(EXPECTED_PRODUCT_RESP_DTO, actualProductResponceDto);
    }
}
