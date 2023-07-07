package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.UserDAO;
import ru.kata.spring.boot_security.demo.model.User;



import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {
    @Autowired
    private UserDAO userDAO;

    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }

    @Override
    public User getUserForID(Long id) {
        return userDAO.getUserForID(id);
    }

    @Override
    public void createUser(User user) {
        userDAO.createUser(user);
    }

    @Override
    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDAO.deleteUser(id);
    }

    @Override
    public User getUserByLogin(String email) {
        return userDAO.getUserByLogin(email);
    }

    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        return userDAO.getUserByLogin(email);
    }


}
