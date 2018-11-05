package com.mute.webapp.firstWebApp.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {

    private static final Logger logger = LoggerFactory.getLogger(UiController.class);
	
    @GetMapping("/testui")
    public String greeting(Model model)throws Exception {
    
    
    	logger.info("testui  -----------------------------------调用了一次");
    	//   model.addAttribute("name", Math.random()+nameA+" "+nameB);
        String name = "testui";
        model.addAttribute("name", name);

        return "mainui";
    }

}
