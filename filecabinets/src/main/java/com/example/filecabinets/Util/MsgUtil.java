package com.example.filecabinets.Util;

import com.alibaba.fastjson.JSONObject;

/**
 * @Description: 返回json字符串的msg$
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
public class MsgUtil {
    public static String successMsg(String type,String content)
    {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","ok");
        jsonObject.put(type,content);
        return jsonObject.toJSONString();
    }
    public static String errorMsg(String failInfo)
    {
        JSONObject jsonObject=new JSONObject();
        jsonObject.put("msg","error");
        jsonObject.put("failInfo",failInfo);
        return jsonObject.toJSONString();
    }
}
