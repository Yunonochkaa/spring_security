package com.example.cat.controller;

import org.springframework.security.access.annotation.Secured;
import jakarta.annotation.security.RolesAllowed;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Secured("ROLE_READ")
    @GetMapping("/read")
    public String readData() {
        return "Данные для роли READ";
    }

    @RolesAllowed("WRITE")
    @GetMapping("/write")
    public String writeData() {
        return "Данные для роли WRITE";
    }

    @PreAuthorize("hasRole('WRITE') or hasRole('DELETE')")
    @GetMapping("/modify")
    public String modifyData() {
        return "Данные для ролей WRITE или DELETE";
    }

    @PostAuthorize("returnObject.username == authentication.name")
    @GetMapping("/user")
    public String getUser (@RequestParam String username) {
        User user = new User(username);
        return "Username is: " + user.username();
    }

    public record User(String username) {
    }
}
