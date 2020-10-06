package com.kuang.controller;

import com.kuang.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/user")
public class UserController {
    @GetMapping("/t1")
    public String test1(@RequestParam("username") String name, Model model){
        //1. 接收前段参数
        System.out.println("接收到前段的参数为" + name);
        //2. 将返回的结果传递给前段
        model.addAttribute("msg", name);
        //3. 跳转视图
        return "test";
    }

    //前段接收的是一个对象： ID，name，age
    @GetMapping("/t2")
    public String test2(User user, Model model){
        System.out.println(user);
        return "test";
    }

}
