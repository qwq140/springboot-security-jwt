package com.cos.blog_jwt.domain.board;


import com.cos.blog_jwt.domain.reply.Reply;
import com.cos.blog_jwt.domain.user.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 100)
    private String title;

    @Lob
    private String content;

    // EAGER : 당장 가져와 -> 리턴할 때 조인을 하여 데이터를 같이 리턴
    // LAZY : 나중에 가져와 -> 먼저 Board를 select를 한 뒤 get을 호출하고 나면 User를 select를 한번 더 한다.
    @JoinColumn(nullable = false, name = "userId")
    @ManyToOne // EAGER 전략
    private User user;

    // 양방향 매핑 (board를 select를 할 때 reply도 가져와야 하므로) - 역방향 매핑
    @JsonIgnoreProperties({"board"}) // reply 안에 있는 board를 getter 때리지 마라.
    @OneToMany(mappedBy = "board", fetch = FetchType.LAZY, cascade = CascadeType.REMOVE) //mapppedBy 변수명(reply안에 있는 변수명) fk를 가지지 않는다.
    @OrderBy("id desc")
    private List<Reply> replies;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @CreationTimestamp
    private LocalDateTime created;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm", timezone = "Asia/Seoul")
    @UpdateTimestamp
    private LocalDateTime updated;

}
