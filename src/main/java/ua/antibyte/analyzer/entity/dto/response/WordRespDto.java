package ua.antibyte.analyzer.entity.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class WordRespDto {
    private String word;
    private Integer count;
}
