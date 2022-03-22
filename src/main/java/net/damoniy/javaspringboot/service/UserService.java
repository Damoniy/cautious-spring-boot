package net.damoniy.javaspringboot.service;

import net.damoniy.javaspringboot.domain.entity.User;
import net.damoniy.javaspringboot.domain.repository.UserRepository;
import net.damoniy.javaspringboot.rest.dto.UserView;
import net.damoniy.javaspringboot.utils.mapper.UserViewMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    private UserViewMapper viewMapper = new UserViewMapper();

    public List<UserView> list() {
        var users = repository.findAll();
        var userViews = users.stream().map( it -> viewMapper.map(it)).collect(Collectors.toList());
        return userViews;
    }

    public Optional<User> findById(Long id) {
        return repository.findById(id);
    }

    public User save(User user) {
        return repository.save(user);
    }

    public UserView update(Long id, User formulary) {
        var user = repository.getReferenceById(id);
        user = this.updateUserProperties(user, formulary);
        this.save(user);
        return this.viewMapper.map(user);
    }

    private User updateUserProperties(User user, User formulary) {
        user.setName(formulary.getName());
        user.setEmail(formulary.getEmail());
        user.setPhone(formulary.getPhone());
        return user;
    }

    public void remove(Long id) {
        repository.deleteById(id);
    }
}
