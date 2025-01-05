package jpabasic.schedule.repository;

import jpabasic.schedule.entity.Todo;
import jpabasic.schedule.exception.ResponseCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.server.ResponseStatusException;
import java.util.Optional;

public interface TodoRepository extends JpaRepository<Todo, Long> {

    Optional<Todo> findTodoByTodoId(Long postId);

    default Todo findTodoByTodoIdOrElseThrow(Long postId) {
        return findTodoByTodoId(postId)
                .orElseThrow(() -> new ResponseStatusException(
                        ResponseCode.TODO_NOT_FOUND.getStatus(), ResponseCode.TODO_NOT_FOUND.getMessage()));
    }
}
