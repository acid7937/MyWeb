package myweb.webserver.board.controller;

import lombok.RequiredArgsConstructor;
import myweb.webserver.board.dto.BoardPatchDto;
import myweb.webserver.board.dto.BoardPostDto;
import myweb.webserver.board.dto.BoardResponseDto;
import myweb.webserver.board.service.BoardService;
import myweb.webserver.global.ResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Positive;

@Validated
@RestController
@RequestMapping("boards")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping
    public ResponseEntity postBoard(@RequestBody @Validated BoardPostDto boardPostDto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(boardService.createBoard(boardPostDto), 200));
    }

    @PatchMapping("{board-id}")
    public ResponseEntity patchBoard(@PathVariable("board-id")@Positive Long id,
                                     @RequestBody @Validated BoardPatchDto boardPatchDto) {
        boardService.updateBoard(boardPatchDto, id);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(id, 200));
    }
//    @GetMapping("{board-id}")
//    public ResponseEntity getBoard(@PathVariable("board-id") @Positive Long id) {
//        return ResponseEntity.status(HttpStatus.OK)
//                .body(new ResponseDto(boardService.findByBoardId(id), 200));
//    }

    @GetMapping("{board-id}")
    public ResponseEntity<BoardResponseDto> getBoard(@PathVariable("board-id") @Positive Long id) {
        BoardResponseDto boardResponseDto = boardService.findByBoardId(id);
        return ResponseEntity.status(HttpStatus.OK).body(boardResponseDto);
    }

    @DeleteMapping("{board-id}")
    public ResponseEntity deleteBoard(@PathVariable("board-id") @Positive Long id) {
        boardService.deleteBoard(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
