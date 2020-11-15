package ua.antibyte.analyzer.service.parser;

import java.util.List;

public interface FileCsvParser<T> {
    List<T> parse(String path);
}
