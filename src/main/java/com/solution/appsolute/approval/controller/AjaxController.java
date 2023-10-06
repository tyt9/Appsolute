package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
import com.solution.appsolute.approval.dto.Basic;
import com.solution.appsolute.approval.dto.ExpenseReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/form")
public class AjaxController {

    @Autowired
    private ApprovalDao approvalDao;

    @RequestMapping(value = "/purchaseBasic",method = RequestMethod.POST)
    public int purchaseBasic(@RequestBody Basic basic){
        System.out.println("------------------"+basic);
        approvalDao.insertApp(basic);
        return 0;
    }

}
