package com.example.filecabinets.Controller;

import com.example.filecabinets.Dao.UserRegisterRepository;
import com.example.filecabinets.Model.UserRegister;
import com.example.filecabinets.Service.UserService;
import com.example.filecabinets.Util.TokenThread;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @Description: 用户管理、用户注册$
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  UserService userService;
    @PostMapping(value = "/register")
    public String register(HttpServletRequest request) {
        UserRegister user=new UserRegister();
        user.setAuthority(request.getParameter("authority"));
        user.setSuccess(request.getParameter("success"));
        user.setOpenid(request.getParameter("openid"));
        user.setName(request.getParameter("name"));
        user.setPhone(request.getParameter("phone"));
        user.setCompany(request.getParameter("company"));
        user.setDepartment(request.getParameter("department"));
        return userService.register(user);
    }
}
