package com.kuang.controller;

import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.kuang.pojo.User;
import com.kuang.utils.JsonUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

//@Controller
@RestController //不走视图解析器
public class UserController {
//    @ResponseBody//表明不会走视图解析器
    @RequestMapping("/json")
    public String json1() throws JsonProcessingException {
        //jackson, objectMapper
        ObjectMapper mapper = new ObjectMapper();
//        创建一个对象
        User user = new User("王希恒", 3, "男");
        String str = mapper.writeValueAsString(user);
        return str;
    }
    @RequestMapping("/json2")
    public String json2() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        List<User> userList = new ArrayList<User>();
        User user1 = new User("王希恒", 3, "男");
        User user2 = new User("王希恒", 3, "男");
        User user3 = new User("王希恒", 3, "男");
        User user4 = new User("王希恒", 3, "男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        String str = mapper.writeValueAsString(userList);

//        return str;
        return JsonUtils.getJson(userList);
    }

    @RequestMapping("/json3")
    public String json3() throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        //使用ObjectMapper 来格式化输出
        //不使用时间戳的方式
        mapper.configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);
        //自定义日期的格式
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        mapper.setDateFormat(simpleDateFormat);
        Date date = new Date();
//        objectMapper, 时间解析后的默认格式为：Timestamp，时间戳
        return mapper.writeValueAsString(date);
//        return mapper.writeValueAsString(simpleDateFormat.format(date));
    }

    @RequestMapping("/json4")
    public String json4() throws JsonProcessingException {
        Date date = new Date();
        return JsonUtils.getJson(date,"yyyy-MM-dd HH:mm:ss");
    }

    @RequestMapping("/json5")
    public String json5(){
        List<User> userList = new ArrayList<User>();
        User user1 = new User("王希恒", 3, "男");
        User user2 = new User("王希恒", 3, "男");
        User user3 = new User("王希恒", 3, "男");
        User user4 = new User("王希恒", 3, "男");
        userList.add(user1);
        userList.add(user2);
        userList.add(user3);
        userList.add(user4);
        String s = JSON.toJSONString(userList);
        return s;

    }
}
