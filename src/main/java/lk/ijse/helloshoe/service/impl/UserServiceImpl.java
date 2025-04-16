package lk.ijse.helloshoe.service.impl;


import lk.ijse.helloshoe.dto.UserDTO;
import lk.ijse.helloshoe.entity.User;
import lk.ijse.helloshoe.enums.Role;
import lk.ijse.helloshoe.repo.UserRepo;
import lk.ijse.helloshoe.service.UserService;
import lk.ijse.helloshoe.service.exception.DuplicateRecordException;
import lk.ijse.helloshoe.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService{
    UserRepo userRepository;
    ModelMapper modelMapper;

    public UserServiceImpl(UserRepo userRepository, ModelMapper modelMapper) {
        this.userRepository = userRepository;
        this.modelMapper = modelMapper;
    }


    public UserDetailsService userDetailService() {

        return username -> (UserDetails) userRepository.findByEmail(username)
                .orElseThrow(() -> new
                        UsernameNotFoundException(
                        "user not found"));
    }

    public List<UserDTO> getAllUser() {
        return userRepository.findAll().stream().map(
                user -> modelMapper.map(user, UserDTO.class)
        ).toList();
    }


    public UserDTO getUserDetails(String email, Role role) {
        if(!userRepository.existsByEmail(email)){
            throw new NotFoundException("User email :"+email+" Not Found!");
        }
        return modelMapper.map(userRepository.findByEmailAndRole(email,role), UserDTO.class);
    }


    public UserDTO saveUser(UserDTO userDTO) {
        if(userRepository.existsByEmail(userDTO.getEmail())){
            try {
                throw new DuplicateRecordException("This User "+userDTO.getEmail()+" already have an account.");
            } catch (DuplicateRecordException e) {
                throw new RuntimeException(e);
            }
        }
        return modelMapper.map(userRepository.save(modelMapper.map(
                userDTO, User.class)), UserDTO.class
        );
    }


    public void updateUser(String email, UserDTO userDTO) {
        User existingUser = userRepository.findByEmailAndRole(email, userDTO.getUserRole());

        if(existingUser.getPassword().isEmpty()){
            throw new NotFoundException("User email :"+ email + "Not Found...");
        }

        existingUser.setPassword(userDTO.getPassword());
        existingUser.setRole(userDTO.getRole());

        userRepository.save(existingUser);
    }

    public void deleteUser(String email) {
        if(!userRepository.existsByEmail(email)){
            throw  new NotFoundException("User email :"+ email + "Not Found...");
        }
        userRepository.deleteByEmail(email);
    }
}


