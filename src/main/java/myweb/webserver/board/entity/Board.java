package myweb.webserver.board.entity;


import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Board {

    @Id
    @GeneratedValue
    private Long boardId;
    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String member;

    @Builder
    public Board(String title, String content, String member) {
        this.title = title;
        this.content = content;
        this.member = member;
    }
}
