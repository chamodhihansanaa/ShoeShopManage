package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.dto.UserDTO;
import lk.ijse.helloshoe.enums.Role;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface UserService {
    UserDetailsService userDetailService();
    List<UserDTO> getAllUser();
    UserDTO getUserDetails(String email, Role role);
    UserDTO saveUser(UserDTO userDTO);
    void updateUser(String email, UserDTO userDTO);
    void deleteUser(String email);
}
