package com.solution.appsolute.approval.dao;

import com.solution.appsolute.approval.dto.*;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

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
    public int lastKey();
    public List<Approval> findMyApproval(Long empNum);
    public List<ApprovalDetail> approvalStatus(int approvalNum, int approvalStatus);
    public List<Integer> includedMe(long empNum);
}
