package com.zhning.together.entity;

/**
 * Created by baidu on 16/5/13.
 */
public class Recruit {
    long id;
    int recruitCount;
    int alreadyRecruit;
    int status;
    long userId;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getRecruitCount() {
        return recruitCount;
    }

    public void setRecruitCount(int recruitCount) {
        this.recruitCount = recruitCount;
    }

    public int getAlreadyRecruit() {
        return alreadyRecruit;
    }

    public void setAlreadyRecruit(int alreadyRecruit) {
        this.alreadyRecruit = alreadyRecruit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
