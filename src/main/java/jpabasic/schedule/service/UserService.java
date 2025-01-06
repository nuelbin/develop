package jpabasic.schedule.service;

import jpabasic.schedule.common.PasswordAuthException;
import jpabasic.schedule.dto.user.FindUserResponseDto;
import jpabasic.schedule.dto.user.SecessionRequestDto;
import jpabasic.schedule.dto.user.SignUpRequestDto;
import jpabasic.schedule.dto.user.UpdateUserInfoRequestDto;
import jpabasic.schedule.entity.User;
import jpabasic.schedule.exception.ResponseCode;
import jpabasic.schedule.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor

public class UserService {

    private final UserRepository userRepository;

    // 회원 가입
    public void signupUser(SignUpRequestDto signUpRequestDto) {

        // 회원 생성
        User user = new User(signUpRequestDto.getEmail(), signUpRequestDto.getPassword(), signUpRequestDto.getUserName());
        userRepository.save(user);
    }

    //회원 이름 유저 아이디로 찾기
    public FindUserResponseDto findUserByUserId(Long userId) {
        User findUser = userRepository.findUserByUserIdOrElseThrow(userId);
        return FindUserResponseDto.GetUserDetailsDto(findUser);
    }

    //회원 정보 수정
    public void updateUserInfo(Long userId, UpdateUserInfoRequestDto updateUserInfoDto) {

        User findUser = userRepository.findUserByUserIdOrElseThrow(userId);

        //회원 이름 null 값 확인 후 수정
        Optional.ofNullable(updateUserInfoDto.getUserName()).ifPresent(findUser::setUserName);

        userRepository.save(findUser);
    }

    // 회원 탈퇴
    public void secessionUser(Long userId, SecessionRequestDto secessionRequestDto) {

        User user = userRepository.findUserByUserIdOrElseThrow(userId);

        // 회원 탈퇴 요청의 비밀번호가 유저 비밀번호와 일치 하는지 확인
        if (!secessionRequestDto.getUserPassword().equals(user.getUserPassword())) {
            throw new PasswordAuthException(ResponseCode.PASSWORD_MISMATCH);
        }

        //유저 삭제
        userRepository.delete(user);
    }


}
