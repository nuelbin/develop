package jpabasic.schedule.dto.todo;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@RequiredArgsConstructor
public class CreateTodoResponseDto {

    private final String todoTitle;
    private final String todoContents;
    private final String userName;
    private final LocalDateTime createTodoAt;

}
