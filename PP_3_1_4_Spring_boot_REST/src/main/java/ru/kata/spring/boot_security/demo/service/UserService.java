package ru.kata.spring.boot_security.demo.service;


import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;


public interface UserService {
    public List<User> getAllUsers();

    User getUserForID(Long id);

    public void createUser(User user);

    void updateUser(User user);

    public void deleteUser(Long id);

    User getUserByLogin(String email);
}
