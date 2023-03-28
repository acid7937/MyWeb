package myweb.webserver.reply.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import myweb.webserver.reply.entity.Reply;

@Getter@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyResponseDto  {

    private Long replyId;
    private String content;
//    private String member;


//    public static ReplyResponseDto createByEntity(Reply entity) {
//        ReplyResponseDto replyResponseDto = new ReplyResponseDto();
//
//        replyResponseDto.setReplyId(entity.getReplyId());
//        replyResponseDto.setContent(entity.getContent());
//
//        return replyResponseDto;
//    }
}
