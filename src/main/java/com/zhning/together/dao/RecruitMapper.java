package com.zhning.together.dao;

import com.zhning.together.entity.Recruit;

import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */

public interface RecruitMapper {
    /**
     * 插入一条招募
     * @param recruit
     */
    void insert(Recruit recruit);

    /**
     * 更新招募的状态:正在招募中或者完成招募
     * @param recruit
     */
    void updateStatus(Recruit recruit);

    /**
     * 根据申请id得到申请
     * @param id
     * @return
     */
    Recruit findById(long id);

    /**
     * 获取所有处于招募状态的招募贴
     * @return
     */
    List<Recruit> findAllIngRecruit();

    /**
     * 根据发起人id得到他所有处于正在招募状态的招募
     * @param userId
     * @return
     */
    List<Recruit> findIngRecruitByOriginatorId(long userId);

    /**
     * 根据发帖人id得到所有他已招募结束的招募贴
     * @param userId
     * @return
     */
    List<Recruit> findAlreadyRecruitByOriginatorId(long userId);

    /**
     * 获取申请人正在申请的招募贴
     * @param userId
     * @return
     */
    List<Recruit> findIngRecruitByParticipantId(long userId);

    /**
     * 获取申请人通过了的招募贴
     * @param userId
     * @return
     */
    List<Recruit> findYesRecruitByParticipantId(long userId);
}
