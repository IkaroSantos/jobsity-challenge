package com.jobsity.task.adapter.out;

import com.jobsity.task.domain.model.Task;
import com.jobsity.task.ports.out.TaskRepository;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Repository
public class TaskRepositoryImpl implements TaskRepository {

    private final MongoTemplate mongoTemplate;

    public TaskRepositoryImpl(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Task> findAll() {
        return mongoTemplate.findAll(Task.class);
    }

    @Override
    public Task save(Task task) {
        return mongoTemplate.save(task);
    }

    @Override
    public void deleteById(String id) {
        mongoTemplate.remove(Objects.requireNonNull(mongoTemplate.findById(id, Task.class)));
    }

    @Override
    public Optional<Task> findById(String id) {
        return Optional.ofNullable(mongoTemplate.findById(id, Task.class));
    }
}
