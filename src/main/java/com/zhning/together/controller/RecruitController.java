package com.zhning.together.controller;

import com.google.gson.Gson;
import com.zhning.together.entity.Recruit;
import com.zhning.together.service.RecruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
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

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String list(){
        Gson gson = new Gson();
        List<Recruit> recruitList = recruitService.findAllIngRecruit();
        return gson.toJson(recruitList);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String create(@QueryParam("recruitCount") int recruitCount,
                         @QueryParam("userId") long userId){
        Recruit recruit = new Recruit();
        recruit.setRecruitCount(recruitCount);
        recruit.setUserId(userId);
        recruitService.addRecruit(recruit);
        Gson gson = new Gson();
        return gson.toJson("创建成功");
    }
}
