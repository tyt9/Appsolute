package com.solution.appsolute.approval.dao;

import com.solution.appsolute.approval.dto.Approval;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalDao {

    public List<Approval> find();
}
