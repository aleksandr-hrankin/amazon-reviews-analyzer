package ua.antibyte.analyzer.service.mapper.dto;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;

@Component
public class UserResponseDtoMapper {
    public UserResponseDto map(User user) {
        return new UserResponseDto(user.getProfileName());
    }
}
