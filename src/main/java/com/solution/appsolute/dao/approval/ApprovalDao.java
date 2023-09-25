package com.solution.appsolute.dao.approval;

import com.solution.appsolute.dto.approval.Approval;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ApprovalDao {

    public List<Approval> find();
}
