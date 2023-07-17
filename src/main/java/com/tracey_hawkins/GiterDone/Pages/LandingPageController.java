package com.tracey_hawkins.GiterDone.Pages;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LandingPageController {
    @GetMapping("/")
    public String showLandingPage(Model model) {
 return "Landingpage";
    }
}
