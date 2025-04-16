package lk.ijse.helloshoe.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Pattern;
import lk.ijse.helloshoe.embeded.Address1;
import lk.ijse.helloshoe.enums.Gender;
import lk.ijse.helloshoe.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
//import java.util.logging.Level;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDTO {
    @Null(message = "ID is auto generated")
   private String customerCode;
    @NotBlank(message ="Name can not be null")
    @Pattern(regexp = "[A-Za-z ]+", message = "Name is not valid")
    private String customerName;
    @NotBlank(message = "Gender can not be null")
    private Gender gender;
    @NotBlank(message = "Date can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    @NotBlank(message = "Level can not be null")
    private Level level;
    @NotBlank(message = "Points can not be null")
    private int points;
    @NotBlank(message = "Date of Birth can not be null")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date dob;
    @NotBlank(message = "Address can not be null")
    private Address1 address;
    @NotBlank(message = "Contact can not be null")
    @Pattern(regexp = "^(?:\\+?94|0)(?:[1-9]\\d{1}|(?:2[0-4]|3[0-5]|4[0-6]|[5-7][0-5]|77|81|91)(?!\\d{2}))\\d{6}$", message = "Invalid Contact number")
    private String contact;
    @NotBlank(message = "Email can not be null")
    @Pattern(regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$", message = "Email not valid")
    private String email;
}


