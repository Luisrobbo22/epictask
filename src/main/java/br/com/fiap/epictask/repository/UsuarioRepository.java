package br.com.fiap.epictask.repository;

import br.com.fiap.epictask.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
