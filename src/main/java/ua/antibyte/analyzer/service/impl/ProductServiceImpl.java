package ua.antibyte.analyzer.service.impl;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.dto.response.ProductResponceDto;
import ua.antibyte.analyzer.repository.ProductRepository;
import ua.antibyte.analyzer.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponceDto> findMostCommented(int quantity) {
        return productRepository.findMostCommented(PageRequest.of(0, quantity));
    }
}
