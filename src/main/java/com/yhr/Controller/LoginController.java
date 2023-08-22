package com.yhr.Controller;

import com.sun.deploy.net.HttpResponse;
import com.yhr.Mapper.EmployeeMapper;
import com.yhr.Mapper.UserMapper;
import com.yhr.Service.UserService;
import com.yhr.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Controller
public class LoginController {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;


//    @RequestMapping("/user/login")
//    //通过@RequestParam("username")来获取页面上的名字是：username输入的值
//    public String login(@RequestParam("user_name") String username,
//                        @RequestParam("user_pwd")String password,
//                        Model model, HttpSession session) {
//        //具体业务，判断用户名是否正确
//        User user = userMapper.userLogin(username, password);
//        if (user != null) {
//            if (user.getUser_name().equals(username) && user.getUser_pwd().equals(password)) {
//                session.setAttribute("loginUser", username);
//                session.setAttribute("power",user.getPower());
//                return "redirect:/main.html";   //重定向到main.html
//            }
//        }
//            //告诉用户登录失败
//            model.addAttribute("msg", "用户名或者密码错误");
//            return "login";
//    }

    @RequestMapping("/register")
    public String regist(@RequestBody User user,Model model){

        User userByName = userMapper.findUserByName(user.getUser_name());
        if (userByName==null){
            System.out.println(user);
            userService.addUser(user);
            return "/login.html ";

        }else {
            model.addAttribute("msg","以经存在相应的账号");
            return "/regist";
        }

    }

    @RequestMapping("/creat")
    public String regist(){
        return "regist";
    }



    @RequestMapping("/get-power")
    public void power(HttpSession session, HttpServletResponse response ) throws IOException {
        String permission = (String) session.getAttribute("power");
        response.getWriter().write(permission);
    }
}
