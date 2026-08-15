package io.github.ericlps.listadetarefas.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.github.ericlps.listadetarefas.entity.enums.TaskStatus;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.Setter;
import lombok.Getter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.UUID;

@Entity

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Task {

    //Adicionar o READ_ONLY para não enviar o ID por JSON
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private UUID id;

    @Column(name = "title", nullable = false)
    @NotBlank
    private String title;

    @Column(name = "description")
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private TaskStatus status;

    //Adição do READ_ONLY para também não enviar a data de criação por JSON
    @Column(name = "creation_date", nullable = false)
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private LocalDate creationDate;

}
