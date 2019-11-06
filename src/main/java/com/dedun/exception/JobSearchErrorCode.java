package com.dedun.exception;

public enum JobSearchErrorCode {

    WORKER_EXIST("Worker already in data base"),
    EMPLOYER_EXIST("Employer already in data base"),
    WORKER_NOT_EXIST("Worker not exist"),
    EMPLOYER_NOT_EXIST("Employer not exist"),
    SUMMARY_NOT_EXIST("Summary not exist"),
    SUMMARY_ALREADY_ACTIVE("Summary already active"),
    VACANCY_ALREADY_ACTIVE("Vacancy already active"),
    VACANCY_NOT_EXIST("Vacancy not exist"),
    CANT_CREATE_SUMMARY("Cant create summary"),
    CANT_CREATE_VACANCY("Cant create vacancy");

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
