package com.solution.appsolute.approval.controller;

import com.solution.appsolute.approval.dao.ApprovalDao;
import com.solution.appsolute.approval.dto.AddDetailVO;
import com.solution.appsolute.approval.dto.AddPersonVO;
import com.solution.appsolute.approval.dto.Basic;
import com.solution.appsolute.approval.dto.PurchaseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
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
        AddPersonVO addPersonVO = new AddPersonVO();
        for (int i = 1; i < empNoData.size(); i++) {
            System.out.println("itar > "+empNoData.get(i));
            addPersonVO.setEmpCheckNum(empNoData.get(i));
            addPersonVO.setSequence(i);
            addPersonVO.setApprovalNum(empNoData.get(0));
            System.out.println(addPersonVO+"--------"+i);
            approvalDao.addPerson(addPersonVO);
        }

        return 0;
    }

    @RequestMapping(value = "/addDetail", method = RequestMethod.POST)
    public int addDetail(@RequestBody List<PurchaseVO> detailPurchaseArray){
        System.out.println(detailPurchaseArray);
        return 0;
    }

    @RequestMapping(value = "/addPurchase", method = RequestMethod.POST)
    public int addPurchase(@RequestBody List<PurchaseVO> purchaseArray) {
        System.out.println(purchaseArray);
        approvalDao.addPurchaseDetail(purchaseArray.get(0));
        approvalDao.addPurchaseDetail(purchaseArray.get(1));
        return 0;
    }
}
