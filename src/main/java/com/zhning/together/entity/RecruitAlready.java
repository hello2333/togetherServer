package com.zhning.together.entity;

/**
 * Created by baidu on 16/5/13.
 */
public class RecruitAlready {
    long id;
    long joinId;
    long recruitId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getJoinId() {
        return joinId;
    }

    public void setJoinId(long joinId) {
        this.joinId = joinId;
    }

    public long getRecruitId() {
        return recruitId;
    }

    public void setRecruitId(long recruitId) {
        this.recruitId = recruitId;
    }
}
