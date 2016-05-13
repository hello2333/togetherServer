package com.zhning.together.utils;

import com.google.gson.Gson;

/**
 * Created by baidu on 16/5/14.
 */
public class JsonResult {
    int code;
    String data;
    String msg;

    public JsonResult(int code, String data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }

    public static String JsonResultForObjectAsDefault(Constants.Code code, Object data){
        Gson gson = new Gson();
        JsonResult jsonResult = new JsonResult(code.getCode(), gson.toJson(data), code.getMessage());
        return gson.toJson(jsonResult);
    }

    public static String JsonResultForObjectWithMsg(Constants.Code code, Object data, String msg){
        Gson gson = new Gson();
        JsonResult jsonResult = new JsonResult(code.getCode(), gson.toJson(data), msg);
        return gson.toJson(jsonResult);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
