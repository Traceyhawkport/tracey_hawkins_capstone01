package com.tracey_hawkins.GiterDone.Pages;

import com.tracey_hawkins.GiterDone.project.Project;
import com.tracey_hawkins.GiterDone.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomePageController {
    @Autowired
    private ProjectRepository projectRepository;
    @GetMapping("/homepage")
    public String showHome(Model model){
        UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        String username = userPrincipal.getUsername();
        List<Project> projects = projectRepository.findByCreatorUsername(username);
        model.addAttribute("projects",projects);
        return "Homepage";
    }
}
