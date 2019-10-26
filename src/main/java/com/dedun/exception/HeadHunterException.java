package com.dedun.exception;

public class HeadHunterException extends Throwable {

    private HeadHunterErrorCode headHunterErrorCode;

    public HeadHunterException(HeadHunterErrorCode headHunterErrorCode) {
        this.headHunterErrorCode = headHunterErrorCode;
    }

    public HeadHunterErrorCode getHeadHunterErrorCode() {
        return headHunterErrorCode;
    }

    public void setHeadHunterErrorCode(HeadHunterErrorCode headHunterErrorCode) {
        this.headHunterErrorCode = headHunterErrorCode;
    }
}
