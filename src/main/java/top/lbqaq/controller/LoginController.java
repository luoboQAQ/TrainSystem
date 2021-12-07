package top.lbqaq.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import top.lbqaq.model.Admin;
import top.lbqaq.model.User;
import top.lbqaq.service.AdminService;
import top.lbqaq.service.UserService;

import javax.servlet.http.HttpSession;
import java.util.Objects;

/**
 * @author luoboQAQ
 * @Date 2021/11/14
 */
@Controller
public class LoginController {
    @Autowired
    private UserService userService;
    @Autowired
    private AdminService adminService;

    @RequestMapping("/auth/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        Model model,
                        HttpSession session) {
        User user = userService.selectByName(username);
        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("userId", user.getId());
            session.setAttribute("userName", user.getName());
            session.setAttribute("role", "user");
            if (user.getRealName() != null) {
                session.setAttribute("realName", user.getRealName());
            }
            return "redirect:/main.html";
        }
        Admin admin = adminService.selectByName(username);
        if (admin != null && admin.getPassword().equals(password)) {
            session.setAttribute("userId", admin.getId());
            session.setAttribute("userName", admin.getName());
            session.setAttribute("role", "admin");
            return "redirect:/main.html";
        }
        model.addAttribute("msg", "用户名或密码错误");
        return "auth/sign-in";
    }

    @RequestMapping("/auth/signup")
    public String signUp(@RequestParam("username") String username,
                         @RequestParam("password") String password,
                         @RequestParam("password2") String password2,
                         Model model) {
        if (!Objects.equals(password, password2)) {
            model.addAttribute("msg", "两次密码输入的不一致");
            return "auth/sign-up";
        }
        if(password.length()<6||password.length()>16){
            model.addAttribute("msg", "密码长度不符合(6-16位)");
            return "auth/sign-up";
        }
        User user = userService.selectByName(username);
        if (user != null) {
            model.addAttribute("msg", "用户名已存在");
            return "auth/sign-up";
        }
        User newUser = new User();
        newUser.setName(username);
        newUser.setPassword(password);
        if (userService.insertSelective(newUser) == 0) {
            model.addAttribute("msg", "数据插入失败");
            return "auth/sign-up";
        }
        model.addAttribute("msg", "注册成功！");
        return "auth/sign-in";
    }

    @RequestMapping("/auth/loginout")
    public String loginOut(Model model, HttpSession session) {
        model.addAttribute("msg", "您已成功登出");
        session.invalidate();
        return "auth/sign-in";
    }
}
