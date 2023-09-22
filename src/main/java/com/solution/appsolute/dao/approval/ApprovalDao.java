package com.solution.appsolute.dao.approval;

import com.solution.appsolute.dto.approval.Data;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ApprovalDao {

    public Data find(Long id);
}
