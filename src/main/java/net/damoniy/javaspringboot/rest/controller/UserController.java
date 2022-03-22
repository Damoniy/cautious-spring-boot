package net.damoniy.javaspringboot.rest.controller;

import jakarta.transaction.Transactional;
import net.damoniy.javaspringboot.domain.entity.User;
import net.damoniy.javaspringboot.rest.dto.UserView;
import net.damoniy.javaspringboot.service.UserService;
import net.damoniy.javaspringboot.utils.URIBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService service;

    @PostMapping
    @Transactional
    public ResponseEntity<User> criarUsuario(@RequestBody User formulary) {
        var user = new User(formulary.getName(), formulary.getEmail(), formulary.getPhone(), formulary.getPassword());
        service.save(user);
        var uri = URIBuilder.setPath("/user").setId(user.getId()).build();
        return ResponseEntity.created(uri).body(user);
    }

    @GetMapping
    public ResponseEntity<List<UserView>> listarUsuarios() {
        return ResponseEntity.ok().body(service.list());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> encontrarUsuarioPeloId(@PathVariable Long id) {
        return ResponseEntity.ok().body(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserView> update(@PathVariable Long id, @RequestBody User user) {
        return ResponseEntity.ok().body(service.update(id, user));
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Transactional
    public void deletarUsuario(@PathVariable Long id) {
        service.remove(id);
    }
}
