package com.yhr.Controller;

import com.mysql.cj.Session;
import com.yhr.Mapper.UserMapper;
import com.yhr.Service.UserService;
import com.yhr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.HttpRequestHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class PersonSetting {

    @Autowired
    UserService userService;
    @Autowired
    UserMapper userMapper;
    @RequestMapping("/toPersonSetting")
    public String personSetting(User user){
        return "/personSetting";
    }

    @RequestMapping("/yanZhen")
    public String yanZhen(@RequestParam("user_pwd") String pwd,@RequestParam("user_pwd2") String newpwd ,Model model,@RequestBody User user){
    if(pwd.equals(newpwd)){
        User user1 = userService.findUserById(user.getUser_id());
        user1.setUser_pwd(newpwd);
        userService.UpdateUser(user1);
        return "/index";
    }
        model.addAttribute("msg2","密码不一致");
    return "/personSetting";
    }

//    @RequestMapping("/Per")
//    public String persongSetting(@RequestBody User user, HttpSession session){
//        user.setUser_name((String)session.getAttribute("loginUser"));
//       userService.UpdateUser(user);
//        return "redirect:/toPersonSetting";
//    }




}
