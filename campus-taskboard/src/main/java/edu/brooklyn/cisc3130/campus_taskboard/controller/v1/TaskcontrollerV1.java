package edu.brooklyn.cisc3130.campus_taskboard.controller.v1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskControllerV1 {

    @GetMapping("/api/v1/tasks")
    public String getTasks() {
        return "Version 1 Tasks Endpoint";
    }
}