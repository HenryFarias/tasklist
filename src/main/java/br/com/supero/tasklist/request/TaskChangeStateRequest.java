package br.com.supero.tasklist.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TaskChangeStateRequest {
    @NotNull(message = "Status é obrigatório")
    private Boolean state;
}
