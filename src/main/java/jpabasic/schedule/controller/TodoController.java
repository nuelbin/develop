package jpabasic.schedule.controller;

import jpabasic.schedule.dto.ApiResponse;
import jpabasic.schedule.dto.todo.CreateTodoRequestDto;
import jpabasic.schedule.dto.todo.CreateTodoResponseDto;
import jpabasic.schedule.dto.todo.FindTodoByIdResponseDto;
import jpabasic.schedule.service.TodoService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/todos")
public class TodoController {

    private final TodoService todoService;

    // 일정 생성 API
    @PostMapping
    public ResponseEntity<ApiResponse<CreateTodoResponseDto>> createTodo(
            @RequestBody CreateTodoRequestDto todoRequestDto) {
        CreateTodoResponseDto responseDto = todoService.createTodo(todoRequestDto);

        return ResponseEntity.ok(
                ApiResponse.success(200, "일정을 정상적으로 생성하였습니다.", responseDto));
    }

    // 일정 단건 조회 API
    @GetMapping("/{todoId}")
    public ResponseEntity<ApiResponse<FindTodoByIdResponseDto>> findTodoByTodoId(
            @PathVariable(name = "todoId") Long todoId) {

        return ResponseEntity.ok(
                ApiResponse.success(200, "할 일 단건 조회 성공", todoService.findPostByPostId(todoId)));
    }


}
