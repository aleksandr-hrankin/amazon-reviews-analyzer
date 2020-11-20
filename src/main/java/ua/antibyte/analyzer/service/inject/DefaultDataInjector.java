package ua.antibyte.analyzer.service.inject;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.Comment;
import ua.antibyte.analyzer.entity.Role;
import ua.antibyte.analyzer.entity.Word;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;
import ua.antibyte.analyzer.service.CommentService;
import ua.antibyte.analyzer.service.RoleService;
import ua.antibyte.analyzer.service.WordService;
import ua.antibyte.analyzer.service.counter.WordCounterInComments;
import ua.antibyte.analyzer.service.parser.CommentRequestDtosParser;
import ua.antibyte.analyzer.service.parser.FileCsvParser;

@Service
@Log4j2
public class DefaultDataInjector {
    private static final String FILE_PATH = "src/main/resources/Test.csv";
    private final RoleService roleService;
    private final FileCsvParser<CommentRequestDto> fileCsvParser;
    private final CommentRequestDtosParser commentRequestDtosParser;
    private final CommentService commentService;
    private final WordCounterInComments wordCounterInComments;
    private final WordService wordService;

    public DefaultDataInjector(RoleService roleService,
                               FileCsvParser<CommentRequestDto> fileCsvParser,
                               CommentRequestDtosParser commentRequestDtosParser,
                               CommentService commentService,
                               WordCounterInComments wordCounterInComments,
                               WordService wordService) {
        this.roleService = roleService;
        this.fileCsvParser = fileCsvParser;
        this.commentRequestDtosParser = commentRequestDtosParser;
        this.commentService = commentService;
        this.wordCounterInComments = wordCounterInComments;
        this.wordService = wordService;
    }

    @PostConstruct
    public void inject() {
        injectRoles();
        injectData();
    }

    private void injectRoles() {
        roleService.save(Role.of("ADMIN"));
        roleService.save(Role.of("USER"));
        log.info("Roles added SUCCESSFULLY");
    }

    private void injectData() {
        List<CommentRequestDto> commentRequestDtos = fileCsvParser.parse(FILE_PATH);
        log.info("File parsed SUCCESSFULLY [path:" + FILE_PATH + "]");

        List<Comment> comments = commentRequestDtosParser.parse(commentRequestDtos);
        log.info("CommentRequestDtos parsed to comments SUCCESSFULLY");

        commentService.saveAll(comments);
        log.info("Comments saved SUCCESSFULLY");

        Map<String, Integer> wordCount = wordCounterInComments.count(comments);
        log.info("Words in comments were counted SUCCESSFULLY");

        List<Word> words = wordCount.entrySet().stream()
                .map(entry -> new Word(entry.getKey(), entry.getValue()))
                .collect(Collectors.toList());
        log.info("Words mapped SUCCESSFULLY");

        wordService.saveAll(words);
        log.info("Words saved SUCCESSFULLY");
    }
}
