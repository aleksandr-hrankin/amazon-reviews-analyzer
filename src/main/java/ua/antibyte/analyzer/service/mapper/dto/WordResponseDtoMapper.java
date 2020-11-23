package ua.antibyte.analyzer.service.mapper.dto;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Word;
import ua.antibyte.analyzer.entity.dto.response.WordResponseDto;

@Component
public class WordResponseDtoMapper {
    public WordResponseDto map(Word word) {
        WordResponseDto wordResponseDto = new WordResponseDto();
        wordResponseDto.setWord(word.getWord());
        wordResponseDto.setCount(word.getCount());
        return wordResponseDto;
    }
}
