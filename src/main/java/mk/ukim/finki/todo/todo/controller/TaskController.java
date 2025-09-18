package mk.ukim.finki.todo.todo.controller;

import mk.ukim.finki.todo.todo.model.Task;
import mk.ukim.finki.todo.todo.service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@Controller
@RequestMapping("/tasks")
public class TaskController {
    private final TaskService service;
    public TaskController(TaskService service) { this.service = service; }

    @GetMapping
    public String list(Model model){
        model.addAttribute("tasks", service.listAll());
        return "list";
    }

    @GetMapping("/new")
    public String createForm(){
        return "form";
    }

    @PostMapping("/save")
    public String save(@RequestParam String title,
                       @RequestParam String description,
                       @RequestParam LocalDate date){
        service.save(title,description, date);
        return "redirect:/tasks";
    }


    @GetMapping("/completed/{id}")
    public String completed(@PathVariable Long id){
        service.completed(id);
        return "redirect:/tasks";
    }
}
