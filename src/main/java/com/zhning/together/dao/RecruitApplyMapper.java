package com.zhning.together.dao;

import com.zhning.together.entity.RecruitApply;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */
public interface RecruitApplyMapper {
    /**
     * 增加一条申请
     * @param recruitApply
     */
    void insert(RecruitApply recruitApply);

    /**
     * 更新申请的状态:同意或者拒绝
     * @param recruitApply
     */
    void updateStatus(RecruitApply recruitApply);

    /**
     * 获取申请
     * @param applicantId
     * @param recruitId
     * @return
     */
    RecruitApply findRecruitApply(@Param("applicantId") long applicantId,
                                  @Param("recruitId") long recruitId);

    /**
     * 获取申请人申请的招募
     * @param applicantId
     * @return
     */
    List<Long> findIngRecruitByApplicantId(long applicantId);
    List<Long> findYesRecruitByApplicantId(long applicantId);
    List<Long> findApplicantsByRecruitId(long recruitId);
    List<Long> findPartnersByRecruitId(long recruitId);
}
