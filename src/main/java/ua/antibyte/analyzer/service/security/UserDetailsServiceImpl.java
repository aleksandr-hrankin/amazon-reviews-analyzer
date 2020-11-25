package ua.antibyte.analyzer.service.security;

import java.util.Optional;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.service.UserService;

@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    private final UserService userService;

    public UserDetailsServiceImpl(UserService userService) {
        this.userService = userService;
    }

    @Override
    public UserDetails loadUserByUsername(String profileName) throws UsernameNotFoundException {
        Optional<User> userOptional = userService.findByProfileName(profileName);
        if (userOptional.isPresent()) {
            User user = userOptional.get();
            org.springframework.security.core.userdetails.User.UserBuilder userBuilder
                    = org.springframework.security.core.userdetails
                    .User.withUsername(user.getProfileName());
            userBuilder.password(user.getPassword());
            String[] roles = user.getRoles().stream()
                    .map(role -> role.getRoleName().toString())
                    .toArray(String[]::new);
            userBuilder.roles(roles);
            return userBuilder.build();
        } else {
            throw new UsernameNotFoundException("User with " + profileName
                    + " profile name not found");
        }
    }
}
