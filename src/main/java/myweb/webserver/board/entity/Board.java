package myweb.webserver.board.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myweb.webserver.reply.entity.Reply;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String member;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "board", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    private List<Reply> replies = new ArrayList<>();


    //아래 전부 @PostConstruct 쓸려고 추가함.
    @Builder
    public Board(String title, String content, String member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
