package myweb.webserver.reply.controller;

import lombok.RequiredArgsConstructor;
import myweb.webserver.board.dto.BoardPostDto;
import myweb.webserver.board.dto.BoardResponseDto;
import myweb.webserver.global.ResponseDto;
import myweb.webserver.reply.dto.ReplyPatchDto;
import myweb.webserver.reply.dto.ReplyPostDto;
import myweb.webserver.reply.entity.Reply;
import myweb.webserver.reply.service.ReplyService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("/replies")
@RequiredArgsConstructor
public class ReplyController {
    private final ReplyService replyService;


//    @PostMapping("{board-id}")
//    public ResponseEntity postReply(@RequestBody @Validated ReplyPostDto replyPostDto,
//                                    @PathVariable("board-id")@Positive Long boardId) {
//        Long createdReplyId = replyService.createReply(replyPostDto, boardId);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new ResponseDto(new ReplyPostDto(createdReplyId, replyPostDto.getContent()), 200));
//    }

//    @PostMapping("{board-id}")
//    public ResponseEntity postReply(@RequestBody @Validated ReplyPostDto replyPostDto,
//                                    @PathVariable("board-id") @Positive Long boardId) {
//        Long createReply = replyService.createReply(replyPostDto, boardId);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new ResponseDto(createReply, 200));
//    }

//    @PostMapping("{board-id}")
//    public ResponseEntity<ReplyPostDto> postReply(@RequestBody @Validated ReplyPostDto replyPostDto,
//                                    @PathVariable("board-id") @Positive Long boardId) {
//        Long createReply = replyService.createReply(replyPostDto, boardId);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(new ResponseDto(createReply, 200));
//    }
//
//    @PostMapping("{board-id}")
//    public ResponseEntity<ReplyPostDto> postReply(@RequestBody @Validated ReplyPostDto replyPostDto,
//                                                  @PathVariable("board-id") @Positive Long boardId) {
//        Long createdReplyId = replyService.createReply(replyPostDto, boardId);
//        ReplyPostDto createdReply = new ReplyPostDto(createdReplyId, replyPostDto.getContent());
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(createdReply);
//    }

//    @PostMapping("{board-id}")
//    public ResponseEntity<ReplyPostDto> postReply(@RequestBody @Validated ReplyPostDto replyPostDto,
//                                                  @PathVariable("board-id") @Positive Long boardId) {
//        Long createdReplyId = replyService.createReply(replyPostDto, boardId);
//        replyPostDto.setReplyId(createdReplyId);
//
//        return ResponseEntity.status(HttpStatus.CREATED)
//                .body(replyPostDto);
//    }

    @PostMapping("{board-id}")
    public ResponseEntity<ReplyPostDto> postReply(@RequestBody @Validated ReplyPostDto replyPostDto,
                                                  @PathVariable("board-id") @Positive Long boardId) {
        replyPostDto.setReplyId(replyService.createReply(replyPostDto, boardId));

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(replyPostDto);
    }

    @PatchMapping("{reply-id}")
    public ResponseEntity postReply(@RequestBody @Validated ReplyPatchDto replyPatchDto,
                                    @PathVariable("reply-id") @Positive Long replyId) {
        replyService.updateReply(replyPatchDto, replyId);
        return ResponseEntity.status(HttpStatus.OK).body(new ResponseDto(replyId, 200));
    }
    @DeleteMapping("{reply-id}")
    public ResponseEntity deleteReply(@PathVariable("reply-id") @Positive Long replyId) {
        replyService.deleteReply(replyId);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
