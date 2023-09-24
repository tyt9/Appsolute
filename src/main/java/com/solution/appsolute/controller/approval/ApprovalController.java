package com.solution.appsolute.controller.approval;

import com.solution.appsolute.dao.approval.ApprovalDao;
import com.solution.appsolute.repository.DataEntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Transactional
@RequestMapping("/approval")
public class ApprovalController {

    @Autowired
    DataEntityManager entityManager;

//    @Autowired
//    EntityManager entityManager;


//    @PostConstruct
//    public void init(){
//        Dept dept1 = Dept.builder()
//                .deptNo(1L)
//                .deptName("HR Department")
//                .deptLoc("New York")
//                .deptBranch(0)
//                .build();
//        entityManager.insert(dept1);
//
//
//
//        // 직원 데이터 초기화
//        Employee employee1 = Employee.builder()
//                .empName("John Doe")
//                .deptNo(dept1.getDeptNo())
//                .empPhone("010-1234-1234")
//                .empEmail("john@example.com")
//                .empPassword("password123")
//                .empHireDate(new Date())
//                .empPosition("Manager")
//                .empLeader(0)
//                .build();
//        entityManager.insert(employee1);
//
//
//        // 나머지 데이터 초기화도 유사하게 수행
//
//        // 문서 데이터 초기화
//        Document document1 = Document.builder()
//                .documentName("Document 1")
//                .build();
//        long documentKey = entityManager.insert(document1);
//
//        // 문서 상세 데이터 초기화
//        DocumentDetail documentDetail1 = DocumentDetail.builder()
//                .documentNum(documentKey)
//                .fieldName("Field 1")
//                .sequence(1)
//                .format(1)
//                .build();
//        entityManager.insert(documentDetail1);

//        ApprovalContentDetail approvalContentDetail1 = ApprovalContentDetail.builder()
//                .approvalNum()
//                .build();
//
//        // 승인 내용 상세 데이터 초기화
//        ApprovalContentDetail approvalContentDetail1 = new ApprovalContentDetailBuilder()
//                .withApprovalnum(1L)
//                .withDocumentnum(1L)
//                .withKey1("Key 1")
//                .withValue1("Value 1")
//                // 나머지 승인 내용 상세 데이터 초기화도 유사하게 수행
//                .build();
//        approvalContentDetailRepository.save(approvalContentDetail1);
//    }

    @Autowired
    private ApprovalDao approvalDao;

    @Transactional
    @GetMapping("/purchase")
    public void purchase(Model model){
        approvalDao.find();
    }



}
