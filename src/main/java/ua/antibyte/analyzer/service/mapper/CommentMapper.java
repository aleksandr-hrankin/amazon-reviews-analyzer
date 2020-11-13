package ua.antibyte.analyzer.service.mapper;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.dto.CommentDto;
import ua.antibyte.analyzer.entity.Comment;

@Component
public class CommentMapper {
    private final ProductMapper productMapper;
    private final UserMapper userMapper;

    public CommentMapper(ProductMapper productMapper, UserMapper userMapper) {
        this.productMapper = productMapper;
        this.userMapper = userMapper;
    }

    public Comment map(CommentDto commentDto) {
        Comment comment = new Comment();
        comment.setHelpfulnessNumerator(commentDto.getHelpfulnessNumerator());
        comment.setHelpfulnessDenominator(commentDto.getHelpfulnessDenominator());
        comment.setScore(commentDto.getScore());
        comment.setTime(commentDto.getTime());
        comment.setSummary(commentDto.getSummary());
        comment.setText(commentDto.getText());
        comment.setProduct(productMapper.map(commentDto));
        comment.setUser(userMapper.map(commentDto));
        return comment;
    }
}
