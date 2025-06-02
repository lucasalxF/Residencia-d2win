package com.backend.api.controller;

import com.backend.api.model.User;
import com.backend.api.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @Autowired
    private UserService userService;


    @PostMapping("/register")
    public String register(@RequestBody User user) {
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent()) {
            return "Erro: E-mail já cadastrado!";
        }
        userService.save(user);
        return "Usuário cadastrado com sucesso!";
    }


    @PostMapping("/login")
    public String login(@RequestBody User user) {
        Optional<User> existingUser = userService.findByEmail(user.getEmail());
        if (existingUser.isPresent() && existingUser.get().getSenha().equals(user.getSenha())) {
            return "Login realizado com sucesso!";
        }
        return "Erro: E-mail ou senha inválidos!";
    }
}
