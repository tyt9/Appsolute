package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
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


    @GetMapping("/purchaseSuccess")
    public void purchasePost1(Model model) {
        model.addAttribute("approvalOne", approvalDao.approvalOne(67));
//        System.out.println(approvalDao.approvalOne(67));
        model.addAttribute("approvalDetailOne", approvalDao.approvalDetailOne(13));
        System.out.println("test > "+approvalDao.approvalDetailOne(13));
//        model.addAttribute("approvalContentOne", approvalDao.approvalContentOne(13));
        System.out.println("test 2 > "+approvalDao.approvalContentOne(13));
//        System.out.println("--------------"+expenseReport);
    }

    @PostMapping("/purchaseSuccess")
    public void purchasePost(Model model, ExpenseReport expenseReport) {
        model.addAttribute("approvalOne", approvalDao.approvalOne(67));
        model.addAttribute("approvalDetailOne", approvalDao.approvalDetailOne(18));
        System.out.println(approvalDao.approvalDetailOne(18));
//        model.addAttribute("approvalContentOne", approvalDao.approvalContentOne(67));
    }

}
