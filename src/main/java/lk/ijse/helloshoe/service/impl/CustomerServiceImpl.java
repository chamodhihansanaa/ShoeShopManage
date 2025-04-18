package lk.ijse.helloshoe.service.impl;

import lk.ijse.helloshoe.dto.CustomDTO;
import lk.ijse.helloshoe.dto.CustomerDTO;
import lk.ijse.helloshoe.entity.Customer;
import lk.ijse.helloshoe.repo.CustomerRepo;
import lk.ijse.helloshoe.service.CustomerService;
import lk.ijse.helloshoe.service.exception.NotFoundException;
import lk.ijse.helloshoe.service.util.EmailUtil;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
public class CustomerServiceImpl  implements CustomerService {
    @Autowired
    CustomerRepo repo;

    @Override
    public CustomDTO customerIdGenerate() {
        return null;
    }

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveCustomer(CustomerDTO dto) {
        Customer customer = new Customer(dto.getCustomerCode(), dto.getCustomerName(), dto.getGender(), dto.getDate(), dto.getLevel(), dto.getPoints(), dto.getDob(), dto.getAddress(), dto.getContact(), dto.getEmail());
        if (repo.existsById(dto.getCustomerCode())) {
            throw new RuntimeException("Customer Already Exist. Please enter another id..!");
        }
        System.out.println(customer);
        repo.save(customer);
    }


    public void updateCustomer(CustomerDTO dto) {
        Customer customer = new Customer(dto.getCustomerCode(), dto.getCustomerName(), dto.getGender(), dto.getDate(), dto.getLevel(), dto.getPoints(), dto.getDob(), dto.getAddress(), dto.getContact(), dto.getEmail());
        if (!repo.existsById(dto.getCustomerCode())) {
            throw new RuntimeException("Customer Not Exist. Please enter Valid id..!");
        }
        repo.save(customer);
    }

    @Override
    public void deleteCustomer(String customerCode) {
        if(!repo.existsById(customerCode)){
            throw new NotFoundException("Delete Failed; customer code: " + customerCode + " does not exist");
        }
        repo.deleteById(customerCode);
    }

    @Override
    public List<CustomerDTO> getAllCustomer() {
        return repo.findAll().stream().map(customer -> mapper.map(customer, CustomerDTO.class)).toList();
    }

//    @Override
//    public CustomerDTO customerIdGenerate() {
//        return new CustomDTO(repo.getLastIndex());
//    }

    @Override
    public Customer searchCustomerCode(String customerCode) {
        if (!repo.existsById(customerCode)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(repo.findById(customerCode).get(), Customer.class);
    }

    @Override
    public List<String> sendWishes() {
        List<String> custStringList = new ArrayList<>();

        List<Customer> customersByBirthdayToday = repo.findCustomersByBirthdayToday();
        customersByBirthdayToday.forEach(customer -> {
            try {
                EmailUtil.sendEmail(customer.getEmail(), "Hello Shoe pvt.ltd", "Happy Birthday " + customer.getCustomerName() + "! "  + "Enjoy your Special day..!");
            } catch (MessagingException e) {
                throw new RuntimeException(e);
            }finally {
                String custCode = customer.getCustomerCode();
                String name = customer.getCustomerName();
                String together = custCode + " - " + name;
                custStringList.add(together);

            }
        });
        return custStringList;
    }


}


