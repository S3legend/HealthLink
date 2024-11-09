package com.healthlink.healhlinkbackend;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HomeController {

    @GetMapping("/") // Mappage pour la racine
    public String home() {
        return "Bienvenue dans l'application HealthLink Backend!";
    }
}

