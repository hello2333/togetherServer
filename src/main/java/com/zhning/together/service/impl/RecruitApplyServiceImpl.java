package com.zhning.together.service.impl;

import com.zhning.together.dao.RecruitApplyMapper;
import com.zhning.together.dao.RecruitMapper;
import com.zhning.together.entity.Recruit;
import com.zhning.together.entity.RecruitApply;
import com.zhning.together.service.RecruitApplyService;
import com.zhning.together.utils.Constants;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */
@Service
public class RecruitApplyServiceImpl implements RecruitApplyService {
    @Resource
    RecruitApplyMapper recruitApplyMapper;

    @Resource
    RecruitMapper recruitMapper;

    public void applyRecruit(long applicantId, long recruitId) {
        RecruitApply recruitApply = recruitApplyMapper.findRecruitApply(applicantId, recruitId);
        if (null != recruitApply)
            return;
        recruitApply = new RecruitApply();
        recruitApply.setApplicantId(applicantId);
        recruitApply.setRecruitId(recruitId);
        recruitApplyMapper.insert(recruitApply);
    }

    public boolean applyRecruitExist(long applicantId, long recruitId) {
        RecruitApply recruitApply = recruitApplyMapper.findRecruitApply(applicantId, recruitId);
        if (null == recruitApply)
            return true;
        return false;
    }

    public void agreeApply(long applicantId, long recruitId) {
        RecruitApply recruitApply = recruitApplyMapper.findRecruitApply(applicantId, recruitId);
        recruitApply.setCheckStatus(Constants.APPLY_AGREE);
        recruitApplyMapper.updateStatus(recruitApply);

        Recruit recruit = recruitMapper.findById(recruitId);
        System.out.println("before:agreeApply--alreadyRecruit:" + recruit.getAlreadyRecruit());
        recruit.setAlreadyRecruit(recruit.getAlreadyRecruit() + 1);
        System.out.println("after:agreeApply--alreadyRecruit:" + recruit.getAlreadyRecruit());
        if (recruit.getAlreadyRecruit() == recruit.getRecruitCount()){
            recruit.setStatus(Constants.RECRUIT_FINISH);
        }
        recruitMapper.updateStatus(recruit);
    }

    public void disAgreeApply(long applicantId, long recruitId) {

    }

    public List<Long> getApplicantsForRecruit(long recruitId) {
        List<Long> applicants = recruitApplyMapper.findApplicantsByRecruitId(recruitId);
        return applicants;
    }

    public List<Long> getPartnerForRecruit(long recruitId) {
        List<Long> partners = recruitApplyMapper.findPartnersByRecruitId(recruitId);
        return partners;
    }
}
