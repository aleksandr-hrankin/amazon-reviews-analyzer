package ua.antibyte.analyzer.service.impl;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
    public Page<Word> findMostUsedWords(Pageable pageable) {
        return wordRepository.findAllByOrderByCountDesc(pageable);
    }
}
