package ua.antibyte.analyzer.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.dto.response.ProductRespDto;
import ua.antibyte.analyzer.repository.ProductRepository;
import ua.antibyte.analyzer.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Page<ProductRespDto> findMostCommented(Pageable pageable) {
        return productRepository.findMostCommented(pageable);
    }
}
