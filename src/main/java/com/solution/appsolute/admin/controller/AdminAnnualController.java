package com.solution.appsolute.admin.controller;

import com.solution.appsolute.admin.dao.repository.AdminEmployeeRepository;
import com.solution.appsolute.admin.dto.EmployeeDto;
import com.solution.appsolute.admin.dto.PageRequestDto;
import com.solution.appsolute.admin.service.AdminEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@Controller
@RequiredArgsConstructor
@RequestMapping("admin/annual")
public class AdminAnnualController {

    @Autowired
    AdminEmployeeRepository adminEmployeeRepository;

    @Autowired
    AdminEmployeeService adminEmployeeService;

    @GetMapping("/annualList")
    public String annualList(PageRequestDto pageRequestDto, Model model) {
        model.addAttribute("annualList", adminEmployeeService.getEmployeeList(pageRequestDto));
        return "/admin/annual/annualList";
    }

    @ResponseBody
    @PostMapping("/annualUpdate")
    public void annualUpdate(@RequestBody List<Long> empNums) {
        adminEmployeeService.updateEmpAnnualByEmpNums(empNums);
    }

}
