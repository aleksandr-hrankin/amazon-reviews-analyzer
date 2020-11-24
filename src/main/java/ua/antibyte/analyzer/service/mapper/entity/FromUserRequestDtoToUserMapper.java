package ua.antibyte.analyzer.service.mapper.entity;

import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.request.UserRequestDto;

@Component
public class FromUserRequestDtoToUserMapper {
    public User map(UserRequestDto userRequestDto) {
        User user = new User();
        user.setProfileName(userRequestDto.getProfileName());
        user.setPassword(userRequestDto.getPassword());
        return user;
    }
}
