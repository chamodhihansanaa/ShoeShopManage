package lk.ijse.helloshoe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Pattern;
import lk.ijse.helloshoe.enums.Gender;
import lk.ijse.helloshoe.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//import javax.management.relation.Role;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    @Null(message = "ID is auto generated")
    private String employeeCode;
    @NotBlank(message = "Name can not be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Name is not valid")
    private String employeeName;
    private String profilePic;
    @NotBlank(message = "Gender can not be null")
    private Gender gender;
    @NotBlank(message = "Status can not be null")
    private String status;
    @NotBlank(message = "Designation can not be null")
    private String designation;
    @NotBlank(message = "Role can not be null")
    private Role role;
    @NotBlank(message = "Date of Birth can not be null")
    @Past(message = "Date of Birth must be in the past")
    private Date dob;
    @NotBlank(message = "Date of join can not be null")
    private Date dateOfJoin;
    @NotBlank(message = "Name can not be null")
    private String branch;
    @NotBlank(message = "Address can not be null")
    private String  address1;
    @NotBlank(message = "Address can not be null")
    private String  address2;
    @NotBlank(message = "Address can not be null")
    private String  address3;
    @NotBlank(message = "Address can not be null")
    private String  address4;
    @NotBlank(message = "Address can not be null")
    private String  address5;
    @NotBlank(message = "Contact can not be null")
    @Pattern(regexp = "^(?:\\+?94|0)(?:[1-9]\\d{1}|(?:2[0-4]|3[0-5]|4[0-6]|[5-7][0-5]|77|81|91)(?!\\d{2}))\\d{6}$", message = "Invalid contact number")
    private String contact;
    @NotBlank(message = "Email can not be null")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email not valid")
    private String email;
    @NotBlank(message = "Name can not be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Name is not valid")
    private String emergencyPerson;
    @NotBlank(message = "Contact can not be null")
    @Pattern(regexp = "^(?:\\+?94|0)(?:[1-9]\\d{1}|(?:2[0-4]|3[0-5]|4[0-6]|[5-7][0-5]|77|81|91)(?!\\d{2}))\\d{6}$", message = "Invalid contact number")
    private String emergencyContact;
}


