package ua.antibyte.analyzer.service.mapper.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Word;
import ua.antibyte.analyzer.entity.dto.response.WordRespDto;

class WordRespDtoMapperTest {
    private static final WordRespDto EXPECTED_WORD_RESP_DTO = new WordRespDto("word", 1);
    private static final Word CORRECT_WORD = new Word("word", 1);
    private static final Word INCORRECT_WORD = new Word("incorrect", 1);
    private static final Word ZERO_WORDS = new Word("word", 0);
    private static final Word EMPTY_WORD = new Word("", 1);
    private static WordRespDtoMapper wordRespDtoMapper;

    @BeforeAll
    public static void before() {
        wordRespDtoMapper = new WordRespDtoMapper();
    }

    @Test
    public void mappingCorrectTest() {
        WordRespDto actualWordDto = wordRespDtoMapper.map(CORRECT_WORD);
        assertEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }

    @Test
    public void mappingIncorrectTest() {
        WordRespDto actualWordDto = wordRespDtoMapper.map(INCORRECT_WORD);
        assertNotEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }

    @Test
    public void mappingZeroWordsTest() {
        WordRespDto actualWordDto = wordRespDtoMapper.map(ZERO_WORDS);
        assertNotEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }

    @Test
    public void mappingEmptyWordTest() {
        WordRespDto actualWordDto = wordRespDtoMapper.map(EMPTY_WORD);
        assertNotEquals(EXPECTED_WORD_RESP_DTO, actualWordDto);
    }
}
