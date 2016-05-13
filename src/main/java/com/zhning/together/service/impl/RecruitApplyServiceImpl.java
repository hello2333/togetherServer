package com.zhning.together.service.impl;

import com.zhning.together.dao.RecruitApplyMapper;
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

    public void applyRecruit(long applicantId, long recruitId) {
        RecruitApply recruitApply = new RecruitApply();
        recruitApply.setApplicantId(applicantId);
        recruitApply.setRecruitId(recruitId);
        recruitApplyMapper.insert(recruitApply);
    }

    public void agreeApply(long applicantId, long recruitId) {
        RecruitApply recruitApply = recruitApplyMapper.findRecruitApply(applicantId, recruitId);
        recruitApply.setCheckStatus(Constants.APPLY_AGREE);
        recruitApplyMapper.updateStatus(recruitApply);
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
