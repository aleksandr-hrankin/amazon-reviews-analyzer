package ua.antibyte.analyzer.service;

import java.util.List;
import java.util.Optional;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;

public interface UserService {
    User save(User user);

    List<UserResponseDto> findMostActive(int quantity);

    Optional<User> findByProfileName(String profileName);
}
