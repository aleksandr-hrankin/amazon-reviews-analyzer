package ua.antibyte.analyzer.service.mapper;

import java.util.Set;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.dto.CommentDto;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.service.RoleService;

@Component
public class UserMapper {
    private final RoleService roleService;

    public UserMapper(RoleService roleService) {
        this.roleService = roleService;
    }

    public User map(CommentDto commentDto) {
        User user = new User();
        user.setExternalId(commentDto.getUserId());
        user.setProfileName(commentDto.getProfileName());
        user.setPassword("1111");
        user.setRoles(Set.of(roleService.findByName("USER")));
        return user;
    }
}
