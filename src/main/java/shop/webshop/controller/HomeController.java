package shop.webshop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping(value = {"/"})
    public String home() {
        return "redirect:/index.html";
    }

    @GetMapping(value = {"/index.html"})
    public String redirectToHome() {
        return "index";
    }

    @GetMapping(value = {"/shop"})
    public String shop() {
        return "shop";
    }

    @GetMapping(value = {"/product"})
    public String product() {
        return "product";
    }

    @GetMapping(value = {"/contact"})
    public String contact() {
        return "contact";
    }

    @GetMapping(value = {"/about"})
    public String about() {
        return "about";
    }

    @GetMapping(value = {"/cart"})
    public String cart() {
        return "cart";
    }

    @GetMapping(value = {"/checkout"})
    public String checkout() {
        return "checkout";
    }
}
