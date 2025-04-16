package lk.ijse.helloshoe.auth.request;

import lk.ijse.helloshoe.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignUpRequest {
    private  String email;
    private  String password;
    private Role role;
}
