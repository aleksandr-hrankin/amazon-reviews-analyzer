package ua.antibyte.analyzer.service.mapper.dto;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.response.ProductRespDto;

@Component
public class ProductRespDtoMapper {
    public ProductRespDto map(Product product) {
        ProductRespDto productRespDto = new ProductRespDto();
        productRespDto.setExternalId(product.getExternalId());
        return productRespDto;
    }
}
