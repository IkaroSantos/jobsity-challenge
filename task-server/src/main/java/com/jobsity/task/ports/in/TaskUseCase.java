package com.jobsity.task.ports.in;

import com.jobsity.task.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskUseCase {
    List<Task> getAllTasks();
    Task createTask(Task task);
    Task updateTask(Task taskToBeUpdated);
    void deleteTask(String id);
    Optional<Task> getTaskById(String id);
}
