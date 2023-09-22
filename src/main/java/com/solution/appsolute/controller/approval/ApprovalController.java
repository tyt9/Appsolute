package com.solution.appsolute.controller.approval;

import com.solution.appsolute.dto.approval.Data;
import com.solution.appsolute.repository.DataEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.EntityManager;

@Controller
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    EntityManager entityManager;

    @Transactional
    @GetMapping("/purchase")
    public void purchase(Model model){
        Data data = Data.builder().name("상품명").plan("계획").concept("컨셉").customerStatus("고객상태")
                .materialCost(10000).laborCost(20000).productionCost(30000).competitorComparison("타사비교")
                .developmentSchedule("개발계획").salesPoint("세일즈포인트").build();
        entityManager.persist(data);

    }


}
