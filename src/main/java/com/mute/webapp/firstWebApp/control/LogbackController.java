package com.mute.webapp.firstWebApp.control;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
public class LogbackController {
	 private static final Logger logger = 
				LoggerFactory.getLogger(LogbackController.class);
	
	 @GetMapping("/logback")
	    public String greeting(@RequestParam(name="a", required=false, defaultValue="本群主") String nameA, Model model)throws Exception {

			logger.debug("testing log debug() is executed, value  is {}", UUID.randomUUID().toString());
			
			logger.error("testing log error", new Exception(UUID.randomUUID().toString()));
		 
	        return "logbackTest";
	    }
	    

}
