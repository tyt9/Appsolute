package com.solution.appsolute.controller.approval;

import com.solution.appsolute.dao.approval.ApprovalDao;
import com.solution.appsolute.dto.approval.Approval;
import com.solution.appsolute.dto.approval.ExpenseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    private ApprovalDao approvalDao;

    @GetMapping("/purchase")
    public void purchase1(Model model, ExpenseReport expenseReport){
//        if (expenseReport != null) {
//            model.addAttribute("expenseReport", expenseReport);
//        } else {
//            model.addAttribute("expenseReport", new ExpenseReport());
//        }
    }

    @PostMapping("/purchaseSuccess")
    public void purchasePost(Model model, ExpenseReport expenseReport) {
        model.addAttribute("expenseReport", expenseReport);
        System.out.println("--------------"+expenseReport);
    }

    @GetMapping("/purchaseForm")
    public void purchase2(Model model, Approval approval) {

    }

}
