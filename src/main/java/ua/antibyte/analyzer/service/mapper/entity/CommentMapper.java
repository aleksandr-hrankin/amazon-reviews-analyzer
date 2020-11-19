package ua.antibyte.analyzer.service.mapper.entity;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.dto.request.CommentReqDto;

@Component
public class CommentMapper {
    public Comment map(CommentReqDto commentReqDto) {
        Comment comment = new Comment();
        comment.setHelpfulnessNumerator(commentReqDto.getHelpfulnessNumerator());
        comment.setHelpfulnessDenominator(commentReqDto.getHelpfulnessDenominator());
        comment.setScore(commentReqDto.getScore());
        comment.setTime(commentReqDto.getTime());
        comment.setSummary(commentReqDto.getSummary());
        comment.setText(commentReqDto.getText());
        return comment;
    }
}
