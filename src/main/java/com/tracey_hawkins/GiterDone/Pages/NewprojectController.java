package com.tracey_hawkins.GiterDone.Pages;

import com.tracey_hawkins.GiterDone.project.Project;
import com.tracey_hawkins.GiterDone.project.ProjectRepository;
import com.tracey_hawkins.GiterDone.user.User;
import com.tracey_hawkins.GiterDone.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class NewprojectController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    private UserRepository userRepository;
    @GetMapping("/newproject")
    public String showHome(Model model){
        return "newproject";
    }
 @PostMapping("/create")
    public String createProject(@ModelAttribute Project project) {
        System.out.println(project.getDescription());
     UserDetails userPrincipal = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
     String username = userPrincipal.getUsername();
     User user = userRepository.findByUsername(username);
     project.setCreator(user);
     projectRepository.save(project);
return "redirect:/homepage";
 }
 @GetMapping("/deleteproject/{id}")
    public String deleteProject(@PathVariable("id") long id, Model model){
        projectRepository.deleteById(id);
        return "redirect:/homepage";
 }

}
