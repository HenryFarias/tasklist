package br.com.supero.tasklist.repository;

import br.com.supero.tasklist.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {


}