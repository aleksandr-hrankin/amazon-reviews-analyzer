package ua.antibyte.analyzer.service.mapper.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.response.ProductRespDto;

class ProductRespDtoMapperTest {
    private static final ProductRespDto EXPECTED_PRODUCT_RESP_DTO
            = new ProductRespDto("B00813GRG4");
    private static final Product CORRECT_PRODUCT = new Product("B00813GRG4");
    private static final Product INCORRECT_EXTERNAL_ID_PRODUCT = new Product("incorrect");
    private static final Product EMPTY_EXTERNAL_ID_PRODUCT = new Product("");
    private static ProductRespDtoMapper productRespDtoMapper;

    @BeforeAll
    public static void before() {
        productRespDtoMapper = new ProductRespDtoMapper();
    }

    @Test
    public void mappingCorrectTest() {
        ProductRespDto actualProductRespDto = productRespDtoMapper.map(CORRECT_PRODUCT);
        assertEquals(EXPECTED_PRODUCT_RESP_DTO, actualProductRespDto);
    }

    @Test
    public void mappingIncorrectTest() {
        ProductRespDto actualProductRespDto
                = productRespDtoMapper.map(INCORRECT_EXTERNAL_ID_PRODUCT);
        assertNotEquals(EXPECTED_PRODUCT_RESP_DTO, actualProductRespDto);
    }

    @Test
    public void mappingEmptyProductExternalIdTest() {
        ProductRespDto actualProductRespDto = productRespDtoMapper.map(EMPTY_EXTERNAL_ID_PRODUCT);
        assertNotEquals(EXPECTED_PRODUCT_RESP_DTO, actualProductRespDto);
    }
}
