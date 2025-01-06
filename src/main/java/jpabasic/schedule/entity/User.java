package jpabasic.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "user")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    private String email;

    @Setter
    private String userName;

    @Setter
    private String userPassword;

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createUserAt;//아마도 유저 생성 시간을 만들라고 한듯. 아닐 시 과제 제출 후 수정

    public User(String email, String userPassword, String userName) {
        this.email = email;
        this.userPassword = userPassword;
        this.userName = userName;
    }
}
