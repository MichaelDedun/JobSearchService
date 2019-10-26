package com.dedun.exception;

public enum  HeadHunterErrorCode {

    WORKER_EXIST("Worker already in data base"),
    WORKER_NOT_EXIST("Worker not exist"),
    SUMMARY_NOT_EXIST("Summary not exist"),
    WORKER_EXIST_SUMMARY("Summary already exist in this worker");

    private String errorCode;

    HeadHunterErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
