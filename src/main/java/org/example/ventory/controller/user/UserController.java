package org.example.ventory.controller.user;

import org.example.ventory.entity.User;
import org.example.ventory.service.user.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestParam String username, @RequestParam String password) {
        userService.registerUser(username, password);
        return ResponseEntity.ok("User registered successfully!");
    }

    @PutMapping("/{id}/profile")
    public ResponseEntity<User> editProfile(@PathVariable Long id, @RequestParam String newUsername) {
        User updatedUser = userService.editProfile(id, newUsername);
        return ResponseEntity.ok(updatedUser);
    }

    @PutMapping("/{id}/change-password")
    public ResponseEntity<String> changePassword(
            @PathVariable Long id,
            @RequestParam String oldPassword,
            @RequestParam String newPassword) {
        userService.changePassword(id, oldPassword, newPassword);
        return ResponseEntity.ok("Password changed successfully!");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAccount(@PathVariable Long id) {
        userService.deleteUser(id);
        return ResponseEntity.ok("Account deleted successfully!");
    }
}
