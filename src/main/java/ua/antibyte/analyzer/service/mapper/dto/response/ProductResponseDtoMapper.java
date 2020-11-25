package ua.antibyte.analyzer.service.mapper.dto.response;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.response.ProductResponceDto;

@Component
public class ProductResponseDtoMapper {
    public ProductResponceDto map(Product product) {
        ProductResponceDto productResponceDto = new ProductResponceDto();
        productResponceDto.setExternalId(product.getExternalId());
        return productResponceDto;
    }
}
