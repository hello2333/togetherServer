package com.zhning.together.service.impl;

import com.zhning.together.dao.RecruitMapper;
import com.zhning.together.entity.Recruit;
import com.zhning.together.service.RecruitService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */
@Service
public class RecruitServiceImpl implements RecruitService {

    @Resource
    RecruitMapper recruitMapper;

    public void addRecruit(Recruit recruit) {
        recruitMapper.insert(recruit);
    }

    public Recruit getRecruitDetail(long recruitId) {
        Recruit recruit = recruitMapper.findById(recruitId);
        return recruit;
    }

    public List<Recruit> findAllIngRecruit() {
        List<Recruit> recruits = recruitMapper.findAllIngRecruit();
        return recruits;
    }

    public List<Recruit> findMyRecruitIng(long userId) {
        List<Recruit> recruits = recruitMapper.findIngRecruitByOriginatorId(userId);
        return recruits;
    }

    public List<Recruit> findMyHistory(long userId) {
        List<Recruit> myRecruits = recruitMapper.findAlreadyRecruitByOriginatorId(userId);
        List<Recruit> joinRecruits = recruitMapper.findYesRecruitByParticipantId(userId);
        List<Recruit> recruits = new ArrayList<Recruit>();
        recruits.addAll(myRecruits);
        recruits.addAll(joinRecruits);
        return recruits;
    }

    public List<Recruit> findMyApplying(long userId) {
        List<Recruit> recruits = recruitMapper.findIngRecruitByParticipantId(userId);
        return recruits;
    }
}
