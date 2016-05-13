package com.zhning.together.service;

import com.zhning.together.entity.Recruit;

import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */
public interface RecruitService {
    /**
     * 创建招募
     * @param recruit
     */
    void addRecruit(Recruit recruit);

    /**
     * 获取招募详情
     * @param recruitId
     * @return
     */
    Recruit getRecruitDetail(long recruitId);

    /**
     * 所有所有正在招募状态的招募贴
     * @return
     */
    List<Recruit> findAllIngRecruit();

    /**
     * 获取我的正在招募状态的招募贴
     * @param userId
     * @return
     */
    List<Recruit> findMyRecruitIng(long userId);

    /**
     * 获取我的活动历史:我发起的已完成招募的招募贴,和我参与的招募
     * @param userId
     * @return
     */
    List<Recruit> findMyHistory(long userId);

    /**
     * 获取我申请的招募
     * @param userId
     * @return
     */
    List<Recruit> findMyApplying(long userId);
}
