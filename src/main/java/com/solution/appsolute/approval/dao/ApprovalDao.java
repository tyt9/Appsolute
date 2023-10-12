package com.solution.appsolute.approval.dao;

import com.solution.appsolute.approval.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApprovalDao {

    public List<Approval> find();
    public List<Dept> deptList();
    public List<Employee> empList();
    public void insertApp(Basic basic);

    public void addPerson(AddPersonVO addPersonVO);
    public List<String> purchaseFieldNames();

    public void addPurchaseDetail(PurchaseVO purchaseVO);
    public Approval approvalOne(int approvalNum);

    public List<ApprovalDetail> approvalDetailOne(int approvalNum);

    public List<ApprovalContent> approvalContentOne(int approvalNum);
}
