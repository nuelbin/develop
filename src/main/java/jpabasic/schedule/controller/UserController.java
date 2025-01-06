package jpabasic.schedule.controller;

import jpabasic.schedule.dto.APIResponseDto;
import jpabasic.schedule.dto.MessageDto;
import jpabasic.schedule.dto.user.*;
import jpabasic.schedule.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    //회원 가입 (유저 생성)
    @PostMapping("/signup")
    public ResponseEntity<APIResponseDto<MessageDto>> signupUser(@RequestBody SignUpRequestDto signUpRequestDto) {

        userService.signupUser(signUpRequestDto);

        return ResponseEntity.ok(
                APIResponseDto.success(200, "회원가입 성공", MessageDto.convertFrom("회원가입에 성공하셨습니다.")));
    }

    //회원 조회(Id 값으로 유저 찾기)
    @GetMapping("/{userId}")
    public ResponseEntity<APIResponseDto<FindUserResponseDto>> findUserInfo(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                APIResponseDto.success(200,"유저 정보를 찾았습니다.", userService.findUserByUserId(userId)));

    }

    //회원 정보 수정
    @PatchMapping("/{userId}")
    public ResponseEntity<APIResponseDto<MessageDto>> updateUserInfo(
            @PathVariable Long userId,
            @Validated @RequestBody UpdateUserInfoRequestDto updateUserInfoDto) {

        userService.updateUserInfo(userId, updateUserInfoDto);
        return ResponseEntity.ok(
                APIResponseDto.success(200, "회원 이름 수정 성공", MessageDto.convertFrom("회원님의 이름이 수정 되었습니다.")));
    }

    //회원탈퇴
    @DeleteMapping("/{userId}")
    public ResponseEntity<APIResponseDto<MessageDto>> secessionUser(
            @PathVariable Long userId,
            @RequestBody SecessionRequestDto secessionRequestDto) {

        userService.secessionUser(userId, secessionRequestDto);

        //탈퇴 성공 시 OK 상태코드와 메세지 반환
        return ResponseEntity.ok(
                APIResponseDto.success(200, "회원탈퇴 성공", MessageDto.convertFrom("정상적으로 탈퇴 되었습니다. 감사합니다.")));
    }
}
