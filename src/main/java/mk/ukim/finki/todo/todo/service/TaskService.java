package mk.ukim.finki.todo.todo.service;

import mk.ukim.finki.todo.todo.model.Task;
import mk.ukim.finki.todo.todo.repository.TaskRepository;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@EnableCaching
public class TaskService {
    private final TaskRepository repo;
    public TaskService(TaskRepository repo) { this.repo = repo; }


    public List<Task> listAll(){ return repo.findAll(); }


    public Task save(String title, String description, LocalDate date){
        return repo.save(new Task(title,description,date)); }

    public Task completed(Long id) {
        Task t= repo.findById(id).orElse(null);
        t.setCompleted(true);
        return repo.save(t);
    }
     public Task delete(Long id) {
            Task t= repo.findById(id).orElse(null);
            repo.delete(t);
            return t;
        }

    public Task findById(Long id) {
        return repo.findById(id).orElse(null);
    }
}