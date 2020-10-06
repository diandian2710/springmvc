package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class RestFulController {
    //原来的http://localhost:8080/s/add?a=1&b=2
    //RestFul: http://localhost:8080/s/add/a/b
//    @RequestMapping("/add")
//    public String test1(int a, int b, Model model){
//        int res = a + b;
//        model.addAttribute("msg", "结果为" + res);
//        return ("test");
//    }
//    @RequestMapping(name = "haha", value= "/add/{a}/{b}", method = RequestMethod.GET)
    @PostMapping("/add/{a}/{b}")
    public String test1(@PathVariable int a,@PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "结果为post" + res);
        return ("test");
    }
    @GetMapping("/add/{a}/{b}")
    public String test2(@PathVariable int a,@PathVariable int b, Model model){
        int res = a + b;
        model.addAttribute("msg", "结果为get" + res);
        return ("test");
    }

}
