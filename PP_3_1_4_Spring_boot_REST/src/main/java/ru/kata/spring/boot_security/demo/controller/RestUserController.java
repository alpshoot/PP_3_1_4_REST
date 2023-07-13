package ru.kata.spring.boot_security.demo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.UserServiceImpl;


@RestController
@RequestMapping("/api/user")
public class RestUserController {

    private final UserServiceImpl userServiceImp;

    public RestUserController(UserServiceImpl userServiceImp) {
        this.userServiceImp = userServiceImp;
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserInfoById(@PathVariable Long id) {
        return ResponseEntity.ok(userServiceImp.getUserForID(id));
    }

    @GetMapping("/getUserInfo")
    public ResponseEntity<User> getUserInfo(@AuthenticationPrincipal User user) {
        return ResponseEntity.ok(user);
    }
}
