package ua.antibyte.analyzer.service;

import java.util.List;
import ua.antibyte.analyzer.entity.Comment;

public interface CommentService {
    void saveAll(List<Comment> entities);
}
