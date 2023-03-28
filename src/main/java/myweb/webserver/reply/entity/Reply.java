package myweb.webserver.reply.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myweb.webserver.board.entity.Board;
import org.mapstruct.ap.internal.model.GeneratedType;

import javax.persistence.*;

@Entity
@Getter @Setter
@NoArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long replyId;
    @Column
    private String content;
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "member_id")
//    private String member;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;
}
