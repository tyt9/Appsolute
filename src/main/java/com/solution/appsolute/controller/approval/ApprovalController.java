package com.solution.appsolute.controller.approval;

import com.solution.appsolute.dao.approval.ApprovalDao;
import com.solution.appsolute.dto.approval.Basic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalDao approvalDao;

    @GetMapping("/purchase")
    public void purchase1(Model model){
        model.addAttribute("list", approvalDao.find());
        System.out.println(approvalDao.find());
    }

    @PostMapping("/purchase")
    public void purchasePost(@RequestParam String name, @RequestParam String dept, @RequestParam String price, Basic basic) {
        System.out.println(name);
        System.out.println(dept);
        System.out.println(price);
        System.out.println(basic);
    }

    @GetMapping("/purchaseForm")
    public void purchase2(Model model) {

    }

}
