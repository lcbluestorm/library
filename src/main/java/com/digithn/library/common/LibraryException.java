package com.digithn.library.common;

public class LibraryException extends RuntimeException {

    private ErrorEnum errorEnum;

    public LibraryException(ErrorEnum errorEnum) {
        super(errorEnum.getMsg());
        this.errorEnum = errorEnum;

    }

    public static void fail(ErrorEnum errorEnum) {
        throw new LibraryException(errorEnum);
    }

    public ErrorEnum getErrorEnum() {
        return errorEnum;
    }
}
