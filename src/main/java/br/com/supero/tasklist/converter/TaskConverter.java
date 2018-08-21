package br.com.supero.tasklist.converter;

import br.com.supero.tasklist.Converter;
import br.com.supero.tasklist.model.Task;
import br.com.supero.tasklist.request.TaskRequest;
import org.springframework.stereotype.Component;

@Component
public class TaskConverter implements Converter<TaskRequest, Task> {

    @Override
    public Task encode(TaskRequest request) {
        Task task = new Task();

        task.setId(request.getId());
        task.setDescription(request.getDescription());
        task.setState(request.getState());
        task.setTitle(request.getTitle());

        return task;
    }

    @Override
    public TaskRequest decode(Task task) {
        return null;
    }
}
