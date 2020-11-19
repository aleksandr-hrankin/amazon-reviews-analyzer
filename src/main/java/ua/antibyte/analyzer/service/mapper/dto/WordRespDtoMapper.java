package ua.antibyte.analyzer.service.mapper.dto;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Word;
import ua.antibyte.analyzer.entity.dto.response.WordRespDto;

@Component
public class WordRespDtoMapper {
    public WordRespDto map(Word word) {
        WordRespDto wordRespDto = new WordRespDto();
        wordRespDto.setWord(word.getWord());
        wordRespDto.setCount(word.getCount());
        return wordRespDto;
    }
}
