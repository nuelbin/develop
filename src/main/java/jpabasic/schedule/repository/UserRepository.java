package jpabasic.schedule.repository;

import jpabasic.schedule.common.ValidateException;
import jpabasic.schedule.entity.User;
import jpabasic.schedule.exception.ResponseCode;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findUserByUserId(Long id);

    default User findUserByUserIdOrElseThrow(Long id) {
        return findUserByUserId(id)
                .orElseThrow(() -> new ValidateException(ResponseCode.USER_NOT_FOUND));
    }
}
