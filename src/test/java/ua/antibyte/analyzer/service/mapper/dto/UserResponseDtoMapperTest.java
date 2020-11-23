package ua.antibyte.analyzer.service.mapper.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;

class UserResponseDtoMapperTest {
    private static final UserResponseDto EXPECTED_USER_RESP_DTO = new UserResponseDto("dll pa");
    private static final User CORRECT_USER = new User("dll pa");
    private static final User INCORRECT_PROFILE_NAME_USER = new User("incorrect");
    private static final User EMPTY_PROFILE_NAME_USER = new User("");
    private static UserResponseDtoMapper userResponseDtoMapper;

    @BeforeAll
    public static void before() {
        userResponseDtoMapper = new UserResponseDtoMapper();
    }

    @Test
    public void mappingCorrectTest() {
        UserResponseDto actualUserResponseDto = userResponseDtoMapper.map(CORRECT_USER);
        assertEquals(EXPECTED_USER_RESP_DTO, actualUserResponseDto);
    }

    @Test
    public void mappingIncorrectTest() {
        UserResponseDto actualUserResponseDto
                = userResponseDtoMapper.map(INCORRECT_PROFILE_NAME_USER);
        assertNotEquals(EXPECTED_USER_RESP_DTO, actualUserResponseDto);
    }

    @Test
    public void mappingEmptyProfileNameTest() {
        UserResponseDto actualUserResponseDto = userResponseDtoMapper.map(EMPTY_PROFILE_NAME_USER);
        assertNotEquals(EXPECTED_USER_RESP_DTO, actualUserResponseDto);
    }
}
