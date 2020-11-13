package ua.antibyte.analyzer.service.mapper;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.dto.CommentDto;
import ua.antibyte.analyzer.entity.Product;

@Component
public class ProductMapper {
    public Product map(CommentDto commentDto) {
        Product product = new Product();
        product.setExternalId(commentDto.getProductId());
        return product;
    }
}
