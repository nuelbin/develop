package jpabasic.schedule.dto.todo;

import jpabasic.schedule.entity.Todo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class FindTodoByIdResponseDto {

//    private final String userName;
    private final String todoTitle;
    private final String todoContents;
    private final LocalDateTime updateTodoAt;


    public FindTodoByIdResponseDto(Todo todo) {
//        this.userName = todo.getUser().getUserName();
        this.todoTitle = todo.getTodoTitle();
        this.todoContents = todo.getTodoContents();
        this.updateTodoAt = todo.getUpdateTodoAt();
    }

    public static FindTodoByIdResponseDto GetPostDetailsDto(Todo todo) {
        return new FindTodoByIdResponseDto(todo);
    }
}
