package ua.antibyte.analyzer.service.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;
import ua.antibyte.analyzer.service.mapper.entity.CommentMapper;
import ua.antibyte.analyzer.service.mapper.entity.FromCommentToUserMapper;
import ua.antibyte.analyzer.service.mapper.entity.ProductMapper;

@Component
public class CommentRequestDtosParser {
    private final ProductMapper productMapper;
    private final FromCommentToUserMapper fromCommentToUserMapper;
    private final CommentMapper commentMapper;

    public CommentRequestDtosParser(ProductMapper productMapper,
                                    FromCommentToUserMapper fromCommentToUserMapper,
                                    CommentMapper commentMapper) {
        this.productMapper = productMapper;
        this.fromCommentToUserMapper = fromCommentToUserMapper;
        this.commentMapper = commentMapper;
    }

    public List<Comment> parse(List<CommentRequestDto> commentRequestDtos) {
        Map<String, Product> products = new HashMap<>();
        Map<String, User> users = new HashMap<>();
        return commentRequestDtos.stream()
                .map(commentRequestDto -> {
                    Product product = productMapper.map(commentRequestDto);
                    products.putIfAbsent(product.getExternalId(), product);

                    User user = fromCommentToUserMapper.map(commentRequestDto);
                    users.putIfAbsent(user.getExternalId(), user);

                    Comment comment = commentMapper.map(commentRequestDto);
                    comment.setProduct(products.get(product.getExternalId()));
                    comment.setUser(users.get(user.getExternalId()));
                    return comment;
                })
                .collect(Collectors.toList());
    }
}
