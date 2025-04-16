package lk.ijse.helloshoe.service.impl;

import lk.ijse.helloshoe.auth.request.SignInRequest;
import lk.ijse.helloshoe.auth.request.SignUpRequest;
import lk.ijse.helloshoe.auth.response.JWTAuthResponse;
import lk.ijse.helloshoe.dto.UserDTO;
import lk.ijse.helloshoe.entity.User;
import lk.ijse.helloshoe.repo.EmployeeRepo;
import lk.ijse.helloshoe.repo.SecurityRepo;
import lk.ijse.helloshoe.service.AuthenticationService;
import lk.ijse.helloshoe.service.JWTService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl  implements AuthenticationService{
    private final PasswordEncoder passwordEncoder;
    private final SecurityRepo securityRepository;
    private final ModelMapper mapper;
    private final JWTService jwtService;
    private final AuthenticationManager authenticationManager;
    EmployeeRepo employeeRepository;

    @Override
    public JWTAuthResponse signIn(SignInRequest signInRequest) {
        try{
        Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(signInRequest.getEmail(), signInRequest.getPassword()));

        System.out.println("========= Auth service 1");
        User user = securityRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));

        System.out.println("========= Auth service");
        System.out.println(user.getEmail() + "-  " + user.getUsername());

//        String generatedToken = jwtService.generateToken(authentication.getDetails());
        String generatedToken = jwtService.generateToken( user);
        return JWTAuthResponse.builder().token(generatedToken).build();
    } catch (BadCredentialsException e) {
        throw new RuntimeException("Invalid email or password");
    } catch (Exception e) {
        e.printStackTrace();
        throw new RuntimeException("Authentication failed: " + e.getMessage());
    }
    }

    public User signIn2(SignInRequest signInRequest) {
        User user = securityRepository.findByEmail(signInRequest.getEmail())
                .orElseThrow(() -> new UsernameNotFoundException("user not found"));
        return user;
    }

    @Override
    public JWTAuthResponse signUp(SignUpRequest signUpRequest) {
        UserDTO userDTO = UserDTO.builder()
                .email(signUpRequest.getEmail())
                .password(passwordEncoder.encode(signUpRequest.getPassword()))
                .role(signUpRequest.getRole())
                .build();
        User savedUser = securityRepository.save(mapper.map(userDTO, User.class));
       String generatedToken = jwtService.generateToken((UserDetails) savedUser);
        return JWTAuthResponse.builder().token(generatedToken).build();
    }
}


