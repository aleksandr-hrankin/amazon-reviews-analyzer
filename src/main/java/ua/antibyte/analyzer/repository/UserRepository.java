package ua.antibyte.analyzer.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.antibyte.analyzer.entity.User;
import ua.antibyte.analyzer.entity.dto.response.UserRespDto;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    @Query(value = "select "
            + "new ua.antibyte.analyzer.entity.dto.response.UserRespDto(c.user.profileName) "
            + "from Comment c "
            + "group by c.user.profileName "
            + "order by count(c) desc ",
            countQuery = "select count(c.user.profileName) "
                    + "from Comment c group by c.user.profileName "
                    + "order by count(c) desc ")
    Page<UserRespDto> findMostActive(Pageable pageable);
}
