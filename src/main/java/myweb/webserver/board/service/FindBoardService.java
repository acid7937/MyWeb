package myweb.webserver.board.service;

import lombok.RequiredArgsConstructor;
import myweb.webserver.board.entity.Board;
import myweb.webserver.board.exception.BusinessLogicException;
import myweb.webserver.board.exception.ExceptionCode;
import myweb.webserver.board.repository.BoardRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class FindBoardService {
    private final BoardRepository boardRepository;

    public Board id(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new BusinessLogicException(ExceptionCode.BOARD_NOT_FOUND));

    }
}
