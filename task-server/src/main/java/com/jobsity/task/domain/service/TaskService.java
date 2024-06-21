package com.jobsity.task.domain.service;

import com.jobsity.task.domain.model.Task;
import com.jobsity.task.ports.in.TaskUseCase;
import com.jobsity.task.ports.out.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements TaskUseCase {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Task createTask(Task task) {
        return taskRepository.save(task);
    }

    public Task updateTask(Task taskToBeUpdated) {
        return taskRepository.save(taskToBeUpdated);
    }

    public void deleteTask(String id) {
        taskRepository.deleteById(id);
    }

    public Optional<Task> getTaskById(String id) {
        return taskRepository.findById(id);
    }
}
