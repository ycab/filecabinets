package com.example.filecabinets.Service;

import com.alibaba.fastjson.JSONObject;
import com.example.filecabinets.Util.HttpUtil;
import com.example.filecabinets.Util.MsgUtil;
import com.example.filecabinets.properties.WeChatProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetOpenIdService {
    @Autowired
    private WeChatProperties weiXinProperties;
    public String getOpenid(String code){
        String response;
        String appId = weiXinProperties.getAPPID();
        String appSecret = weiXinProperties.getAPPSECRET();
        try {
            String URL = "https://api.weixin.qq.com/sns/oauth2/access_token?grant_type=authorization_code";
            String getDataStr = "&appid=" + appId + "&secret=" + appSecret+"&code="+code;
            String str = HttpUtil.HttpGet(URL+getDataStr);
            JSONObject json = JSONObject.parseObject(str);   //解析json成json对
            String openid = json.getString("openid");
            if(openid==null){
                String errmsg=json.getString("errmsg");
                response= MsgUtil.errorMsg(errmsg);
            } else {
                response= MsgUtil.successMsg("openid",openid);
            }
        }
        catch (Exception e) {
            response=MsgUtil.errorMsg(e.toString());
        }
        return response;
    }
}
