package ua.antibyte.analyzer.service;

import java.util.List;
import ua.antibyte.analyzer.entity.dto.response.ProductResponceDto;

public interface ProductService {
    List<ProductResponceDto> findMostCommented(int quantity);
}
