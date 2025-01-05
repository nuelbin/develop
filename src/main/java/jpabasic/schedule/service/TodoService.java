package jpabasic.schedule.service;

import jpabasic.schedule.dto.todo.CreateTodoRequestDto;
import jpabasic.schedule.dto.todo.CreateTodoResponseDto;
import jpabasic.schedule.dto.todo.FindTodoByIdResponseDto;
import jpabasic.schedule.entity.Todo;
import jpabasic.schedule.repository.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;

    //할 일 생성
    public CreateTodoResponseDto createTodo(CreateTodoRequestDto todoRequestDto) {
        Todo todo = Todo.builder()
                .todoTitle(todoRequestDto.getTodoTitle())
                .todoContents(todoRequestDto.getTodoContents())
                .build();
        Todo saveTodo = todoRepository.save(todo);
        return new CreateTodoResponseDto(
                saveTodo.getTodoTitle(),
                saveTodo.getTodoContents(),
                saveTodo.getUpdateTodoAt()
        );
    }

    //할 일 아이디 값 조회
    public FindTodoByIdResponseDto findPostByPostId(Long todoId) {
        Todo findTodo = todoRepository.findTodoByTodoIdOrElseThrow(todoId);
        return FindTodoByIdResponseDto.GetPostDetailsDto(findTodo);
    }
}
