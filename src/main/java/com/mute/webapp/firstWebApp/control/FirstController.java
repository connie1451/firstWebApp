package com.mute.webapp.firstWebApp.control;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mute.webapp.firstWebApp.forfun.fighter.MainTester;

@Controller
public class FirstController {

  private static final Logger logger = LoggerFactory.getLogger(FirstController.class);

  /**
   * 对战接口
   *
   * @param nameA
   * @param nameB
   * @param model
   * @return
   * @throws Exception
   */
  @GetMapping("/fighter")
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
