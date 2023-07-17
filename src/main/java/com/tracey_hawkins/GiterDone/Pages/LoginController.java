package com.tracey_hawkins.GiterDone.Pages;
import com.tracey_hawkins.GiterDone.user.User;
import com.tracey_hawkins.GiterDone.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/login")
    public String showLogin(Model model) {
        return "Login";
    }
    @PostMapping("/login")
    public String ValidateUser(@ModelAttribute("user") User user) {
        System.out.println(user);
       User existingUser = userRepository.findByUsername(user.getUsername());
       if(existingUser != null){
           return "redirect:/homepage";
       }
        return "redirect:/login";
    }
}
