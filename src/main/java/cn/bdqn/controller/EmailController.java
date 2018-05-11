package cn.bdqn.controller;

import cn.bdqn.entity.Email;
import cn.bdqn.entity.User;
import cn.bdqn.service.EmailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Controller
public class EmailController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Resource
    private EmailService emialService;

    @RequestMapping("toMain")
    public String toMain(HttpSession session) {
        Object user = session.getAttribute("user");
        logger.info("toMain======");
        if (user == null) {
            return "redirect:/toLogin";
        } else {
            return "main";
        }
    }

    @RequestMapping("listSend")
    public String listSend(String accepter, Model model) {
        logger.info("listSend===>");
        if (accepter == null) {
            accepter = "";
        }
        List<Map<String, Object>> list = emialService.listSend(accepter, 1);
        model.addAttribute("list", list);
        model.addAttribute("accepter", accepter);
        return "sendList";
    }

    @RequestMapping("listDraft")
    public String listDraft(Model model) {
//        ModelAndView mav = new ModelAndView();
        List<Map<String, Object>> list = emialService.listSend("", 2);
        model.addAttribute("list", list);
        return "draftList";
    }

    @RequestMapping(value = "/toAdd", method = RequestMethod.GET)
    public String toAdd() {
        return "add";
    }

    @RequestMapping(value = "/deleteMail", method = RequestMethod.GET)
    public String deleteMail(String id) {
//        String id = request.getParameter("id");
        boolean flag = emialService.delete(id);
        if(flag){
            return "redirect:/listSend";
        }
        return "sendList";
    }

    @ResponseBody
    @RequestMapping(value = "/hasTitle", method = RequestMethod.GET)
    public String hasTitle(String title) {
//        String title = request.getParameter("title");
        int result = emialService.hasTitle(title);
        return result + "";
    }


    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String add(@ModelAttribute Email email, @RequestParam("file") MultipartFile file, HttpServletRequest request) {
        logger.info("Filename===>"+file.getContentType());
        String filePath = "";
        String filename = "";
        if (!file.isEmpty()) {
            String path = request.getServletContext().getRealPath("/images/");
            filename = file.getOriginalFilename();
            logger.info("path:"+path);
            File filepath = new File(path, filename);
            if (!filepath.getParentFile().exists()) {
                filepath.getParentFile().mkdirs();
            }
            try {
                filePath = path + File.separator + filename;
                logger.info("filePath===>"+filePath);
                file.transferTo(new File(filePath));
            } catch (IllegalStateException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        User user = (User) request.getSession().getAttribute("user");
        email.setSender(user.getEmail());
        email.setType(email.getType());
        boolean flag = emialService.add(email);
        if(flag){
            return "redirect:/listSend";
        }
        return "add";
    }


}
