package ua.antibyte.analyzer.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.response.ProductResponceDto;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query("select new ua.antibyte.analyzer.entity.dto.response.ProductResponceDto("
            + "c.product.externalId) "
            + "from Comment c "
            + "group by c.product.externalId "
            + "order by count(c) desc ")
    List<ProductResponceDto> findMostCommented(Pageable pageable);
}
