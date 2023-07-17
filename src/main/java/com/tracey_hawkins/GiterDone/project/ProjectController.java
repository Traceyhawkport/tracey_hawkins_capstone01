package com.tracey_hawkins.GiterDone.project;

import com.tracey_hawkins.GiterDone.user.User;
import com.tracey_hawkins.GiterDone.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping ("api/")
public class ProjectController {
    @Autowired
    private ProjectRepository projectRepository;
    @Autowired
    UserRepository userRepository;
    @PostMapping("project/{userId}")
    public Project createProject(@PathVariable("userId")Long userId,@RequestBody Project project) {
        User user = userRepository.findById(userId).orElseThrow(() -> new NoSuchElementException());
        project.setCreator(user);
        return projectRepository.save(project);
    }
    @GetMapping("project")
    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    @GetMapping("project/{id}")
    public Project getProjectById(@PathVariable("id") Long projectId) {
        return projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
    }

    @PutMapping("project/{id}")
    public Project updateProject(@PathVariable("id")Long projectId, @RequestBody Project updatedProject) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        project.setName(updatedProject.getName());

        return projectRepository.save(project);
    }
    @DeleteMapping("project/{id}")
    public void deleteProject(@PathVariable("id") Long projectId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new NoSuchElementException());
        projectRepository.delete(project);
    }
}
