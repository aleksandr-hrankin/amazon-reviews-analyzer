package ua.antibyte.analyzer.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.response.ProductResponceDto;
import ua.antibyte.analyzer.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {
    private static final String PAGE_SIZE = "1000";
    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/most-commented")
    @ApiOperation("Get a list of the most commented products")
    public List<ProductResponceDto> getMostCommented(
            @ApiParam(value = "You can enter the number of products to return")
            @RequestParam(defaultValue = PAGE_SIZE) int quantity) {
        return productService.findMostCommented(quantity);
    }
}
