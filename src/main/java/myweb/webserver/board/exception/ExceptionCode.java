package myweb.webserver.board.exception;

import lombok.Getter;

public enum ExceptionCode {


    MEMBER_NOT_FOUND(400, "member not found"),
    BOARD_NOT_FOUND(400, "board not found"),
    REPLY_NOT_FOUND(400, "reply not found");
    @Getter
    private int status;
    @Getter
    private String message;

    ExceptionCode(int status, String message) {
        this.status = status;
        this.message = message;
    }
}
