package myweb.webserver.board.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardResponseDto {

    private Long boardId;
    private String title;
    private String content;
    private String member;
}
