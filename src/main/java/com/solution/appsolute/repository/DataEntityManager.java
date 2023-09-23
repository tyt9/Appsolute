package com.solution.appsolute.repository;

import com.solution.appsolute.entity.*;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository

public class DataEntityManager {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Long insert(Approval approval) {
        entityManager.persist(approval);
        return approval.getApprovalNum();
    }

    @Transactional
    public Long insert(ApprovalDetail approvalDetail) {
        entityManager.persist(approvalDetail);
        return approvalDetail.getApprovalDetailNum();
    }
    @Transactional
    public Long insert(ApprovalLine approvalLine) {
        entityManager.persist(approvalLine);
        return approvalLine.getLineNum();
    }
    @Transactional
    public Long insert(ApprovalLineDetail approvalLineDetail) {
        entityManager.persist(approvalLineDetail);
        return approvalLineDetail.getLineDetailNum();
    }
    @Transactional
    public void insert(ApprovalContentDetail approvalContentDetail) {
        entityManager.persist(approvalContentDetail);
    }
    @Transactional
    public Long insert(Document document) {
        entityManager.persist(document);
        System.out.println(document.getDocumentNum());
        return document.getDocumentNum();
    }
    @Transactional
    public void insert(DocumentDetail documentDetail) {
        entityManager.persist(documentDetail);
    }
    @Transactional
    public Long insert(Employee employee) {
        entityManager.merge(employee);
        return employee.getEmpNum();
    }
    @Transactional
    public void insert(Dept dept) {
        entityManager.merge(dept);
    }



//    @Transactional
//    @PostConstruct
//    public void init(){
//        Dept dept1 = Dept.builder()
//                .deptNo(1L)
//                .deptName("HR Department")
//                .deptLoc("New York")
//                .deptBranch(0)
//                .build();
//        entityManager.persist(dept1);
//
//        // 직원 데이터 초기화
//        Employee employee1 = Employee.builder()
//                .empNum(1L)
//                .empName("John Doe")
//                .deptNo(1L)
//                .empPhone("010-1234-1234")
//                .empEmail("john@example.com")
//                .empPassword("password123")
//                .empHireDate(LocalDateTime.now())
//                .empPosition("Manager")
//                .empLeader(0)
//                .build();
//        entityManager.persist(employee1);
//
//
//        // 나머지 데이터 초기화도 유사하게 수행
//
//        // 문서 데이터 초기화
//        Document document1 = new DocumentBuilder()
//                .withDocumentnum(1L)
//                .withDocumentname("Document 1")
//                .build();
//        documentRepository.save(document1);
//
//        // 문서 상세 데이터 초기화
//        DocumentDetail documentDetail1 = new DocumentDetailBuilder()
//                .withDocumentnum(1L)
//                .withFieldname("Field 1")
//                .withSequence(1)
//                .withFormat(0)
//                .build();
//        documentDetailRepository.save(documentDetail1);
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
//
//    @Transactional
//    public Data findById(Long id) {
//        Data data = entityManager.find(Data.class, id);
//        return data;
//    }
//
//    @Transactional
//    public void insert(Data data) {
//        entityManager.persist(data);
//    }

}
