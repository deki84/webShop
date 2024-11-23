package shop.webshop.controller;

import ch.qos.logback.core.model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

   @GetMapping("/")
    public String home() {
      return "index";
    }
    @GetMapping("/index.html")
    public String redirectToHome() {
        return "redirect:/";
    }

}
