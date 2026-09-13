package com.example.taskmanager.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Task {
    @Id
    private int taskID;
    private String taskName;
    private String description;
    private boolean taskStatus;

    public Task(int taskID, String taskName, String description, boolean taskStatus) {
        this.taskID = taskID;
        this.taskName = taskName;
        this.description = description;
        this.taskStatus = taskStatus;
    }

    public void setTaskID(int taskID) {
        this.taskID = taskID;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }


    public boolean isTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(boolean taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Task() {
    }

    public int getTaskID() {
        return taskID;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getDescription() {
        return description;
    }


}
