package com.example.demoSpringSecurity.controller;

import com.example.demoSpringSecurity.service.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class Controller {
    private final UserService service;

    public Controller(UserService service) {
        this.service = service;
    }
    // Доступен только авторизованным пользователям
    @GetMapping
    public String greeting() {
        return "Hello, my dear friends!";
    }
    //Доступен только авторизованным пользователям с ролью ADMIN
    @GetMapping("/admin")
    @PreAuthorize("hasRole('ADMIN')")
    public String exampleAdmin() {
        return "Hello, admin!";
    }
    //Получить роль ADMIN (для демонстрации)
    @GetMapping("/get-admin")
    public void getAdmin() {
        service.getAdmin();
    }
}
