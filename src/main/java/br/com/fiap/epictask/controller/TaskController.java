package br.com.fiap.epictask.controller;

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class TaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping(value = "/task")
    public ModelAndView index() {
        ModelAndView modelAndView = new ModelAndView("tasks");
        List<Task> tasks = taskRepository.findAll();
        modelAndView.addObject("tasks", tasks);
        return modelAndView;
    }

    @RequestMapping(value = "/task/new")
    public String create(Task task) {
        return "task-form";
    }

    @PostMapping(value = "/task")
    public String save(@Valid Task task, BindingResult result) {
        if (result.hasErrors())
            return "task-form";
        taskRepository.save(task);
        System.out.println("Salvando tarefa..." + task);
        return "tasks";
    }
}
