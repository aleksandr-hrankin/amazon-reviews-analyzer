package ua.antibyte.analyzer.service.impl;

import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;
import ua.antibyte.analyzer.repository.UserRepository;
import ua.antibyte.analyzer.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<UserResponseDto> findMostActive(int quantity) {
        return userRepository.findMostActive(PageRequest.of(0, quantity));
    }

    @Override
    public Optional<User> findByProfileName(String profileName) {
        return userRepository.findByProfileName(profileName);
    }
}
