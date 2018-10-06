package br.com.supero.tasklist.service;

import br.com.supero.tasklist.model.Task;
import br.com.supero.tasklist.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
public class TaskService {

    private TaskRepository repository;

    @Autowired
    public TaskService(TaskRepository repository) {
        this.repository = repository;
    }

    public void changeState(Long id, Boolean state) {
        Task task = this.repository.findById(id).orElse(null);
        Objects.requireNonNull(task).setState(state);
        this.repository.save(task);
    }
}
