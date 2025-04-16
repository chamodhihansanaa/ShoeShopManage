package lk.ijse.helloshoe.auth.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lk.ijse.helloshoe.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.management.relation.Role;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SignInRequest {
    private  String email;
    private  String password;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Role role;
}
