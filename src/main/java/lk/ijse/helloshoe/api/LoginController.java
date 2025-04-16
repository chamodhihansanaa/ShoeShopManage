package lk.ijse.helloshoe.api;

import lk.ijse.helloshoe.auth.request.SignInRequest;
import lk.ijse.helloshoe.auth.request.SignUpRequest;
import lk.ijse.helloshoe.auth.response.JWTAuthResponse;
import lk.ijse.helloshoe.entity.User;
import lk.ijse.helloshoe.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/auth")
@RequiredArgsConstructor
@CrossOrigin(origins = "*", allowedHeaders = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE,RequestMethod.PATCH, RequestMethod.OPTIONS})

public class LoginController {
    private final AuthenticationService authenticationService;

//    @PostMapping("/signin")
//    public ResponseEntity<JWTAuthResponse> signIn(
//            @RequestBody SignInRequest signInRequest){
//        System.out.println("Signing in");
//        System.out.println("=========================================SINIGN IN");
//        System.out.println(signInRequest.getEmail());
//        return ResponseEntity.ok(
//                authenticationService.signIn(signInRequest));
//    }
    @PostMapping("/signin")
    public ResponseEntity<User> signIn(
            @RequestBody SignInRequest signInRequest){
        System.out.println("Signing in");
        System.out.println("=========================================SINIGN IN");
        System.out.println(signInRequest.getEmail());
        return ResponseEntity.ok(
                authenticationService.signIn2(signInRequest));
    }

    @PostMapping("/signup")
    public ResponseEntity<JWTAuthResponse> signUp(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }

    @PostMapping("/signupupdate")
    public ResponseEntity<JWTAuthResponse> signUpdate(
            @RequestBody SignUpRequest signUpRequest){
        return ResponseEntity.ok(
                authenticationService.signUp(signUpRequest));
    }
}


