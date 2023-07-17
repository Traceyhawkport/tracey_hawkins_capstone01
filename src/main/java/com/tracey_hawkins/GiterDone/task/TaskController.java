package com.tracey_hawkins.GiterDone.task;

import com.tracey_hawkins.GiterDone.project.Project;
import com.tracey_hawkins.GiterDone.project.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@RestController
@RequestMapping("api")
public class TaskController {
    @Autowired
    private TaskRepository taskRepository;
    @Autowired
    private ProjectRepository projectRepository;

    @PostMapping("/projects/{id}/tasks")
    public Task addTaskToProject(@PathVariable("id") Long projectId, @RequestBody Task task) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NoSuchElementException("Project not found"));
        task.setProjectId(Optional.ofNullable(project));

        return taskRepository.save(task);
    }
    @GetMapping("task")
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @GetMapping("task/{id}")
    public Task getTaskById(@PathVariable("id") Long taskId) {
        return taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
    }
    @PutMapping("task/{id}")
    public Task updateTask(@PathVariable("id") Long taskId, @RequestBody Task updatedTask) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));

        task.setName(updatedTask.getName());


        return taskRepository.save(task);
    }

    @DeleteMapping("task/{id}")
    public void deleteTask(@PathVariable("id") Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new NoSuchElementException("Task not found"));
        taskRepository.delete(task);
    }
}

