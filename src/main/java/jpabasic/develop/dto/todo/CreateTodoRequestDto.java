package jpabasic.develop.dto.todo;

import lombok.Getter;

@Getter
public class CreateTodoRequestDto {

    private String todoTitle;
    private String todoContents;

}
