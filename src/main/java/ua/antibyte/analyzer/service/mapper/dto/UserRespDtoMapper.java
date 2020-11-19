package ua.antibyte.analyzer.service.mapper.dto;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserRespDto;

@Component
public class UserRespDtoMapper {
    public UserRespDto map(User user) {
        return new UserRespDto(user.getProfileName());
    }
}
