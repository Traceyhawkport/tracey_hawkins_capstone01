package com.tracey_hawkins.GiterDone.Pages;

import com.tracey_hawkins.GiterDone.user.User;
import com.tracey_hawkins.GiterDone.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SignUpController {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @GetMapping("/signup")
    public String showSignUp(Model model) {
        return "SignUp";
    }

    @PostMapping("/signup")
    public String createUser(@ModelAttribute("user") User user) {
user.setPassword(passwordEncoder.encode(user.getPassword()));
userRepository.save(user);
return "redirect:/login";
    }
}

