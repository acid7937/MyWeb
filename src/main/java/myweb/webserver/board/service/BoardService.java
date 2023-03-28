package myweb.webserver.board.service;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import myweb.webserver.board.dto.BoardPatchDto;
import myweb.webserver.board.dto.BoardPostDto;
import myweb.webserver.board.dto.BoardResponseDto;
import myweb.webserver.board.entity.Board;
import myweb.webserver.board.repository.BoardRepository;
import myweb.webserver.reply.dto.ReplyResponseDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {


    private final BoardRepository boardRepository;
    private final FindBoardService findBoardService;

    @PostConstruct
    public void init() {
        Board board = Board.builder()
                .title("제목")
                .content("내용")
                .member("1").build();
        boardRepository.save(board);
    }
    public Long createBoard (BoardPostDto boardPostDto) {
        Board board = new Board();
        board.setContent(boardPostDto.getContent());
        board.setMember(boardPostDto.getMember());
        board.setTitle(boardPostDto.getTitle());


        return boardRepository.save(board).getBoardId();
    }

    public Long updateBoard(BoardPatchDto boardPatchDto,Long id) {
        //findBoardService 에서 boardId 값을 찾아온다.
        Board board = findBoardService.id(id);
        board.setTitle(boardPatchDto.getTitle());
        board.setContent(boardPatchDto.getContent());

        return boardRepository.save(board).getBoardId();
    }

    public BoardResponseDto findByBoardId(Long id) {
        Board board = findBoardService.id(id);
        BoardResponseDto boardResponseDto = new BoardResponseDto();

        boardResponseDto.setBoardId(board.getBoardId());
        boardResponseDto.setContent(board.getContent());
        boardResponseDto.setTitle(board.getTitle());
        boardResponseDto.setMember(board.getMember());

        // 댓글 목록을 가져와서 ReplyResponseDto로 변환
        List<ReplyResponseDto> replyResponseDtos = board.getReplies().stream()
                .map(reply -> new ReplyResponseDto(reply.getReplyId(), reply.getContent()))
                .collect(Collectors.toList());

        // BoardResponseDto에 댓글 목록을 설정
        boardResponseDto.setReplies(replyResponseDtos);

        return boardResponseDto;
    }

    public void deleteBoard(Long id) {
        Board board = findBoardService.id(id);
        boardRepository.deleteById(id);

    }
}
