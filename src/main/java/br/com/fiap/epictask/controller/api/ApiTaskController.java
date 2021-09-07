package br.com.fiap.epictask.controller.api;

import br.com.fiap.epictask.model.Task;
import br.com.fiap.epictask.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/api/task")
public class ApiTaskController {

    @Autowired
    private TaskRepository taskRepository;

    @GetMapping()
    @Cacheable("tasks")
    public Page<Task> index(@RequestParam(required = false) String title,
                            @PageableDefault Pageable pageable) {
        if (title == null) {
            return taskRepository.findAll(pageable);
        }
        return taskRepository.findByTitleContains(title, pageable);
    }

    @PostMapping()
    @CacheEvict(value = "tasks", allEntries = true)
    public ResponseEntity<Task> create(@Valid @RequestBody Task task, UriComponentsBuilder componentsBuilder) {
        taskRepository.save(task);
        URI uri = componentsBuilder.
                path("api/task/{id}")
                .buildAndExpand(task.getId())
                .toUri();
        return ResponseEntity.created(uri).body(task);
    }

    @GetMapping(value = "{id}")
    public ResponseEntity<Task> show(@PathVariable Long id) {
        return ResponseEntity.of(taskRepository.findById(id));

    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "tasks", allEntries = true)
    public ResponseEntity<Task> destroy(@PathVariable Long id) {
        Optional<Task> task = taskRepository.findById(id);

        if (task.isEmpty())
            return ResponseEntity.notFound().build();

        taskRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @PutMapping("{id}")
    public ResponseEntity<Task> update(@PathVariable Long id,
                                       @RequestBody Task newTask) {

        Optional<Task> optionalTask = taskRepository.findById(id);
        if (optionalTask.isEmpty())
                return ResponseEntity.notFound().build();

        Task task = optionalTask.get();
        task.setTitle(newTask.getTitle());
        task.setDescription(newTask.getDescription());
        task.setPoints(newTask.getPoints());

        taskRepository.save(task);

        return ResponseEntity.ok(task);
    }


}
