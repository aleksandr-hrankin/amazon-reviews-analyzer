package ua.antibyte.analyzer.service.mapper.entity;

import java.util.Set;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.request.CommentRequestDto;
import ua.antibyte.analyzer.service.RoleService;

@Component
public class FromCommentToUserMapper {
    private static final String USER_PASSWORD = "1111";
    private static final String USER_ROLE = "USER";
    private final RoleService roleService;

    public FromCommentToUserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User map(CommentRequestDto commentRequestDto) {
        User user = new User();
        user.setExternalId(commentRequestDto.getUserId());
        user.setProfileName(commentRequestDto.getProfileName());
        user.setPassword(USER_PASSWORD);
        user.setRoles(Set.of(roleService.findByName(USER_ROLE)));
        return user;
    }
}
