package com.tracey_hawkins.GiterDone.project;

import com.tracey_hawkins.GiterDone.task.Task;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Calendar;

import com.tracey_hawkins.GiterDone.user.User;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String Name;
    private String description;
    private String startDate;
    private String endDate;
    @ManyToOne
    @JoinColumn(name = "userId",nullable = false)
    private User creator;

}
