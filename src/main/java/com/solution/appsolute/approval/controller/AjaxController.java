package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
import com.solution.appsolute.approval.dto.Basic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/form")
public class AjaxController {

    @Autowired
    private ApprovalDao approvalDao;

    @RequestMapping(value = "/purchaseBasic",method = RequestMethod.POST)
    public long purchaseBasic(@RequestBody Basic basic){
        System.out.println("------------------"+basic);
        approvalDao.insertApp(basic);
        System.out.println("------------------22"+basic);
        return basic.getApprovalNum();
    }

    @RequestMapping(value = "/addPerson", method = RequestMethod.POST)
    public int addPerson(@RequestBody Map<String, List<Integer>> reqData){
        System.out.println("****************"+reqData.get("empNoData"));
        List<Integer> empNoData = reqData.get("empNoData");
        System.out.println(empNoData.get(0));
        System.out.println(empNoData.get(1));
        System.out.println(empNoData.get(2));

        return 0;
    }
}
