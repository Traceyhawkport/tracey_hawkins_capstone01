package com.tracey_hawkins.GiterDone.task;

import com.tracey_hawkins.GiterDone.project.Project;
import lombok.Data;

import javax.persistence.*;
import java.util.Optional;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @ManyToOne
    @JoinColumn(name = "projectId",nullable = false)
    private Project projectId;

    public Task(){}

    public Task(String taskText, Project project) {
        this.name = taskText;
        this.projectId = project;
    }


    public void setProject(Project project) {
    }

    public void add(Task task) {
    }


    public void setProjectId(Optional<Project> project) {
    }
}
