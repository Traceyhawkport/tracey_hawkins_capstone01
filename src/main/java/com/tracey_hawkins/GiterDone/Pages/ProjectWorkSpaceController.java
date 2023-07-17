package com.tracey_hawkins.GiterDone.Pages;

import com.tracey_hawkins.GiterDone.project.Project;
import com.tracey_hawkins.GiterDone.project.ProjectRepository;
import com.tracey_hawkins.GiterDone.task.Task;
import com.tracey_hawkins.GiterDone.task.TaskRepository;
import com.tracey_hawkins.GiterDone.user.User;
import com.tracey_hawkins.GiterDone.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
public class ProjectWorkSpaceController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @GetMapping("/projectworkspace/{id}")
    public String showHome(@PathVariable("id") Long projectId, Model model) {
        Optional<Project> project = projectRepository.findById(projectId);
        List<Task> tasks = taskRepository.findByProjectId(project.get());
        model.addAttribute("project", project.get());
        model.addAttribute("tasks", tasks);
        return "projectworkspace";
    }


    @PostMapping("/create/{id}")
    public String createTask(@RequestBody String taskText, @PathVariable("id") long projectId, Model model) {
        System.out.println("----------------->"+taskText);
        Optional<Project> project = projectRepository.findById(projectId);
        Task task = new Task(taskText, project.get());
        task.setName(taskText);
        task.setProjectId(project);
        taskRepository.save(task);
        return "redirect:/projectworkspace/{id}";
    }


    }

