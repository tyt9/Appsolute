package com.solution.appsolute.controller.approval;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @GetMapping("/purchase")
    public void purchase(){
    }
}
