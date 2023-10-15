package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
import com.solution.appsolute.approval.dto.ApprovalDetail;
import com.solution.appsolute.login.dto.AuthInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;

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
    public void myApproval(Model model, HttpSession session){
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        if (authInfo != null) {
            System.out.println(authInfo);
            System.out.println(authInfo.getEmp_num());

            model.addAttribute("myApproval",approvalDao.findMyApproval(authInfo.getEmp_num()));

        }

    }

    @GetMapping("/{approvalNum}")
    public String approval(Model model, @PathVariable long approvalNum, HttpSession session) {
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        model.addAttribute("sessionEmpNum", authInfo.getEmp_num());
        model.addAttribute("approval", approvalDao.approvalOne((int) approvalNum));
        model.addAttribute("approvalDetail", approvalDao.approvalDetailOne((int) approvalNum));
        model.addAttribute("approvalContent", approvalDao.approvalContentOne((int) approvalNum));

        List<ApprovalDetail> approvalDetails = approvalDao.approvalStatus((int) approvalNum, 0);
        ApprovalDetail apd = null;
        int index = 0;
        for (ApprovalDetail approvalDetail : approvalDetails) {
            if (approvalDetail.getApprovalStatus() == 0) {
                apd = approvalDetail;
                index++;
                break;
            }
        }

        System.out.println(approvalDao.approvalStatus((int) approvalNum, 0));
        model.addAttribute("approvalStatus",apd);
//        System.out.println(approvalDao.approvalDetailOne((int) approvalNum).get(0));
        return "approval/approvalPage";
    }

    @GetMapping("/receivedApproval")
    public void receivedApproval(Model model, HttpSession session){
        AuthInfo authInfo = (AuthInfo) session.getAttribute("authInfo");
        System.out.println(approvalDao.includedMe(authInfo.getEmp_num()));
        List<Integer> approvalsIncludedMe = approvalDao.includedMe(authInfo.getEmp_num());
//        List<ApprovalDetail> pendingApprovals = null;
//        List<Approval> approvedByMe = null;
//        List<Approval> rejectedByMe = null;
//
//        for (Integer i : approvalsIncludedMe) {
//            pendingApprovals.add(approvalDao.approvalStatus(i, 0));
//            approvalDao.approvalStatus(i, 0);
//        }
//        model.addAttribute("pendingApproval", approvalDao.approvalStatus());
    }

}
