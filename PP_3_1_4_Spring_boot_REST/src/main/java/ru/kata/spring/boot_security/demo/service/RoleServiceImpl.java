package ru.kata.spring.boot_security.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.kata.spring.boot_security.demo.dao.RoleDAO;
import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

@Service
public class RoleServiceImpl implements RoleService {

    @Autowired
    RoleDAO roleDAO;

    @Override
    public Role roleById(Long id) {
        return roleDAO.roleById(id);
    }

    @Override
    public List<Role> getAllRoles() {
        return roleDAO.allRole();
    }
}
