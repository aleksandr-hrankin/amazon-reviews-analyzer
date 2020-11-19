package ua.antibyte.analyzer.controller;

import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.response.UserRespDto;
import ua.antibyte.analyzer.service.UserService;

@RestController
@RequestMapping("users")
public class UserController {
    private static final String PAGE_SIZE = "1000";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("most-active")
    public Page<UserRespDto> getMostActive(@RequestParam(defaultValue = PAGE_SIZE) int size) {
        return userService.findMostActive(size);
    }
}
