package lk.ijse.helloshoe.entity;

import jakarta.persistence.*;
import lk.ijse.helloshoe.embeded.Address;
import lk.ijse.helloshoe.embeded.Contact;
import lk.ijse.helloshoe.enums.Category;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Supplier {
    @Id
    private String supplierCode;
    private String supplierName;
    @Enumerated(EnumType.STRING)
    private Category category;
    @Embedded
    private Address address;
    @Embedded
    private Contact contact;
    private String email;


}
