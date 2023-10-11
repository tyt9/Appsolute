package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
import com.solution.appsolute.approval.dto.Approval;
import com.solution.appsolute.approval.dto.ExpenseReport;
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
    public void purchase1(Model model){
        model.addAttribute("deptList", approvalDao.deptList());
        model.addAttribute("empList", approvalDao.empList());
        model.addAttribute("purchaseFieldNames", approvalDao.purchaseFieldNames());
//        System.out.println(approvalDao.deptList());
//        System.out.println(approvalDao.empList());
        System.out.println(approvalDao.purchaseFieldNames().get(0));
    }

    @PostMapping("/purchaseSuccess")
    public void purchasePost(Model model, ExpenseReport expenseReport) {
        model.addAttribute("expenseReport", expenseReport);
//        System.out.println("--------------"+expenseReport);
    }

}
