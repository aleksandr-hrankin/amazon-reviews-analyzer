package ua.antibyte.analyzer.service.impl;

import java.util.List;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
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
    public List<UserResponseDto> findMostActive(int quantity) {
        return userRepository.findMostActive(PageRequest.of(0, quantity));
    }
}
