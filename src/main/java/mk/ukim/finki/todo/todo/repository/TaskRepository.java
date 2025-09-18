package mk.ukim.finki.todo.todo.repository;

import mk.ukim.finki.todo.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {}

