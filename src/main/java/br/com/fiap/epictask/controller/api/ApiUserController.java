package br.com.fiap.epictask.controller.api;

import br.com.fiap.epictask.model.User;
import br.com.fiap.epictask.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.Optional;

@Controller
@ResponseBody
@RequestMapping("/api/user")
public class ApiUserController {

    @Autowired
    private UserRepository userRepository;


    @GetMapping(value = "{id}")
    @Cacheable("user")
    public ResponseEntity<User> findOne(@PathVariable Long id) {
        return ResponseEntity.of(userRepository.findById(id));

    }

    @GetMapping
    @Cacheable("user")
    public Page<User> findAll(@PageableDefault Pageable pageable) {
        return userRepository.findAll(pageable);
    }

    @PostMapping()
    @CacheEvict(value = "user", allEntries = true)
    public ResponseEntity<User> create(@Valid @RequestBody User usuario, UriComponentsBuilder componentsBuilder) {
        userRepository.save(usuario);
        URI uri = componentsBuilder.
                path("api/usuario/{id}")
                .buildAndExpand(usuario.getId())
                .toUri();
        return ResponseEntity.created(uri).body(usuario);
    }

    @PutMapping("{id}")
    @CacheEvict(value = "user", allEntries = true)
    public ResponseEntity<User> update(@PathVariable Long id,
                                       @RequestBody User newUser) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty())
            return ResponseEntity.notFound().build();

        User user = optionalUser.get();
        user.setName(newUser.getName());
        user.setEmail(newUser.getEmail());
        user.setPassword(newUser.getPassword());

        userRepository.save(user);

        return ResponseEntity.ok(user);
    }

    @DeleteMapping("{id}")
    @CacheEvict(value = "tasks", allEntries = true)
    public ResponseEntity<User> delete(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);

        if (user.isEmpty())
            return ResponseEntity.notFound().build();

        userRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
