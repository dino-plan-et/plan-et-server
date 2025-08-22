package com.jiwon.planet.error;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;

@Getter
@RequiredArgsConstructor
public enum ErrorCode {

    DUPLICATE_ACCOUNT_ID(HttpStatus.CONFLICT, "이미 사용중인 아이디입니다."),
    NOT_CONFIRM_PASSWORD(HttpStatus.BAD_REQUEST, "비밀번호가 일치하지 않습니다.");

    private final HttpStatus status;
    private final String message;
}
