package io.github.ericlps.listadetarefas.service;

import io.github.ericlps.listadetarefas.entity.Task;
import io.github.ericlps.listadetarefas.exception.TaskNotFoundException;
import io.github.ericlps.listadetarefas.repository.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public Task saveTask(Task task){

        task.setCreationDate(LocalDate.now());

        return taskRepository.save(task);


    }

    public Task listById(UUID id){

        return taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Inexistent Task or Wrong ID"));

    }

    //Utilização do PAGEABLE para não listar TODAS as tarefas
    public Page<Task> listPage(Pageable pageable){

        return taskRepository.findAll(pageable);

    }


    public Task updateTask(UUID id, Task taskNova){

        Task taskExistente = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Inexistent Task or Wrong ID"));

        taskExistente.setTitle(taskNova.getTitle());
        taskExistente.setDescription(taskNova.getDescription());
        taskExistente.setStatus(taskNova.getStatus());

        return taskRepository.save(taskExistente);

    }

    public void deleteTask(UUID id){

        Task taskExistente = taskRepository.findById(id).orElseThrow(() -> new TaskNotFoundException("Inexistent Task or wrong ID"));

        taskRepository.delete(taskExistente);


    }

}
