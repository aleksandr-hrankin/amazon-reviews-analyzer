package ua.antibyte.analyzer.service.mapper.entity;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;

@Component
public class CommentMapper {
    public Comment map(CommentRequestDto commentRequestDto) {
        Comment comment = new Comment();
        comment.setHelpfulnessNumerator(commentRequestDto.getHelpfulnessNumerator());
        comment.setHelpfulnessDenominator(commentRequestDto.getHelpfulnessDenominator());
        comment.setScore(commentRequestDto.getScore());
        comment.setTime(commentRequestDto.getTime());
        comment.setSummary(commentRequestDto.getSummary());
        comment.setText(commentRequestDto.getText());
        return comment;
    }
}
