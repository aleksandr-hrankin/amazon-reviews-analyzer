package ua.antibyte.analyzer.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.request.UserRequestDto;
import ua.antibyte.analyzer.service.mapper.entity.FromUserRequestDtoToUserMapper;
import ua.antibyte.analyzer.service.security.RegistrationService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
    private final RegistrationService registrationService;
    private final FromUserRequestDtoToUserMapper userMapper;

    public RegistrationController(RegistrationService registrationService,
                                  FromUserRequestDtoToUserMapper userMapper) {
        this.registrationService = registrationService;
        this.userMapper = userMapper;
    }

    @PostMapping
    @ApiOperation("New user registration")
    public void register(
            @ApiParam("The dto object has two string fields profileName and password")
            @RequestBody UserRequestDto userRequestDto) {
        registrationService.register(userMapper.map(userRequestDto));
    }
}
