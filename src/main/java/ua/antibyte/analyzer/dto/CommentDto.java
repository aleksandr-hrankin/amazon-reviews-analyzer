package ua.antibyte.analyzer.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentDto {
    private String id;
    private String productId;
    private String userId;
    private String profileName;
    private String helpfulnessNumerator;
    private String helpfulnessDenominator;
    private String score;
    private String time;
    private String summary;
    private String text;
}
