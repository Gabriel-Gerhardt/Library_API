package com.project.Mysql.auth;

import com.project.Mysql.user.Role;
import com.project.Mysql.user.User;
import com.project.Mysql.user.UserRepository;
import jakarta.servlet.http.HttpSession; // ou javax.servlet.http.HttpSession, dependendo da versão
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("login")
public class LoginController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public ResponseEntity<String> login(
        @RequestBody Login req,
        HttpSession session
    ) {
        User user = userRepository.findByEmailAndPassword(
            req.getEmail(),
            req.getPassword()
        );

        if (user == null) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
                "Usuário ou senha inválidos"
            );
        }

        session.setAttribute("user", user); // salva na sessão
        return ResponseEntity.ok("Login realizado");
    }
}
