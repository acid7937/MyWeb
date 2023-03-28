package myweb.webserver.board.dto;

import lombok.Getter;
import lombok.Setter;
import myweb.webserver.reply.dto.ReplyResponseDto;

import java.util.List;

@Getter
@Setter
public class BoardResponseDto {

    private Long boardId;
    private String title;
    private String content;
    private String member;
    private List<ReplyResponseDto> replies;



}
