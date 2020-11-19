package ua.antibyte.analyzer.service.mapper.entity;

import java.util.Set;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.request.CommentReqDto;
import ua.antibyte.analyzer.service.RoleService;

@Component
public class UserMapper {
    private static final String USER_PASSWORD = "1111";
    private static final String USER_ROLE = "USER";
    private final RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User map(CommentReqDto commentReqDto) {
        User user = new User();
        user.setExternalId(commentReqDto.getUserId());
        user.setProfileName(commentReqDto.getProfileName());
        user.setPassword(USER_PASSWORD);
        user.setRoles(Set.of(roleService.findByName(USER_ROLE)));
        return user;
    }
}
