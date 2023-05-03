package com.woopaca.knoo.exception.post;

import com.woopaca.knoo.exception.KnooError;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;

@AllArgsConstructor
public enum PostError implements KnooError {

    POST_CATEGORY_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 카테고리가 존재하지 않습니다.", "KN301"),
    POST_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 게시글이 존재하지 않습니다.", "KN302"),
    OUT_OF_PAGE(HttpStatus.BAD_REQUEST, "페이지 수를 초과하였습니다.", "KN303"),
    INVALID_POST_PAGE(HttpStatus.BAD_REQUEST, "유효하지 않은 페이지입니다.", "KN304");

    private final HttpStatus httpStatus;
    private final String message;
    private final String errorCode;

    @Override
    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }

    @Override
    public String getErrorCode() {
        return errorCode;
    }
}
