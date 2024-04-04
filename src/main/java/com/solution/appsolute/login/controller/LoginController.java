package com.solution.appsolute.login.controller;



import com.solution.appsolute.login.dto.AuthInfo;
import com.solution.appsolute.login.dto.Employee;
import com.solution.appsolute.login.mapper.LoginMapper;
import com.solution.appsolute.login.service.AuthService;
import com.solution.appsolute.login.service.LoginService;
import com.solution.appsolute.mail.dao.mapper.MailMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Autowired
    LoginMapper loginMapper;

    @Autowired
    AuthService authService;

    @Autowired
    LoginService loginService;

    @Autowired
    MailMapper mailMapper;

    private static final Logger logger = LoggerFactory.getLogger(LoginController.class);

    @GetMapping("/")
    public String getLogin() {

        return "/login/login";
    }


    @GetMapping("/login/mypage")
    public String mypage(HttpSession session, Model model){
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        model.addAttribute("empList", loginMapper.myPageListEmp());
        int mailTotal = mailMapper.countUnreadDao(authInfo.getEmp_num());
        model.addAttribute("mailTotal", mailTotal);
        model.addAttribute("empNum", authInfo.getEmp_num());
        model.addAttribute("userName", authInfo.getEmp_name());
        return "/login/mypage";
    }

    @GetMapping("/login/search")
    public String mypageSearch(HttpSession session, Model model, @RequestParam(value = "keyword") String name){
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        model.addAttribute("empList", loginMapper.myPageListEmpByName(name));
        int mailTotal = mailMapper.countUnreadDao(authInfo.getEmp_num());
        model.addAttribute("mailTotal", mailTotal);
        model.addAttribute("empNum", authInfo.getEmp_num());
        model.addAttribute("userName", authInfo.getEmp_name());
        return "/login/mypage";
    }


    @PostMapping("/login/mypage")
    public String postLogin(@RequestParam Long emp_num, @RequestParam String emp_password,
                            HttpSession session, Model model) {


        AuthInfo authInfo = authService.authenticate(emp_num, emp_password);

        System.out.println("------------------------------" + authInfo);
        session.setAttribute("authInfo", authInfo);
        //Employee employee = loginService.selectByEmp_num(emp_num);
        Employee employee =  loginMapper.selectByEmp_num(emp_num);
        return "redirect:/login/mypage";

    }


}
