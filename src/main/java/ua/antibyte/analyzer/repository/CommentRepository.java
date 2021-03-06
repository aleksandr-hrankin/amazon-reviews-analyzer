package ua.antibyte.analyzer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.antibyte.analyzer.entity.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {
}
