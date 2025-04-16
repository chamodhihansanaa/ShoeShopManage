package lk.ijse.helloshoe.repo;


import lk.ijse.helloshoe.entity.User;
import lk.ijse.helloshoe.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepo extends JpaRepository<User,String> {
    Boolean existsByEmail(String email);
    User findByEmailAndRole(String email, Role role);
    void deleteByEmail(String email);
    Optional<User> findByEmail(String email);
}

