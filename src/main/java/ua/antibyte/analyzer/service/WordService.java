package ua.antibyte.analyzer.service;

import java.util.List;
import ua.antibyte.analyzer.entity.Word;

public interface WordService {
    void saveAll(List<Word> words);

    List<Word> findMostUsedWords(int quantity);
}
