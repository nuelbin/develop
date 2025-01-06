package jpabasic.schedule.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class MessageDto {
    private String information;

    public static MessageDto convertFrom(String information) {
        return new MessageDto(information);
    }
}