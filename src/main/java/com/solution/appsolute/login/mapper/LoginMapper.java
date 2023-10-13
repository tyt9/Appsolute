package com.solution.appsolute.login.mapper;


import com.solution.appsolute.login.dto.Employee;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {
    public Employee selectByEmp_num(Long emp_num);
}