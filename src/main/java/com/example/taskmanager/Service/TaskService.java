package com.example.taskmanager.Service;

import com.example.taskmanager.Model.Task;
import com.example.taskmanager.Repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks(){
        return taskRepository.findAll();
    }

    public Task getTaskByID(int taskID){
        return taskRepository.findById(taskID).orElse(new Task());
    }

    public Task addTask(Task task){
        return taskRepository.save(task);
    }

    public Task updateTask(int taskID,Task task){
        if(taskRepository.existsById(taskID)){
            task.setTaskID(taskID);
            return taskRepository.save(task);
        }
        return new Task();
    }

    public String deleteTask(int taskID){
        if(taskRepository.existsById(taskID)){
            taskRepository.deleteById(taskID);
            return "Task removed successfully";
        }
        return "Task not found";
    }


}
