package com.example.filecabinets.Service;

import com.example.filecabinets.Dao.UserRegisterRepository;
import com.example.filecabinets.Model.UserRegister;
import com.example.filecabinets.Util.MsgUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@Service
public class UserService {
    @Autowired
    private UserRegisterRepository userRegisterRepository;
    public String register(UserRegister user){
       String response;
       try {
           List<UserRegister> list=userRegisterRepository.findByPhone(user.getPhone());
           if(list.size()>0) {
               if(list.get(0).getSuccess()=="0"){
                   response=MsgUtil.errorMsg("等待审核");
               } else {
                   response=MsgUtil.errorMsg("该手机号已注册");
               }
           } else {
               userRegisterRepository.save(user);
               response=MsgUtil.successMsg("info","注册成功");
           }
       }
       catch (Exception e) {
           response=MsgUtil.errorMsg(e.toString());
       }
       return response;
    }
}
