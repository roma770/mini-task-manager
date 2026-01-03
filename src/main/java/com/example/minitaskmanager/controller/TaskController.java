package com.example.minitaskmanager.controller;

import com.example.minitaskmanager.model.Task;
import com.example.minitaskmanager.model.User;
import com.example.minitaskmanager.repository.TaskRepository;
import com.example.minitaskmanager.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@CrossOrigin("*")
public class TaskController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TaskRepository taskRepository;

    @PostMapping("/users")
    public User createUser(@RequestBody User user) {
        if (user.getEmail() == null || !user.getEmail().contains("@")) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid email format");
        }
        return userRepository.save(user);
    }

    @GetMapping("/users")
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @PostMapping("/users/{userId}/tasks")
    public Task addTask(@PathVariable Long userId, @RequestBody Task task) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "User not found"));

        if (task.getTitle() == null || task.getTitle().trim().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Title cannot be empty");
        }

        task.setUser(user);
        return taskRepository.save(task);
    }

    @GetMapping("/users/{userId}/tasks")
    public List<Task> getUserTasks(@PathVariable Long userId) {
        return taskRepository.findByUserId(userId);
    }

    @PatchMapping("/tasks/{taskId}/status")
    public Task updateStatus(@PathVariable Long taskId, @RequestBody Map<String, String> payload) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Task not found"));

        try {
            task.setStatus(Task.Status.valueOf(payload.get("status")));
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid status value");
        }

        return taskRepository.save(task);
    }
}