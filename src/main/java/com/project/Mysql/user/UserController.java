package com.project.Mysql.user;

import jakarta.servlet.http.HttpSession;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @PostMapping
    public User createUser(
        @RequestParam String username,
        @RequestParam String email,
        @RequestParam String password,
        @RequestParam Role role
    ) {
        User user = new User(username, email, password, role);
        return userRepository.save(user);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userRepository.deleteById(id);
    }

    public User getUserByEmailAndPassword(String email, String password) {
        User user = userRepository.findByEmailAndPassword(email, password);
        if (user != null) {
            return user;
        }
        throw new IllegalArgumentException("Invalid email or password");
    }

    public boolean isAuthenticated(HttpSession session) {
        return session.getAttribute("user") != null;
    }

    public boolean isLibrarian(HttpSession session) {
        User user = (User) session.getAttribute("user");
        return user != null && user.getRole() == Role.LIBRARIAN;
    }
}
