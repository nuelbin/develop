package jpabasic.schedule.dto.user;

import jpabasic.schedule.entity.User;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

@Getter
@RequiredArgsConstructor
public class FindUserResponseDto {

    private final String userName;
    private final LocalDateTime createTodoAt;

    public FindUserResponseDto(User user) {
        this.userName = user.getUserName();
        this.createTodoAt = user.getCreateUserAt();
    }

    public static FindUserResponseDto GetUserDetailsDto(User user) {
        return new FindUserResponseDto(user);
    }
}
