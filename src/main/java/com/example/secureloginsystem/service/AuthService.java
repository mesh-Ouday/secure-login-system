package com.example.secureloginsystem.service;

import com.example.secureloginsystem.model.User;
import com.example.secureloginsystem.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.security.crypto.password.PasswordEncoder;
@Service
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public AuthService(UserRepository userRepository,
                       PasswordEncoder passwordEncoder) {

        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public String register(String username, String password) {

        if (userRepository.findByUsername(username).isPresent()) {
            return "Username already exists";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(passwordEncoder.encode(password));

        userRepository.save(user);

        return "User registered successfully";
    }

    public String login(String username, String password) {

        User user = userRepository.findByUsername(username).orElse(null);

        if (user == null) {
            return "User not found";
        }

        if (user.isAccountLocked()) {
            return "Account is locked";
        }

        if (passwordEncoder.matches(password, user.getPassword())) {

            user.setFailedAttempts(0);
            userRepository.save(user);

            return "Login successful";
        } else {

            int attempts = user.getFailedAttempts() + 1;
            user.setFailedAttempts(attempts);

            if (attempts >= 5) {
                user.setAccountLocked(true);
            }

            userRepository.save(user);

            return "Invalid password";
        }
    }

}

