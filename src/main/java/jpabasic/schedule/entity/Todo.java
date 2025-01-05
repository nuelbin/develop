package jpabasic.schedule.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@Getter
@Entity
@Table(name = "todo")
@EntityListeners(AuditingEntityListener.class)
@NoArgsConstructor
@AllArgsConstructor
public class Todo {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todoId;

    //할 일 제목
    private String todoTitle;

    //할 일 내용
    private String todoContents;

    //생성 시간
    @CreatedDate
    @Column(updatable = false) // 생성 시간은 수정될 일이 없으므로 false
    private LocalDateTime createTodoAt;

    //수정 시간
    @LastModifiedDate
    private LocalDateTime updateTodoAt;

    //할 일 작성자 이름(참조값)
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @Builder
    public Todo(User user, String todoTitle, String todoContents) {
        this.user = user;
        this.todoTitle = todoTitle;
        this.todoContents = todoContents;
    }
}

