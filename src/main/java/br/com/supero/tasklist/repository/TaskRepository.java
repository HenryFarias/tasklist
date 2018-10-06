package br.com.supero.tasklist.repository;

import br.com.supero.tasklist.model.Task;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(collectionResourceRel = "tasks", path = "task") // path = end-point na aplicação
public interface TaskRepository extends PagingAndSortingRepository<Task, Long> {

}