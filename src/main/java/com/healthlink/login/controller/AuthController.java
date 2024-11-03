package com.healthlink.login.controller;

import com.healthlink.login.dto.LoginRequest;
import com.healthlink.login.dto.RegisterRequest;
import com.healthlink.login.model.User;
import com.healthlink.login.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest registerRequest) {
        // Vérifie si l'email est déjà utilisé
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Error: Email already in use. Please use a different email.");
        }

        // Crée et enregistre le nouvel utilisateur
        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        userRepository.save(newUser);

        return ResponseEntity.ok("User registered successfully.");
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest loginRequest) {
        // Cherche l'utilisateur par email
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        // Vérifie si l'email existe
        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: Email does not exist. Please check your email or register for a new account.");
        }

        // Vérifie si le mot de passe est correct
        if (!passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Error: Incorrect password. Please try again.");
        }

        return ResponseEntity.ok("Login successful.");
    }

    @PostMapping("/reset-password")
    public ResponseEntity<?> resetPassword(@RequestParam String email) {
        // Cherche l'utilisateur par email
        Optional<User> user = userRepository.findByEmail(email);

        // Vérifie si l'email existe
        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Error: Email not found. Please check your email or register for a new account.");
        }

        // Envoie l'email de réinitialisation
        sendPasswordResetEmail(user.get().getEmail());
        return ResponseEntity.ok("Password reset email sent.");
    }

    // Méthode pour envoyer l'email de réinitialisation
    private void sendPasswordResetEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Password Reset Request");
        message.setText("To reset your password, click the link below:\n[Password reset link]");
        mailSender.send(message);
    }
}

