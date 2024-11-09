package com.healthlink.healhlinkbackend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
class AuthService {

    private final BCryptPasswordEncoder passwordEncoder;
    @Autowired
    public AuthService(BCryptPasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    public boolean authenticate(String email, String passwordFromLoginForm) {
        // Récupérer l'utilisateur depuis la base de données
        User userFromDatabase = findUserByEmail(email);
        if (userFromDatabase == null) {
            return false; // Utilisateur non trouvé
        }

        // Comparer le mot de passe entré avec le mot de passe haché en base de données
        if (passwordEncoder.matches(passwordFromLoginForm, userFromDatabase.getPassword())) {
            return true; // Authentification réussie
        } else {
            return false; // Mot de passe incorrect
        }
    }

    // Méthode pour récupérer l'utilisateur par email (exemple)
    private User findUserByEmail(String email) {
        // Logique pour trouver l'utilisateur par email dans la base de données
        // Cela pourrait être un appel de repository, comme userRepository.findByEmail(email)
        return UserRepository.findByEmail(email);
    }
}

