package com.junprogrammer.restapi.advice.exception;

// 카카오 통신중 에러가 나면 발생되는 예외
public class CCommunicationException extends RuntimeException {
    public CCommunicationException(String msg, Throwable t) {
        super(msg, t);
    }

    public CCommunicationException(String msg) {
        super(msg);
    }

    public CCommunicationException() {
        super();
    }
}