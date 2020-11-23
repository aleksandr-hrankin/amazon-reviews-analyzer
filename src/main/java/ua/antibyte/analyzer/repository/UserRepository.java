package ua.antibyte.analyzer.repository;

import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query("select "
            + "new ua.antibyte.analyzer.entity.dto.response.UserResponseDto(c.user.profileName) "
            + "from Comment c "
            + "group by c.user.profileName "
            + "order by count(c) desc ")
    List<UserResponseDto> findMostActive(Pageable pageable);
}
