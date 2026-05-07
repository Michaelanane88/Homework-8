package edu.brooklyn.cisc3130.campus_taskboard.dto;

import edu.brooklyn.cisc3130.campus_taskboard.model.Task;

import java.time.LocalDateTime;

public class TaskResponse {

    private Integer id;
    private String title;
    private String description;
    private Boolean completed;
    private String priority;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public static TaskResponse fromEntity(Task task) {
        TaskResponse response = new TaskResponse();
        response.id = task.getId();
        response.title = task.getTitle();
        response.description = task.getDescription();
        response.completed = task.getCompleted();
        response.priority = task.getPriority().name();
        response.createdAt = task.getCreatedAt();
        response.updatedAt = task.getUpdatedAt();
        return response;
    }

    public Integer getId() { return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public Boolean getCompleted() { return completed; }
    public String getPriority() { return priority; }
    public LocalDateTime getCreatedAt() { return createdAt; }
    public LocalDateTime getUpdatedAt() { return updatedAt; }
}