package ua.antibyte.analyzer.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.antibyte.analyzer.entity.Word;

@Repository
public interface WordRepository extends JpaRepository<Word, Integer> {
    List<Word> findAllByOrderByCountDesc(Pageable pageable);
}
