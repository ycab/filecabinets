package com.example.filecabinets.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description: $
 * @Param: $
 * @return: $
 * @Author: your name
 * @date: $
 */
@Controller
public class HomeController {
    @GetMapping(value = "/user/registerview")
    public String login()
    {
        return "User/Register.html";
    }
}
