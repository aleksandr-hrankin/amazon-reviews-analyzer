package ua.antibyte.analyzer.service.mapper.entity;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;

@Component
public class ProductMapper {
    public Product map(CommentRequestDto commentRequestDto) {
        Product product = new Product();
        product.setExternalId(commentRequestDto.getProductId());
        return product;
    }
}
