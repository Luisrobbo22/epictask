package br.com.fiap.epictask.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Usuario {

    @Id
    private Long id;

    @NotBlank(message = "O nome do Usuário é obrigatório!")
    private String name;

    @Email
    private String email;

    @Size(min = 8)
    private String password;
}
