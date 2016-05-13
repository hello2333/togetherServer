package com.zhning.together.controller;

import com.google.gson.Gson;
import com.zhning.together.entity.Recruit;
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
@Path("/recruit")
public class RecruitController {

    @Autowired
    private RecruitService recruitService;

    @Autowired
    private RecruitApplyService recruitApplyService;

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String list(){
        List<Recruit> recruitList = recruitService.findAllIngRecruit();
        if (recruitList == null)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, recruitList);
    }

    @GET
    @Path("{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getRecruit(@PathParam(value = "id")long id){
        Recruit recruit = recruitService.getRecruitDetail(id);
        if (null == recruit)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, recruit);
    }

    @GET
    @Path("create")
    @Produces({MediaType.APPLICATION_JSON})
    public String create(@QueryParam("recruitCount") int recruitCount,
                         @QueryParam("userId") long userId){
        Recruit recruit = new Recruit();
        recruit.setRecruitCount(recruitCount);
        recruit.setUserId(userId);
        recruitService.addRecruit(recruit);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, null);
    }

    @GET
    @Path("recruiting/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserRecruiting(@PathParam(value = "userId") long userId){
        List<Recruit> recruitingList = recruitService.findMyRecruitIng(userId);
        if (null == recruitingList)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, recruitingList);
    }

    @GET
    @Path("applying/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserApplying(@PathParam(value = "userId") long userId){
        List<Recruit> applyingList = recruitService.findMyApplying(userId);
        if (null == applyingList)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, applyingList);
    }

    @GET
    @Path("history/{userId}")
    @Produces({MediaType.APPLICATION_JSON})
    public String getUserHistory(@PathParam(value = "userId") long userId){
        List<Recruit> historyList = recruitService.findMyHistory(userId);
        if (null == historyList)
            return JsonResult.JsonResultForObjectAsDefault(Constants.Code.NULLDATA, null);
        return JsonResult.JsonResultForObjectAsDefault(Constants.Code.SUCCESS, historyList);
    }

}
