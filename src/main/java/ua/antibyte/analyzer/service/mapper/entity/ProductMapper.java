package ua.antibyte.analyzer.service.mapper.entity;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.request.CommentReqDto;

@Component
public class ProductMapper {
    public Product map(CommentReqDto commentReqDto) {
        Product product = new Product();
        product.setExternalId(commentReqDto.getProductId());
        return product;
    }
}
