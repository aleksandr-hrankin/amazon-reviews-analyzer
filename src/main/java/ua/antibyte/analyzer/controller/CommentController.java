package ua.antibyte.analyzer.controller;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.response.WordResponseDto;
import ua.antibyte.analyzer.service.WordService;
import ua.antibyte.analyzer.service.mapper.dto.WordResponseDtoMapper;

@RestController
@RequestMapping("/comments")
public class CommentController {
    private static final String PAGE_SIZE = "1000";
    private final WordService wordService;
    private final WordResponseDtoMapper wordResponseDtoMapper;

    public CommentController(WordService wordService,
                             WordResponseDtoMapper wordResponseDtoMapper) {
        this.wordService = wordService;
        this.wordResponseDtoMapper = wordResponseDtoMapper;
    }

    @GetMapping("/most-used-words")
    public List<WordResponseDto> getMostUsedWords(
            @RequestParam(defaultValue = PAGE_SIZE) int quantity) {
        return wordService.findMostUsedWords(quantity).stream()
                .map(wordResponseDtoMapper::map)
                .collect(Collectors.toList());
    }
}
