package ua.antibyte.analyzer.service.mapper;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Set;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ua.antibyte.analyzer.dto.CommentDto;
import ua.antibyte.analyzer.entity.Role;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.service.RoleService;

class UserMapperTest {
    private static final CommentDto FULL_COMMENT_DTO = CommentDto.builder()
            .id(1L)
            .productId("B00813GRG4")
            .userId("A1D87F6ZCVE5NK")
            .profileName("dll pa")
            .helpfulnessNumerator(0)
            .helpfulnessDenominator(0)
            .score(1)
            .time(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                    ZoneId.systemDefault()))
            .summary("Not as Advertised")
            .text("Product arrived labeled as Jumbo Salted Peanuts...the "
                    + "peanuts were actually small sized unsalted. Not sure if "
                    + "this was an error or if the vendor intended to represent "
                    + "the product as 'Jumbo'.")
            .build();
    private static final CommentDto COMMENT_DTO_WITHOUT_USER_FIELDS = CommentDto.builder()
            .id(1L)
            .productId("B00813GRG4")
            .helpfulnessNumerator(0)
            .helpfulnessDenominator(0)
            .score(1)
            .time(LocalDateTime.ofInstant(Instant.ofEpochSecond(1346976000),
                    ZoneId.systemDefault()))
            .summary("Not as Advertised")
            .text("Product arrived labeled as Jumbo Salted Peanuts...the "
                    + "peanuts were actually small sized unsalted. Not sure if "
                    + "this was an error or if the vendor intended to represent "
                    + "the product as 'Jumbo'.")
            .build();
    private static final CommentDto INCOMPLETE_COMMENT_DTO = CommentDto.builder()
            .userId("A1D87F6ZCVE5NK")
            .build();
    private static final CommentDto EMPTY_COMMENT_DTO = CommentDto.builder().build();
    private static UserMapper userMapper;

    @BeforeAll
    public static void beforeAll() {
        RoleService roleService = Mockito.mock(RoleService.class);
        when(roleService.findByName("USER")).thenReturn(Role.of("USER"));
        userMapper = new UserMapper(roleService);
    }

    @Test
    public void mappingFullCommentDtoTest() {
        User expectedUser = new User("1111", Set.of(Role.of("USER")));
        expectedUser.setExternalId("A1D87F6ZCVE5NK");
        expectedUser.setProfileName("dll pa");

        User actualUser = userMapper.map(FULL_COMMENT_DTO);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void mappingCommentDtoWithoutUserFieldsTest() {
        User expectedUser = new User("1111", Set.of(Role.of("USER")));
        User actualUser = userMapper.map(COMMENT_DTO_WITHOUT_USER_FIELDS);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void mappingIncompleteCommentDtoTest() {
        User expectedUser = new User("1111", Set.of(Role.of("USER")));
        expectedUser.setExternalId("A1D87F6ZCVE5NK");

        User actualUser = userMapper.map(INCOMPLETE_COMMENT_DTO);
        assertEquals(expectedUser, actualUser);
    }

    @Test
    public void mappingEmptyCommentDtoTest() {
        User expectedUser = new User("1111", Set.of(Role.of("USER")));
        User actualUser = userMapper.map(EMPTY_COMMENT_DTO);
        assertEquals(expectedUser, actualUser);
    }
}
