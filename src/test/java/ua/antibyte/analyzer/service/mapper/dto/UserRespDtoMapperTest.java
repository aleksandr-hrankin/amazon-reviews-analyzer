package ua.antibyte.analyzer.service.mapper.dto;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserRespDto;

class UserRespDtoMapperTest {
    private static final UserRespDto EXPECTED_USER_RESP_DTO = new UserRespDto("dll pa");
    private static final User CORRECT_USER = new User("dll pa");
    private static final User INCORRECT_PROFILE_NAME_USER = new User("incorrect");
    private static final User EMPTY_PROFILE_NAME_USER = new User("");
    private static UserRespDtoMapper userRespDtoMapper;

    @BeforeAll
    public static void before() {
        userRespDtoMapper = new UserRespDtoMapper();
    }

    @Test
    public void mappingCorrectTest() {
        UserRespDto actualUserRespDto = userRespDtoMapper.map(CORRECT_USER);
        assertEquals(EXPECTED_USER_RESP_DTO, actualUserRespDto);
    }

    @Test
    public void mappingIncorrectTest() {
        UserRespDto actualUserRespDto = userRespDtoMapper.map(INCORRECT_PROFILE_NAME_USER);
        assertNotEquals(EXPECTED_USER_RESP_DTO, actualUserRespDto);
    }

    @Test
    public void mappingEmptyProfileNameTest() {
        UserRespDto actualUserRespDto = userRespDtoMapper.map(EMPTY_PROFILE_NAME_USER);
        assertNotEquals(EXPECTED_USER_RESP_DTO, actualUserRespDto);
    }
}
