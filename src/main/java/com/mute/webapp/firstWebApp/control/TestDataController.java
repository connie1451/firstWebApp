package com.mute.webapp.firstWebApp.control;

import java.util.UUID;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDataController {
	
	  @GetMapping("/testData")
	    public TestDataBO provideTestData()throws Exception {
	    TestDataBO bo = new TestDataBO();
	    bo.setName(UUID.randomUUID().toString());
	        return bo;
	    }


}
