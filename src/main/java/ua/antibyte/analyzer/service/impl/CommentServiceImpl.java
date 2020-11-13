package ua.antibyte.analyzer.service.impl;

import java.util.List;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.repository.CommentRepository;
import ua.antibyte.analyzer.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService {
    private final CommentRepository commentRepository;

    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public void saveAll(List<Comment> comments) {
        commentRepository.saveAll(comments);
    }
}
