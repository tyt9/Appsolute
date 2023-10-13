package com.solution.appsolute.admin.controller;

import com.solution.appsolute.admin.dao.repository.AdminEmployeeRepository;
import com.solution.appsolute.admin.dto.DeptDto;
import com.solution.appsolute.admin.dto.PageRequestDto;
import com.solution.appsolute.admin.service.AdminDeptService;
import com.solution.appsolute.admin.service.AdminEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequiredArgsConstructor
@RequestMapping("/admin/dept")
public class AdminDeptController {

    @Autowired
    AdminEmployeeService adminEmployeeService;

    @Autowired
    AdminDeptService adminDeptService;

    @Autowired
    AdminEmployeeRepository adminEmployeeRepository;

    //dept목록 보이기
    @RequestMapping(value="/deptList" , method = RequestMethod.GET)
    public void deptList(PageRequestDto pageRequestDto, Model model) {
        model.addAttribute("deptList", adminDeptService.getDeptList(pageRequestDto));

    }

    //dept 등록하기
    @RequestMapping(value = "/deptRegister", method=RequestMethod.GET)
    public void deptRegister() {

    }

    //redirect로 페이지 처리 이휴에 목록페이지로 이동하기
    @RequestMapping(value = "/deptRegister", method=RequestMethod.POST)
    public String deptRegisterPost(DeptDto deptDto) {
        adminDeptService.registerDept(deptDto);
        return "redirect:/admin/dept/deptList";
    }
    @RequestMapping(value="/deptInfo/{deptNo}", method=RequestMethod.GET)
    public String deptInfo(@PathVariable long deptNo, Model model, PageRequestDto pageRequestDto) {
        DeptDto deptDto = adminDeptService.readDept(deptNo);
        Long count = adminEmployeeRepository.countEmployeeByDeptNo(deptNo);
        model.addAttribute("count", count);
        model.addAttribute("empListInDeptNo", adminEmployeeService.getEmployeeListByDeptNo(pageRequestDto, deptNo));
        model.addAttribute("deptInfo", deptDto);
        return "admin/dept/deptInfo";
    }

    @RequestMapping(value="/deptInfoModify/{deptNo}", method=RequestMethod.GET)
    public String deptInfoModify(@PathVariable Long deptNo, Model model) {
        DeptDto deptDto = adminDeptService.readDept(deptNo);
        model.addAttribute("deptInfo", deptDto);
        return "admin/dept/deptInfoModify";
    }

    @RequestMapping(value="/deptInfoModify/{deptNo}", method=RequestMethod.POST)
    @Transactional(readOnly=false)
    public String deptInfoModifyPost(DeptDto deptDto, RedirectAttributes redirectAttributes) {
        adminDeptService.modifyDept(deptDto);
        redirectAttributes.addAttribute("deptNo", deptDto.getDeptNo());
        return "redirect:/admin/dept/deptInfo/" + deptDto.getDeptNo();
    }
    @RequestMapping(value="/deleteDept",  method=RequestMethod.POST)
    public String deleteDept(Long deptNo) {
        adminDeptService.removeDept(deptNo);
        return "redirect:/admin/dept/deptList";
    }



}

