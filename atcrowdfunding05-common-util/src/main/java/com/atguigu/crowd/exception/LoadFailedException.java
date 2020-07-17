package com.atguigu.crowd.exception;

public class LoadFailedException extends RuntimeException {

    public static final long serialVersionUID=1L;

    public LoadFailedException() {
    }

    public LoadFailedException(String message) {
        super(message);
    }

    public LoadFailedException(String message, Throwable cause) {
        super(message, cause);
    }

    public LoadFailedException(Throwable cause) {
        super(cause);
    }

    public LoadFailedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
