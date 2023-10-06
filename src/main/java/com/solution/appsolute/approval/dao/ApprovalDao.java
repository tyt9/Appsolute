package com.solution.appsolute.approval.dao;

import com.solution.appsolute.approval.dto.Approval;
import com.solution.appsolute.approval.dto.Basic;
import com.solution.appsolute.approval.dto.Dept;
import com.solution.appsolute.approval.dto.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface ApprovalDao {

    public List<Approval> find();
    public List<Dept> deptList();
    public List<Employee> empList();
    public void insertApp(Basic basic);
}
