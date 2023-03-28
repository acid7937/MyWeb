package myweb.webserver.reply.service;

import lombok.RequiredArgsConstructor;
import myweb.webserver.board.entity.Board;
import myweb.webserver.board.service.FindBoardService;
import myweb.webserver.reply.dto.ReplyPatchDto;
import myweb.webserver.reply.dto.ReplyPostDto;
import myweb.webserver.reply.entity.Reply;
import myweb.webserver.reply.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReplyService {

    private final FindBoardService findBoardService;
    private final FindReplyService findReplyService;

    private final ReplyRepository replyRepository;

    public Long createReply(ReplyPostDto replyPostDto, Long boardId) {
        // 먼저 게시글을 찾기
        Board board = findBoardService.id(boardId);

        // 새로운 Reply 객체를 생성하고 필드 값을 설정.
        Reply reply = new Reply();
        reply.setContent(replyPostDto.getContent());
        reply.setBoard(board);

        // 댓글을 저장하고 반환된 객체의 ID를 반환.
        return replyRepository.save(reply).getReplyId();
    }


//    public Long createReply(ReplyPostDto replyPostDto, Long boardId) {
//        // 먼저 게시글을 찾기
//        Board board = findBoardService.id(boardId);
//
//        // 새로운 Reply 객체를 생성하고 필드 값을 설정.
//        Reply reply = new Reply();
//        reply.setContent(replyPostDto.getContent());
//        reply.setBoard(board);
//
//        // 댓글을 저장하고 반환된 객체의 ID를 반환.
//        return replyRepository.save(reply).getReplyId();
//    }


    public Long updateReply(ReplyPatchDto replyPatchDto, Long id) {
        Reply reply = findReplyService.id(id);
        reply.setContent(replyPatchDto.getContent());
        return replyRepository.save(reply).getReplyId();
    }

    public void deleteReply(Long id) {
        Reply reply = findReplyService.id(id);
        replyRepository.delete(reply);
    }
}
