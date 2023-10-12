package com.solution.appsolute;

import com.solution.appsolute.approval.dao.ApprovalDao;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class AppsoluteApplicationTests {

	@Autowired
	private ApprovalDao approvalDao;

	@Test
	void contextLoads() {
		System.out.println(approvalDao.approvalOne(67));
	}

}
