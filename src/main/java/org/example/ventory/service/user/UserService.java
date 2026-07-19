package org.example.ventory.service.user;

import jakarta.transaction.Transactional;
import org.example.ventory.entity.User;
import org.example.ventory.enums.Role;
import org.example.ventory.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    public User registerUser(String username, String rawPassword) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new IllegalArgumentException("Username already exists!");
        }

        User user = new User();
        user.setUsername(username);
        // أمان: بنشفر الباسورد (مثلاً الـ 123456 بتتحول لـ $2a$10$xyz...)
        user.setPassword(passwordEncoder.encode(rawPassword));
        user.setRole(Role.ROLE_USER); // بنعطيه دور يوزر طبيعي في البداية

        return userRepository.save(user);
    }

    public User editProfile(Long userId, String username) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new RuntimeException("User not found"));

        user.setUsername(username);
        return userRepository.save(user);
    }

    @Transactional
    public void changePassword(Long userId, String oldPassword, String newPassword) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        // بنشيك: هل الباسورد القديمة اللي كتبها صحيحة؟
        // بنستخدم matches لأن الباسورد في الداتابيز مشفرة ومينفعش نقارنها بـ == عادية
        if (!passwordEncoder.matches(oldPassword, user.getPassword())) {
            throw new IllegalArgumentException("Old password is incorrect!");
        }

        user.setPassword(passwordEncoder.encode(newPassword));
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(Long userId) {
        if (!userRepository.existsById(userId)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(userId);
    }
}
