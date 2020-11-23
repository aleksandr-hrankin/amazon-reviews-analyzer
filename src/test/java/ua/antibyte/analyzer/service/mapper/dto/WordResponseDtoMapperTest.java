package ua.antibyte.analyzer.service.mapper.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Word;
import ua.antibyte.analyzer.entity.dto.response.WordResponseDto;

class WordResponseDtoMapperTest {
    private static final WordResponseDto EXPECTED_WORD_RESP_DTO = new WordResponseDto("word", 1);
    private static final Word CORRECT_WORD = new Word("word", 1);
    private static final Word INCORRECT_WORD = new Word("incorrect", 1);
    private static final Word ZERO_WORDS = new Word("word", 0);
    private static final Word EMPTY_WORD = new Word("", 1);
    private static WordResponseDtoMapper wordResponseDtoMapper;

    @BeforeAll
    public static void before() {
        wordResponseDtoMapper = new WordResponseDtoMapper();
    }

    @Test
    public void mappingCorrectTest() {
        WordResponseDto actualWordDto = wordResponseDtoMapper.map(CORRECT_WORD);
        assertEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }

    @Test
    public void mappingIncorrectTest() {
        WordResponseDto actualWordDto = wordResponseDtoMapper.map(INCORRECT_WORD);
        assertNotEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }

    @Test
    public void mappingZeroWordsTest() {
        WordResponseDto actualWordDto = wordResponseDtoMapper.map(ZERO_WORDS);
        assertNotEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }

    @Test
    public void mappingEmptyWordTest() {
        WordResponseDto actualWordDto = wordResponseDtoMapper.map(EMPTY_WORD);
        assertNotEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }
}
