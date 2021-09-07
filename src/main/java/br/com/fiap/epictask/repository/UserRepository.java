package br.com.fiap.epictask.repository;

import br.com.fiap.epictask.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    Page<User> findByNameContains(String name, Pageable pageable);

    Page<User> findByEmailEquals(String email, Pageable pageable);

    Page<User> findAllByNameContainsAndEmailEquals(String name, String email, Pageable pageable);
}
