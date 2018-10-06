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

    @PatchMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void changeState(@PathVariable Long id, @RequestBody @Valid TaskChangeStateRequest request) {
        this.service.changeState(id, request.getState());
    }
}
