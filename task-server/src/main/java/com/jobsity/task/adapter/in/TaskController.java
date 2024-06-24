package com.jobsity.task.adapter.in;

import com.jobsity.task.domain.model.Task;
import com.jobsity.task.ports.in.TaskUseCase;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/tasks")
public class TaskController {

    private final TaskUseCase taskUseCase;

    public TaskController(TaskUseCase taskUseCase) {
        this.taskUseCase = taskUseCase;
    }

    @GetMapping
    public List<Task> getAllTasks() {
        return taskUseCase.getAllTasks();
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@RequestBody Task task) {
        return ResponseEntity.ok(taskUseCase.createTask(task));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable String id, @RequestBody Task task) {
        Optional<Task> optTask = taskUseCase.getTaskById(id);
        if (optTask.isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        Task taskToBeUpdated = optTask.get();
        taskToBeUpdated.setTitle(task.getTitle());
        taskToBeUpdated.setCompleted(task.isCompleted());
        Task updatedTask = taskUseCase.updateTask(taskToBeUpdated);
        return ResponseEntity.ok(updatedTask);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTask(@PathVariable String id) {
        if (taskUseCase.getTaskById(id).isEmpty()) {
            return ResponseEntity.notFound().build();
        }
        taskUseCase.deleteTask(id);
        return ResponseEntity.noContent().build();
    }
}
