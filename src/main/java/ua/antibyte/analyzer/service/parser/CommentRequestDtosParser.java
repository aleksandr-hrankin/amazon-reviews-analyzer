package ua.antibyte.analyzer.service.parser;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.Product;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.request.CommentReqDto;
import ua.antibyte.analyzer.service.mapper.entity.CommentMapper;
import ua.antibyte.analyzer.service.mapper.entity.ProductMapper;
import ua.antibyte.analyzer.service.mapper.entity.UserMapper;

@Component
public class CommentRequestDtosParser {
    private static final Map<String, Product> products = new HashMap<>();
    private static final Map<String, User> users = new HashMap<>();
    private final ProductMapper productMapper;
    private final UserMapper userMapper;
    private final CommentMapper commentMapper;

    public CommentRequestDtosParser(ProductMapper productMapper,
                                    UserMapper userMapper,
                                    CommentMapper commentMapper) {
        this.productMapper = productMapper;
        this.userMapper = userMapper;
        this.commentMapper = commentMapper;
    }

    public List<Comment> parse(List<CommentReqDto> commentReqDtos) {
        return commentReqDtos.stream()
                .map(commentRequestDto -> {
                    Product product = productMapper.map(commentRequestDto);
                    products.putIfAbsent(product.getExternalId(), product);

                    User user = userMapper.map(commentRequestDto);
                    users.putIfAbsent(user.getExternalId(), user);

                    Comment comment = commentMapper.map(commentRequestDto);
                    comment.setProduct(products.get(product.getExternalId()));
                    comment.setUser(users.get(user.getExternalId()));
                    return comment;
                })
                .collect(Collectors.toList());
    }
}
