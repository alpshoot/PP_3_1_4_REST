package ru.kata.spring.boot_security.demo.dao;

import org.springframework.stereotype.Repository;
import ru.kata.spring.boot_security.demo.model.User;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class UserDAOImpl implements UserDAO {
    @PersistenceContext
    private EntityManager entityManager;

    @Override
    @Transactional
    public List<User> getAllUsers() {
        return entityManager.createQuery("select  user from  User  user", User.class).getResultList();
    }

    @Override
    @Transactional
    public User getUserForID(Long id) {
        return entityManager.find(User.class, id);
    }

    @Override
    @Transactional
    public void createUser(User user) {
        entityManager.persist(user);
    }

    @Override
    @Transactional
    public void updateUser(User user) {
        entityManager.merge(user);
    }

    @Override
    @Transactional
    public void deleteUser(Long id) {

        entityManager.createQuery("delete from User where id = :id").setParameter("id", id).executeUpdate();


    }

    @Override
    public User getUserByLogin(String email) {

        return entityManager.createQuery("select user from User user where user.email = :email", User.class)
                .setParameter("email", email).getSingleResult();
    }
}
