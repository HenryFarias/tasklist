package br.com.supero.tasklist.controller;

import br.com.supero.tasklist.Converter;
import br.com.supero.tasklist.model.Task;
import br.com.supero.tasklist.request.TaskChangeStateRequest;
import br.com.supero.tasklist.request.TaskRequest;
import br.com.supero.tasklist.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(path = "/task")
public class TaskController {

    private final Converter<TaskRequest, Task> converter;
    private final TaskService service;

    @Autowired
    public TaskController(Converter<TaskRequest, Task> converter, TaskService service) {
        this.converter = converter;
        this.service = service;
    }

    @PostMapping()
    @ResponseStatus(HttpStatus.CREATED)
    public void save(@RequestBody @Valid TaskRequest request) {
        this.service.save(this.converter.encode(request));
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable Long id, @RequestBody @Valid TaskRequest request) {
        request.setId(id);
        this.service.save(this.converter.encode(request));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable Long id) {
        this.service.delete(id);
    }

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void changeState(@PathVariable Long id, @RequestBody @Valid TaskChangeStateRequest request) {
        this.service.changeState(id, request.getState());
    }

    @GetMapping()
    @ResponseStatus(HttpStatus.OK)
    public List<Task> list() {
        return this.service.findAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Task find(@PathVariable Long id) {
        return this.service.findById(id);
    }
}
