package com.dhansmeier.mycontest.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CompetitionController {

  @GetMapping("/competitions")
  public String competitions(Model model) {
    model.addAttribute("pageTitle", "Competitions");
    return "competitions";
  }
}
