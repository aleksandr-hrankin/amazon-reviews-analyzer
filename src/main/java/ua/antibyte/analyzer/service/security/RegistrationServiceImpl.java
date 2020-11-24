package ua.antibyte.analyzer.service.security;

import java.util.Set;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.service.RoleService;
import ua.antibyte.analyzer.service.UserService;

@Service
public class RegistrationServiceImpl implements RegistrationService {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final RoleService roleService;

    public RegistrationServiceImpl(UserService userService,
                                   PasswordEncoder passwordEncoder,
                                   RoleService roleService) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
    }

    @Override
    public User register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRoles(Set.of(roleService.findByName("USER")));
        return userService.save(user);
    }
}
