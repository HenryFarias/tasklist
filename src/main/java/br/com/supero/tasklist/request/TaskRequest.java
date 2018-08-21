package br.com.supero.tasklist.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskRequest {

    private Long id;

    @NotNull(message = "Título é obrigatório")
    private String title;

    @NotNull(message = "Descrição é obrigatório")
    private String description;

    @NotNull(message = "Status é obrigatório")
    private Boolean state;

    private Date completedAt;
    private Date createdAt;
    private Date updatedAt;
    private Date deletedAt;
}
