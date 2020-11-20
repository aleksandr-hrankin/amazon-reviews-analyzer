package ua.antibyte.analyzer.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import ua.antibyte.analyzer.entity.dto.response.UserRespDto;

public interface UserService {
    Page<UserRespDto> findMostActive(Pageable pageable);
}
