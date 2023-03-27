package myweb.webserver.global;

import lombok.Data;

@Data
public class ResponseDto<T> {
//프론트에서 확인 편해서 사용
    private T data;
    private Integer code;

    public ResponseDto(T data, Integer code) {
        this.data = data;
        this.code = code;
    }
}

