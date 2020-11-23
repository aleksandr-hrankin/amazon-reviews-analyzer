package ua.antibyte.analyzer.service.impl;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.Word;
import ua.antibyte.analyzer.repository.WordRepository;
import ua.antibyte.analyzer.service.WordService;

@Service
public class WordServiceImpl implements WordService {
    private final WordRepository wordRepository;

    public WordServiceImpl(WordRepository wordRepository) {
        this.wordRepository = wordRepository;
    }

    @Override
    public void saveAll(List<Word> words) {
        wordRepository.saveAll(words);
    }

    @Override
    public List<Word> findMostUsedWords(int quantity) {
        return wordRepository.findAllByOrderByCountDesc(PageRequest.of(0, quantity));
    }
}
