package com.solution.appsolute.admin.controller;

import com.solution.appsolute.admin.dao.repository.AdminEmployee;
import com.solution.appsolute.admin.dao.repository.AdminEmployeeRepository;
import com.solution.appsolute.admin.dto.EmployeeDto;
import com.solution.appsolute.admin.dto.PageRequestDto;
import com.solution.appsolute.admin.dto.PageResultDto;
import com.solution.appsolute.admin.service.AdminEmployeeService;
import com.solution.appsolute.entity.Employee;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;


@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/employee")
public class AdminEmployeeController {

    @Autowired
    AdminEmployee adminEmployee;

    @Autowired
    AdminEmployeeRepository adminEmployeeRepository;


    @Autowired
    AdminEmployeeService adminEmployeeService;

    //관리자 화면
    @GetMapping
    public String adminPage() {
        return "/admin/employee/adminPage";
    }

    //회원가입
    @RequestMapping(value="/register", method=RequestMethod.GET)
    public String registerEmployee(Model model) {
        model.addAttribute("deptNameList", adminEmployee.getDeptNoAndDeptName());
        return "/admin/employee/registerEmployee";
    }

    //회원가입 & 부서 변경 시 사용
    @GetMapping("/getTeamLeaders")
    @ResponseBody
    public List<Object[]> getTeamLeaders(@RequestParam("deptNo") Long deptNo) {
        List<Object[]> teamLeaders = adminEmployeeRepository.findTeamLeadersByDept(deptNo);
        return teamLeaders;
    }
    @GetMapping("/getMgr")
    @ResponseBody
    public List<Object[]> getMgr(@RequestParam("deptNo")Long deptNo) {
        List<Object[]> getMgr = adminEmployeeRepository.findMgrByDeptNo(deptNo);
        return getMgr;
    }

    @RequestMapping(value="/register", method=RequestMethod.POST)
    public String registerEmployee(EmployeeDto employeeDto) {
        adminEmployeeService.registerEmployee(employeeDto);
        return "redirect:/admin/employee/employeeList";
    }



    //리스트
    @RequestMapping(value="/employeeList", method = RequestMethod.GET)
    public String employeeList(PageRequestDto pageRequestDto, Model model) {
        if ("empHireDate".equals(pageRequestDto.getType())) {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate localDate = LocalDate.parse(pageRequestDto.getKeyword(), formatter);
            pageRequestDto.setKeyword(localDate.format(formatter));
        }
        model.addAttribute("employeeList", adminEmployeeService.getEmployeeList(pageRequestDto));
        return "/admin/employee/employeeList";
    }


    //사원별 정보

    @RequestMapping(value = "/employeeInfo/{empNum}", method = RequestMethod.GET)
    public String employeeInfo(@PathVariable long empNum, Model model) {
        EmployeeDto employeeDto = adminEmployeeService.readEmployee(empNum);
        model.addAttribute("employeeInfo", employeeDto);
        return "admin/employee/employeeInfo";
    }

    //사원정보 수정

    @RequestMapping(value="/employeeInfoModify/{empNum}", method=RequestMethod.GET)
    public String employeeInfoModify(@PathVariable Long empNum, Model model) {
        EmployeeDto employeeDto = adminEmployeeService.readEmployee(empNum);
        model.addAttribute("employeeInfo", employeeDto);
        return "admin/employee/employeeInfoModify";
    }

    //info로 안넘어가는 문제 해결해야 함 2023.09.27
    @RequestMapping(value="/employeeInfoModify/{empNum}", method=RequestMethod.POST)
    @Transactional(readOnly=false)
    public String employeeInfoModifyPost(EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        adminEmployeeService.modifyEmployee(employeeDto);
        redirectAttributes.addAttribute("empNum", employeeDto.getEmpNum());
        return "redirect:/admin/employee/employeeInfo/" + employeeDto.getEmpNum();
    }

    //부서 변경
    @RequestMapping(value="/employeeDeptPositionUpdate/{empNum}", method = RequestMethod.GET)
    public String employeeDeptList(@PathVariable Long empNum, Model model) {
        EmployeeDto employeeDto = adminEmployeeService.readEmployee(empNum);
        model.addAttribute("employeeInfo", employeeDto);
        model.addAttribute("deptNameList", adminEmployee.getDeptNoAndDeptName());
        return "admin/employee/employeeDeptPositionUpdate";
    }

    //info로 안넘어가는 문제 해결해야 함 2023.09.27
    @RequestMapping(value = "/employeeDeptPositionUpdate/{empNum}", method=RequestMethod.POST)
    @Transactional(readOnly = false)
    public String employeeDeptModify(EmployeeDto employeeDto, RedirectAttributes redirectAttributes) {
        adminEmployeeService.modifyEmployeeDept(employeeDto);
        redirectAttributes.addAttribute("empNum", employeeDto.getEmpNum());
        return "redirect:/admin/employee/employeeInfo/" + employeeDto.getEmpNum();

    }

    //사원 삭제(퇴사)
    @RequestMapping(value="/employeeResign", method=RequestMethod.POST)
    public String employeeResign(Long empNum) {
        adminEmployeeService.removeEmployee(empNum);
        return "redirect:/admin/employee/employeeList";
    }











}