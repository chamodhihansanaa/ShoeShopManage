package lk.ijse.helloshoe.repo;


import lk.ijse.helloshoe.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SecurityRepo extends JpaRepository<User,String> {
    Optional<User> findByEmail(String email);
}


