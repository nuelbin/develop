package jpabasic.schedule.service;

import jpabasic.schedule.dto.todo.*;
import jpabasic.schedule.entity.Todo;
import jpabasic.schedule.entity.User;
import jpabasic.schedule.repository.TodoRepository;
import jpabasic.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TodoService {
    private final TodoRepository todoRepository;
    private final UserRepository userRepository;

    // 일정 생성
    public CreateTodoResponseDto createTodo(CreateTodoRequestDto todoRequestDto) {

        Todo todo = Todo.builder()
                .todoTitle(todoRequestDto.getTodoTitle())
                .todoContents(todoRequestDto.getTodoContents())
                .build();

        Todo saveTodo = todoRepository.save(todo);

        return CreateTodoResponseDto.builder()
                .todoTitle(saveTodo.getTodoTitle())
                .todoContents(saveTodo.getTodoContents())
                .createTodoAt(saveTodo.getCreateTodoAt())
                .build();
    }

    // 일정 아이디 값 조회
    public FindTodoByIdResponseDto findPostByPostId(Long todoId) {
        Todo findTodo = todoRepository.findTodoByTodoIdOrElseThrow(todoId);
        return FindTodoByIdResponseDto.GetPostDetailsDto(findTodo);
    }

    // 일정 수정
    public UpdateTodoResponseDto updatePost(
            Long postId, UpdateTodoRequestDto updateTodoRequest) {

        Todo todo = todoRepository.findTodoByTodoIdOrElseThrow(postId);
        todo.updateTodo(updateTodoRequest.getTodoTitle(), updateTodoRequest.getTodoContents());

        return UpdateTodoResponseDto.builder()
                .todoTitle(todo.getTodoTitle())
                .todoContents(todo.getTodoContents())
                .updateTodoAt(todo.getUpdateTodoAt())
                .build();
    }

    //일정 삭제
    public void deleteTodo(Long todoId) {
        Todo todo = todoRepository.findTodoByTodoIdOrElseThrow(todoId);
        todoRepository.deleteById(todoId);
    }
}
