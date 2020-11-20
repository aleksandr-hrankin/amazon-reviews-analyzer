package ua.antibyte.analyzer.service;

import java.util.List;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;

public interface UserService {
    List<UserResponseDto> findMostActive(int quantity);
}
