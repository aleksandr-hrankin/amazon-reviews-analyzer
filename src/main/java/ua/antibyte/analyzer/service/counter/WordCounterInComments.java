package ua.antibyte.analyzer.service.counter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.Comment;

@Component
public class WordCounterInComments {
    private static final String SEPARATOR_PATTERN = "([ ,.;!?]\\s*)";

    public Map<String, Integer> count(List<Comment> comments) {
        Map<String, Integer> allWords = new HashMap<>();
        for (Comment comment : comments) {
            if ("".equals(comment.getText())) {
                continue;
            }
            String[] wordsText = comment.getText().toLowerCase().trim().split(SEPARATOR_PATTERN);
            for (String word : wordsText) {
                allWords.merge(word, 1, Integer::sum);
            }
        }
        return allWords;
    }
}
