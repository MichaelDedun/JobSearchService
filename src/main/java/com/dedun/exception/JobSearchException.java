package com.dedun.exception;

public class JobSearchException extends Throwable {

    private JobSearchErrorCode jobSearchErrorCode;

    public JobSearchException(JobSearchErrorCode jobSearchErrorCode) {
        this.jobSearchErrorCode = jobSearchErrorCode;
    }

    public JobSearchErrorCode getJobSearchErrorCode() {
        return jobSearchErrorCode;
    }

    public void setJobSearchErrorCode(JobSearchErrorCode jobSearchErrorCode) {
        this.jobSearchErrorCode = jobSearchErrorCode;
    }
}
