package ua.antibyte.analyzer.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.response.ProductRespDto;
import ua.antibyte.analyzer.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
    private static final String PAGE_SIZE = "1000";
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("most-commented")
    public Page<ProductRespDto> getMostCommented(@RequestParam(defaultValue = PAGE_SIZE) int size) {
        return productService.findMostCommented(size);
    }
}