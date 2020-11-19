package ua.antibyte.analyzer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.dto.response.ProductRespDto;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
    @Query(value = "select new ua.antibyte.analyzer.entity.dto.response.ProductRespDto("
            + "c.product.externalId) "
            + "from Comment c "
            + "group by c.product.externalId "
            + "order by count(c) desc ",
            countQuery = "select count(c.product.externalId) "
                    + "from Comment c "
                    + "group by c.product.externalId "
                    + "order by count(c) desc ")
    Page<ProductRespDto> findMostCommented(Pageable pageable);
}
