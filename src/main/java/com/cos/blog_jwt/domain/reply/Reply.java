package com.cos.blog_jwt.domain.reply;

import com.cos.blog_jwt.domain.board.Board;
import com.cos.blog_jwt.domain.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String content;

    @JoinColumn(nullable = false, name = "userId")
    @ManyToOne
    private User user;

    @JoinColumn(nullable = false, name = "boardId")
    @ManyToOne
    private Board board;

    @CreationTimestamp
    private LocalDateTime created;

    @UpdateTimestamp
    private LocalDateTime updated;

}