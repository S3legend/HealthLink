package com.healthlink.login.service;

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
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private JavaMailSender mailSender;

    public ResponseEntity<String> registerUser(RegisterRequest registerRequest) {
        if (userRepository.findByEmail(registerRequest.getEmail()).isPresent()) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body("Erreur : L'email est déjà utilisé. Veuillez utiliser un autre email.");
        }

        User newUser = new User();
        newUser.setEmail(registerRequest.getEmail());
        newUser.setPassword(passwordEncoder.encode(registerRequest.getPassword()));
        newUser.setEnabled(true);
        userRepository.save(newUser);

        return ResponseEntity.ok("Utilisateur enregistré avec succès.");
    }

    public ResponseEntity<String> loginUser(LoginRequest loginRequest) {
        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());

        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Erreur : L'email n'existe pas. Veuillez vérifier votre email ou vous inscrire.");
        }

        if (!passwordEncoder.matches(loginRequest.getPassword(), user.get().getPassword())) {
            return ResponseEntity
                    .status(HttpStatus.UNAUTHORIZED)
                    .body("Erreur : Mot de passe incorrect. Veuillez réessayer.");
        }

        return ResponseEntity.ok("Connexion réussie.");
    }

    public ResponseEntity<String> resetPassword(String email) {
        Optional<User> user = userRepository.findByEmail(email);

        if (user.isEmpty()) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body("Erreur : Email non trouvé. Veuillez vérifier votre email ou vous inscrire.");
        }

        sendPasswordResetEmail(user.get().getEmail());
        return ResponseEntity.ok("Email de réinitialisation du mot de passe envoyé.");
    }

    private void sendPasswordResetEmail(String toEmail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(toEmail);
        message.setSubject("Demande de réinitialisation de mot de passe");
        message.setText("Pour réinitialiser votre mot de passe, cliquez sur le lien suivant :\n[Lien de réinitialisation]");
        mailSender.send(message);
    }
}
