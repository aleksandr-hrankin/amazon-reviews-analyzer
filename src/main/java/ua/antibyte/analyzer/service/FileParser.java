package ua.antibyte.analyzer.service;

import java.util.List;

public interface FileParser<T> {
    List<T> parse(String path);
}
