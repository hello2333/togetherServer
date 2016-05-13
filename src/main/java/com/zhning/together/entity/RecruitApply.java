package com.zhning.together.entity;

/**
 * Created by baidu on 16/5/13.
 */
public class RecruitApply {
    long id;
    long applicantId;
    long recruitId;
    int checkStatus;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getApplicantId() {
        return applicantId;
    }

    public void setApplicantId(long applicantId) {
        this.applicantId = applicantId;
    }

    public long getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(long recruitId) {
        this.recruitId = recruitId;
    }

    public int getCheckStatus() {
        return checkStatus;
    }

    public void setCheckStatus(int checkStatus) {
        this.checkStatus = checkStatus;
    }
}
