package myweb.webserver.board.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardPostDto {

    private Long boardId;
    private String title;
    private String content;
    private String member;
}
