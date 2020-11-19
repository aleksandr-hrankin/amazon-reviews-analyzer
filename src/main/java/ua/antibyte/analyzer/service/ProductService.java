package ua.antibyte.analyzer.service;

import org.springframework.data.domain.Page;
import ua.antibyte.analyzer.entity.dto.response.ProductRespDto;

public interface ProductService {
    Page<ProductRespDto> findMostCommented(int size);
}
