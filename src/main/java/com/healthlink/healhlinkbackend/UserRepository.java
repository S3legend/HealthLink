package com.healthlink.healhlinkbackend;

import com.healthlink.healhlinkbackend.User; // Import correct
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    static User findByEmail(String email) // Trouver un utilisateur par email
    {
        return null;
    }
    }


