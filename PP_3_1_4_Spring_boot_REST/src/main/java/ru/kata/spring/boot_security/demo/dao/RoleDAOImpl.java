package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.Role;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Repository
public class RoleDAOImpl implements RoleDAO {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    @Transactional
    public Role roleById(Long id) {
        return entityManager.find(Role.class, id);
    }

    @Override
    @Transactional
    public List<Role> allRole() {
        return entityManager.createQuery("select role from Role role", Role.class).getResultList();
    }
}
