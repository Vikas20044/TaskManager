package com.example.taskmanager.Controller;

import com.example.taskmanager.Model.Task;
import com.example.taskmanager.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }
    @GetMapping("")
    public List<Task> getAllTask(){
        return taskService.getAllTasks();
    }

    @GetMapping("/{taskID}")
    public Task getTaskByID(@PathVariable("taskID") int taskID){
        return taskService.getTaskByID(taskID);
    }

    @PostMapping("")
    public ResponseEntity<Task> addTask(@RequestBody Task task){
        Task created = taskService.addTask(task);
        return new ResponseEntity<>(created , HttpStatus.CREATED);
    }

    @PutMapping("{taskID}")
    public Task updateTask(@PathVariable int taskID, @RequestBody Task task){
        return taskService.updateTask(taskID,task);
    }

    @DeleteMapping("{taskID}")
    public String deleteTask(@PathVariable int taskID){
        return taskService.deleteTask(taskID);
    }

}
