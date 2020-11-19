package ua.antibyte.analyzer.service.counter;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.Comment;

class WordCounterInCommentsTest {
    private static WordCounterInComments wordCounterInComments;

    @BeforeAll
    public static void before() {
        wordCounterInComments = new WordCounterInComments();
    }

    @Test
    public void countWordsInOneCommentTest() {
        Map<String, Integer> expectedWords = Map.of(
                "this", 1,
                "test", 2,
                "is", 1,
                "a", 1,
                "simple", 1);
        Comment comment = new Comment();
        comment.setText("This test is a simple test");
        List<Comment> comments = List.of(comment);
        Map<String, Integer> actualWords = wordCounterInComments.count(comments);
        assertEquals(expectedWords, actualWords);
    }

    @Test
    public void countWordsInEmptyCommentTest() {
        Map<String, Integer> expectedWords = Map.of();
        Comment comment = new Comment();
        comment.setText("");
        List<Comment> comments = List.of(comment);
        Map<String, Integer> actualWords = wordCounterInComments.count(comments);
        assertEquals(expectedWords, actualWords);
    }
}
