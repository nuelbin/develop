package jpabasic.schedule.common;

import jpabasic.schedule.exception.ResponseCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public class ValidateException extends RuntimeException {

    private final HttpStatus httpStatus;
    private final int statusValue;

    public ValidateException(ResponseCode responseCode) {
        super(responseCode.getMessage());
        this.httpStatus = responseCode.getStatus();
        this.statusValue = responseCode.getStatus().value();
    }
}
