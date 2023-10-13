package com.solution.appsolute.admin.dao.repository;

import com.querydsl.core.BooleanBuilder;
import com.solution.appsolute.entity.Employee;
import org.apache.ibatis.annotations.Param;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface AdminEmployeeRepository extends JpaRepository<Employee, Long>, QuerydslPredicateExecutor<Employee> {
    @Query("SELECT e FROM Employee e WHERE e.empNum = :empNum")
    Employee findByEmpNum(@Param("empNum") Long empNum);


    @Query("SELECT e.empNum, e.empName FROM Employee e WHERE e.deptNo = :deptNo AND e.empPosition = '팀장'")
    List<Object[]> findTeamLeadersByDept(@Param("deptNo") Long deptNo);

    @Query("SELECT e.empNum, e.empName FROM Employee e WHERE e.deptNo = :deptNo")
    List<Object[]> findMgrByDeptNo(@Param("deptNo") Long deptNo);

    @Query("SELECT e FROM Employee e WHERE e.deptNo = :deptNo")
    Page<Employee> findAllByDeptNo(@Param("deptNo") long deptNo, Pageable pageable);

    @Query("select count(e) from Employee e where e.deptNo =:deptNo")
    Long countEmployeeByDeptNo(@Param("deptNo") Long deptNo);

    @Query("SELECT e.empNum, e.empName FROM Employee e WHERE e.deptNo = :deptNo")
    List<Object[]> findEmployeesByDeptNo(@Param("deptNo") Long deptNo);

    @Modifying
    @Transactional
    @Query("UPDATE Employee e " +
            "SET e.empAnnual = CASE " +
            "WHEN (DATEDIFF(CURRENT_DATE, e.empHireDate) < 30) THEN e.empAnnual " +
            "WHEN (DATEDIFF(CURRENT_DATE, e.empHireDate) >= 30 AND DATEDIFF(CURRENT_DATE, e.empHireDate) < 365) THEN (e.empAnnual + 1) " +
            "ELSE CASE " +
            "WHEN (DATEDIFF(CURRENT_DATE, e.empHireDate) < 730) THEN 15 " +
            "ELSE (15 + FLOOR((DATEDIFF(CURRENT_DATE, e.empHireDate) - 365) / 730)) " +
            "END END " +
            "WHERE e.empNum = :empNum")
    void updateEmpAnnualByEmpNum(@Param("empNum") Long empNum);
}
