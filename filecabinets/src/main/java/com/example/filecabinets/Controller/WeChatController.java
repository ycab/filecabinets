package com.example.filecabinets.Controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.filecabinets.Service.GetOpenIdService;
import com.example.filecabinets.Util.MsgUtil;
import com.example.filecabinets.properties.WeChatProperties;
import org.aspectj.apache.bcel.classfile.Code;
import org.omg.CORBA.Request;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.server.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @Description: 获取openid$
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@RestController
@RequestMapping(value="/wechat")
public class WeChatController {
    @Autowired
    private WeChatProperties weiXinProperties;
    @Autowired
    private GetOpenIdService getOpenIdService;
    @PostMapping(value="/appid")
    public String getAppid() {
        return weiXinProperties.getAPPID();
    }
    @PostMapping(value="/openid")
    public String getOpenid(HttpServletRequest request,HttpSession session) {
        String code = request.getParameter("code");
        String openid=(String)session.getAttribute("openid");
        String response;
        if(openid==null){
            String res=getOpenIdService.getOpenid(code);
            JSONObject jsonObject=JSONObject.parseObject(res);
            String msg=jsonObject.getString("msg");
            if(msg.equals("ok")) {
                openid=jsonObject.getString("openid");
                session.setAttribute("openid",openid);
                response=res;
            } else {
                response=res;
            }
        } else {
            response=MsgUtil.successMsg("openid",openid);
        }
        return response;
    }
}
