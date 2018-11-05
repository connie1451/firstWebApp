package com.mute.webapp.firstWebApp.control;

import java.util.UUID;

import com.mute.webapp.firstWebApp.forfun.fighter.MainTester;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDataController {

	private static final Logger logger = LoggerFactory.getLogger(TestDataController.class);
	/**
	 * 测试 产生 testData数据
	 * @return
	 * @throws Exception
	 */
	  @GetMapping("/testData")
	    public TestDataBO provideTestData()throws Exception {

	  	logger.info("testData-------------------------------");
	    TestDataBO bo = new TestDataBO();
	    bo.setName(UUID.randomUUID().toString());
	        return bo;
	    }


	@GetMapping("/testFighter")
	public String greeting(
			@RequestParam(name = "a", required = false, defaultValue = "本群主") String nameA,
			@RequestParam(name = "b", required = false, defaultValue = "特朗普") String nameB,
			Model model)throws Exception {
		//   model.addAttribute("name", Math.random()+nameA+" "+nameB);
		String name = MainTester.testFight(nameA, nameB);

		logger.info("fighter 数据\n" + name);
		String[] split = name.split("<BR/>");
		for (String s : split) {
			System.out.println(s);
		}
		model.addAttribute("fighterData",split);
		model.addAttribute("name", name);
		return "fighter";
	}

}
