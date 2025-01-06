package jpabasic.schedule.common;

import jpabasic.schedule.exception.ResponseCode;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PasswordAuthException extends RuntimeException {

    private int status;
    public PasswordAuthException(ResponseCode responseCode) {
            super(responseCode.getMessage());
            this.status = responseCode.getStatus().value();
    }
}

