package jpabasic.schedule.controller;

import jpabasic.schedule.dto.APIResponseDto;
import jpabasic.schedule.dto.todo.*;
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
    public ResponseEntity<APIResponseDto<CreateTodoResponseDto>> createTodo(
            @RequestBody CreateTodoRequestDto todoRequestDto) {
        CreateTodoResponseDto responseDto = todoService.createTodo(todoRequestDto);

        return ResponseEntity.ok(
                APIResponseDto.success(200, "일정을 정상적으로 생성하였습니다.", responseDto));
    }

    // 일정 단건 조회 API
    @GetMapping("/{todoId}")
    public ResponseEntity<APIResponseDto<FindTodoByIdResponseDto>> findTodoByTodoId(
            @PathVariable(name = "todoId") Long todoId) {

        return ResponseEntity.ok(
                APIResponseDto.success(200, "할 일 단건 조회 성공", todoService.findPostByPostId(todoId)));
    }

    // 일정 수정 API
    @PatchMapping("/{todoId}")
    public ResponseEntity<APIResponseDto<UpdateTodoResponseDto>> updatedTodo(
            @PathVariable(name = "todoId") Long todoId,
            @RequestBody UpdateTodoRequestDto updateTodoRequest) {

        UpdateTodoResponseDto updateTodoResponse = todoService.updatePost(todoId, updateTodoRequest);

        return ResponseEntity.ok(
                APIResponseDto.success(200, "일정 수정 성공", updateTodoResponse));
    }

    // 일정 삭제 API
    @DeleteMapping("/{todoId}")
    public ResponseEntity<APIResponseDto<Void>> deletedTodo(
            @PathVariable(name = "todoId") Long TodoId) {

        todoService.deleteTodo(TodoId);

        return ResponseEntity.ok(
                APIResponseDto.success(200, "일정 삭제 성공", null));
    }
}
