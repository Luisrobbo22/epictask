package br.com.fiap.epictask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.*;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "O título é obrigatório")
    private String title;

    @Size(min=10, message = "O descrição deve ter pelo menos 10 caracteres")
    private String description;

    @Min(value=10, message = "A pontuação mínima é 10")
    @Max(value=500, message = "A pontuação máxima é 500")
    private int points;
}