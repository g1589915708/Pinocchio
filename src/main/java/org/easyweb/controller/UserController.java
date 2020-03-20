package org.easyweb.controller;

import org.easyweb.model.UserModel;
import org.easyweb.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @RequestMapping("reg")
    public String Reg(UserModel user){
        System.out.println("reg");
        System.out.println(user);
        userService.InsertByUser(user);
        return "SUCCESS";
    }
    @RequestMapping("del")
    public String Del(UserModel user){
        System.out.println("del");
        System.out.println(user);
        userService.DeleteByName(user);
        return "SUCCESS";
    }
    @RequestMapping("upd")
    public String Upd(UserModel user){
        System.out.println("upd");
        System.out.println(user);
        userService.UpdateByName(user);
        return "SUCCESS";
    }
    @RequestMapping("sels")
    @ResponseBody
    public UserModel Sele(UserModel user){
        return userService.SelectByName(user);
    }
    @RequestMapping("sel")
    public String sel(UserModel user, HttpServletRequest request){
        System.out.println("sel");
        System.out.println(user);
        return "SUCCESS";
    }
}
