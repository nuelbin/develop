package jpabasic.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class APIResponseDto<T> {
    private int status; // 응답코드
    private String message; // 응답 메시지
    private T data; // 실제 응답 데이터

    // success(성공 시 반환)
    public static <T> APIResponseDto<T> success(int status, String message, T data) {
        return APIResponseDto.<T>builder()
                .status(status)
                .message(message)
                .data(data)
                .build();
    }

    // error(실패 시 반환)
    public static <T> APIResponseDto<T> error(int status, String errorMessage) {
        return APIResponseDto.<T>builder()
                .status(status)
                .message(errorMessage)
                .build();
    }
}