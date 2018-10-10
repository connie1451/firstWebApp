package com.mute.webapp.firstWebApp.control;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UiController {
	
    @GetMapping("/testui")
    public String greeting(Model model)throws Exception {
    
    
    	
    	//   model.addAttribute("name", Math.random()+nameA+" "+nameB);
        String name = "testui";
        model.addAttribute("name", name);
        return "mainui";
    }

}
