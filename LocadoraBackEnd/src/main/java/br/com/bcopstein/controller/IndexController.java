package br.com.bcopstein.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;

import springfox.documentation.annotations.ApiIgnore;

@Controller
@ApiIgnore
public class IndexController {

  @CrossOrigin("*")
  @GetMapping("/")
  public String redirectToSwagger() {
    return "redirect:/swagger-ui.html";
  }

}
