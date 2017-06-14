package com.auto.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class RedisController {

   @Autowired
   private StringRedisTemplate stringRedisTemplate;

   @Autowired
   private RedisTemplate redisTemplate;

   @RequestMapping("/helloss")
   public String index() {
       // 保存字符串
       stringRedisTemplate.opsForValue().set("aaa", "111");
       String string = stringRedisTemplate.opsForValue().get("aaa");
       System.out.println(string);
       return "Hello World";
   }
   @RequestMapping(value = "/hello1",method = RequestMethod.GET)
   public String hello(Model model) {
       model.addAttribute("name", "Dear");
       return "hello";
   }
}