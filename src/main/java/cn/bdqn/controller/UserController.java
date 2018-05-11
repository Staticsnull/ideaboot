package cn.bdqn.controller;

import cn.bdqn.entity.User;
import cn.bdqn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/toLogin", method = RequestMethod.GET)
    public String toLogin(String status, Model model) {
        model.addAttribute("status", status);
        return "login";
    }


    @RequestMapping(value = "/isLogin", method = RequestMethod.POST)
    public String isLogin(@ModelAttribute User user, HttpServletRequest request, HttpSession session) {
        List<User> list = userService.isLogin(user.getEmail(), user.getUserPassword());
        if (list.size() == 1) {
            session.setAttribute("user", list.get(0));
            return "redirect:/toMain";
        } else {
            return "redirect:/toLogin?status=0";
        }

    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpSession session) {
        session.removeAttribute("user");
        return "redirect:/toLogin";
    }

    @ResponseBody
    @RequestMapping(value = "/hasAccepter", method = RequestMethod.GET)
    public String hasAccepter(String accepter) {
//		String accepter = request.getParameter("accepter");
        int result = userService.hasEmail(accepter);
        return result + "";
    }


}
