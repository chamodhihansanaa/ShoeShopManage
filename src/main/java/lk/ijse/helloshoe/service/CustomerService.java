package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.dto.CustomDTO;
import lk.ijse.helloshoe.dto.CustomerDTO;
import lk.ijse.helloshoe.entity.Customer;

import java.util.List;

public interface CustomerService {
    void saveCustomer(CustomerDTO dto);
    void updateCustomer(CustomerDTO dto);
    void deleteCustomer(String customerCode);
    List<CustomerDTO> getAllCustomer();
    CustomDTO customerIdGenerate();
    Customer searchCustomerCode(String customerCode);
    List<String> sendWishes();
}
