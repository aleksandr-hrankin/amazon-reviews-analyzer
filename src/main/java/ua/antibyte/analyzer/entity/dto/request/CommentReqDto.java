package ua.antibyte.analyzer.entity.dto.request;

import java.time.LocalDateTime;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CommentReqDto {
    private Long id;
    private String profileName;
    private int helpfulnessNumerator;
    private int helpfulnessDenominator;
    private int score;
    private LocalDateTime time;
    private String summary;
    private String text;
    private String productId;
    private String userId;
}
