package com.dedun.exception;

public enum JobSearchErrorCode {

    WORKER_EXIST("Worker already in data base"),
    EMPLOYER_EXIST("Employer already in data base"),
    WORKER_NOT_EXIST("Worker not exist"),
    SUMMARY_NOT_EXIST("Summary not exist"),
    CANT_CREATE_SUMMARY("Cant create summary");

    private String errorCode;

    JobSearchErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }
}
