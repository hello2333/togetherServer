package com.zhning.together.service;

import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */
public interface RecruitApplyService {
    /**
     * 发起一条申请
     * @param applicantId
     * @param recruitId
     */
    void applyRecruit(long applicantId, long recruitId);

    /**
     * 同意申请
     * @param applicantId
     * @param recruitId
     */
    void agreeApply(long applicantId, long recruitId);

    /**
     * 拒绝申请
     * @param applicantId
     * @param recruitId
     */
    void disAgreeApply(long applicantId, long recruitId);

    /**
     * 获取招募贴的申请人
     * @param recruitId
     * @return
     */
    List<Long> getApplicantsForRecruit(long recruitId);

    /**
     * 获取招募贴的参与人
     * @param recruitId
     * @return
     */
    List<Long> getPartnerForRecruit(long recruitId);

    boolean applyRecruitExist(long applicantId, long recruitId);
}
