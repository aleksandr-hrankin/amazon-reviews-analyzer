package ua.antibyte.analyzer.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.response.WordRespDto;
import ua.antibyte.analyzer.service.WordService;
import ua.antibyte.analyzer.service.mapper.dto.WordRespDtoMapper;

@RestController
@RequestMapping("comments")
public class CommentController {
    private static final String PAGE_SIZE = "1000";
    private final WordService wordService;
    private final WordRespDtoMapper wordRespDtoMapper;

    public CommentController(WordService wordService,
                             WordRespDtoMapper wordRespDtoMapper) {
        this.wordService = wordService;
        this.wordRespDtoMapper = wordRespDtoMapper;
    }

    @GetMapping("most-used-words")
    public Page<WordRespDto> getMostUsedWords(@RequestParam(defaultValue = PAGE_SIZE) int size) {
        return wordService.findMostUsedWords(size).map(wordRespDtoMapper::map);
    }
}
