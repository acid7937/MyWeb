package myweb.webserver.reply.service;

import lombok.RequiredArgsConstructor;
import myweb.webserver.board.exception.BusinessLogicException;
import myweb.webserver.board.exception.ExceptionCode;
import myweb.webserver.reply.entity.Reply;
import myweb.webserver.reply.repository.ReplyRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindReplyService {
    private final ReplyRepository replyRepository;

    public Reply id(Long id) {
        return replyRepository.findById(id)
                .orElseThrow(()->new BusinessLogicException(ExceptionCode.REPLY_NOT_FOUND));
    }
}
