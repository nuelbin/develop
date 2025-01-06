package jpabasic.schedule.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ResponseCode {

    PASSWORD_MISMATCH(HttpStatus.UNAUTHORIZED, "비밀번호가 일치하지 않습니다. 다시 입력해주세요."),
    USER_NOT_FOUND(HttpStatus.NOT_FOUND, "회원을 찾을 수 없습니다."),
    EMAIL_NOT_FOUND(HttpStatus.NOT_FOUND, "입력하신 이메일을 찾을 수 없습니다. 다시 확인해주세요."),
    TODO_NOT_FOUND(HttpStatus.NOT_FOUND, "일정을 찾을 수 없습니다.");

    private final HttpStatus status;
    private final String message;

    ResponseCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

}
