package com.solution.appsolute.controller.approval;

import com.solution.appsolute.dao.approval.ApprovalDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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

    @GetMapping("/purchaseForm")
    public void purchase2(Model model) {

    }

}
