package ua.antibyte.analyzer.service.impl;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.dto.response.UserRespDto;
import ua.antibyte.analyzer.repository.UserRepository;
import ua.antibyte.analyzer.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Page<UserRespDto> findMostActive(int size) {
        return userRepository.findMostActive(PageRequest.of(0, size));
    }
}
