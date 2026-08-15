package io.github.ericlps.listadetarefas.controller;

import io.github.ericlps.listadetarefas.entity.Task;
import io.github.ericlps.listadetarefas.service.TaskService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/tasks")
@Tag(name = "Tasks", description = "Endpoints for task management")
@AllArgsConstructor
public class TarefaController {

    private TaskService taskService;

    @PostMapping
    @Operation(summary = "Create a new Task",description = "Receives title, description, and status to record in the database.")
    public ResponseEntity<Task> save(@Valid @RequestBody Task task){

        return ResponseEntity.status(HttpStatus.CREATED).body(taskService.saveTask(task));

    }

    @GetMapping
    @Operation(summary = "List all tasks(Paged)", description = "Return a list of tasks, allowing for sorting and pagination")
    public ResponseEntity<Page<Task>> listPage(
            @PageableDefault(size = 10, page = 0, sort = "dataCriacao")Pageable pageable){

        Page<Task> tarefas = taskService.listPage(pageable);
        return ResponseEntity.ok(tarefas);

    }

    @GetMapping("/{id}")
    @Operation(summary = "Return a Task (ID)", description = "Return a task by ID")
    public ResponseEntity<Task> list(@PathVariable("id") UUID id){

        return ResponseEntity.ok(taskService.listById(id));

    }

    @PutMapping("/{id}")
    @Operation(summary = "Update an existing task (ID)", description = "Updates an existing task, allowing the title, description, and status to be updated")
    public ResponseEntity<Task> update(@PathVariable("id") UUID id, @RequestBody Task task){

        return ResponseEntity.ok(taskService.updateTask(id, task));

    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete a Task (ID)", description = "Delete an existing task by ID")
    public ResponseEntity<Task> delete(@PathVariable("id") UUID id){

        taskService.deleteTask(id);

        return ResponseEntity.noContent().build();

    }




}
