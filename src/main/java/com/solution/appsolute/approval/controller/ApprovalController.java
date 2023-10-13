package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
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
    }


    @GetMapping("/purchaseSuccess")
    public void purchasePost1(Model model) {
        model.addAttribute("approvalOne", approvalDao.approvalOne(69));
//        System.out.println(approvalDao.approvalOne(67));
        model.addAttribute("approvalDetailOne", approvalDao.approvalDetailOne(69));
        System.out.println("test > "+approvalDao.approvalDetailOne(69));
        model.addAttribute("approvalContentOne", approvalDao.approvalContentOne(69));
        System.out.println("test 2 > "+approvalDao.approvalContentOne(69));
//        System.out.println("--------------"+expenseReport);
        System.out.println(approvalDao.lastKey());
        model.addAttribute("lastKey", approvalDao.lastKey());
    }

    @PostMapping("/purchaseSuccess")
    public void purchasePost(Model model) {
        System.out.println(approvalDao.lastKey());
        int lastKey = approvalDao.lastKey();
        model.addAttribute("approvalOne", approvalDao.approvalOne(lastKey));
//        System.out.println(approvalDao.approvalOne(67));
        model.addAttribute("approvalDetailOne", approvalDao.approvalDetailOne(lastKey));
        System.out.println("test > "+approvalDao.approvalDetailOne(lastKey));
        model.addAttribute("approvalContentOne", approvalDao.approvalContentOne(lastKey));
        System.out.println("test 2 > "+approvalDao.approvalContentOne(lastKey));
//        System.out.println("--------------"+expenseReport);

    }

    @GetMapping("/myApproval")
    public void myApproval(){

    }

}
