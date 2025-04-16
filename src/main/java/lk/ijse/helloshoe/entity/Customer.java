package lk.ijse.helloshoe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoe.embeded.Address1;
import lk.ijse.helloshoe.enums.Gender;
import lk.ijse.helloshoe.enums.Level;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @Id
    private String customerCode;
    private String customerName;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    private Date date;
    @Enumerated(EnumType.STRING)
    private Level level;
    private int points;
    private Date dob;
    @Embedded
    private Address1 address;
    private String contact;
    private String email;
}
