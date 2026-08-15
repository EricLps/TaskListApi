package io.github.ericlps.listadetarefas.repository;

import io.github.ericlps.listadetarefas.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface TaskRepository extends JpaRepository<Task, UUID> {
}
