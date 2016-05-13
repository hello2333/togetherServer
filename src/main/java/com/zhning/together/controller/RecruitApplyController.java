package com.zhning.together.controller;

import com.google.gson.Gson;
import com.zhning.together.service.RecruitApplyService;
import com.zhning.together.service.RecruitService;
import com.zhning.together.utils.Constants;
import com.zhning.together.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by baidu on 16/5/13.
 */
@Component
@Path("/recruitApply")
public class RecruitApplyController {
    @Autowired
    private RecruitService recruitService;

    @Autowired
    private RecruitApplyService recruitApplyService;

    @GET
    @Path("applyForRecruit")
    @Produces({MediaType.APPLICATION_JSON})
    public String applyForRecruit(@QueryParam("applicantId") long applicantId,
                                  @QueryParam("recruitId") long recruitId){
        recruitApplyService.applyRecruit(applicantId, recruitId);
        Gson gson = new Gson();
        return gson.toJson("apply success");
    }

    @GET
    @Path("agreeApply")
    @Produces({MediaType.APPLICATION_JSON})
    public String agreeApply(@QueryParam("applicantId") long applicantId,
                                  @QueryParam("recruitId") long recruitId){
        recruitApplyService.agreeApply(applicantId, recruitId);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, null);
    }

    @GET
    @Path("disAgreeApply")
    @Produces({MediaType.APPLICATION_JSON})
    public String disAgreeApply(@QueryParam("applicantId") long applicantId,
                             @QueryParam("recruitId") long recruitId){
        recruitApplyService.disAgreeApply(applicantId, recruitId);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, null);
    }

    @GET
    @Path("applicants/{recruitId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getApplicantsForRecruit(@PathParam(value = "recruitId") long recruitId){
        List<Long> applicants = recruitApplyService.getApplicantsForRecruit(recruitId);
        if (null == applicants)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, applicants);
    }

    @GET
    @Path("partners/{recruitId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getPartnersForRecruit(@PathParam(value = "recruitId") long recruitId){
        List<Long> partners = recruitApplyService.getPartnerForRecruit(recruitId);
        if (null == partners)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, partners);
    }
}
