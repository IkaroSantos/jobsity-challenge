package com.jobsity.task.ports.out;

import com.jobsity.task.domain.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskRepository {
    List<Task> findAll();
    Optional<Task> findById(String id);
    Task save(Task task);
    void deleteById(String id);
}
