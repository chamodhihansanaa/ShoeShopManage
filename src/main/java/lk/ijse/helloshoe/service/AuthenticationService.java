package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.auth.request.SignInRequest;
import lk.ijse.helloshoe.auth.request.SignUpRequest;
import lk.ijse.helloshoe.auth.response.JWTAuthResponse;
import lk.ijse.helloshoe.entity.User;

public interface AuthenticationService {
    JWTAuthResponse signIn(SignInRequest signInRequest);
    User signIn2(SignInRequest signInRequest);
    JWTAuthResponse signUp(SignUpRequest signUpRequest);
}

