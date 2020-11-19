package ua.antibyte.analyzer.service;

import java.util.List;
import org.springframework.data.domain.Page;
import ua.antibyte.analyzer.entity.Word;

public interface WordService {
    void saveAll(List<Word> words);

    Page<Word> findMostUsedWords(int size);
}
