package shop.webshop.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.webshop.model.User;
import shop.webshop.service.UserService;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    // Konstruktor-Injektion für die Dependency UserService
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Erstellt einen neuen Benutzer
    @PostMapping
    public User createUser(@Valid @RequestBody User user) {
        return userService.createUser(user);
    }

    // Ruft einen Benutzer anhand der ID ab
    @GetMapping("/{id}")
    public Optional<User> getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    // Aktualisiert die Daten eines vorhandenen Benutzers
    @PutMapping("/{id}")
    public User updateUser(@PathVariable Long id, @Valid @RequestBody User updatedUser) {
        return userService.updateUser(id, updatedUser);
    }

    // Löscht einen Benutzer anhand der ID
    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
