package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.dto.CustomDTO;
import lk.ijse.helloshoe.dto.EmployeeDTO;
import lk.ijse.helloshoe.entity.Employee;

import java.util.List;

public interface EmployeeService {
    void saveEmployee(EmployeeDTO dto);
    void updateEmployee(EmployeeDTO dto);
    void deleteEmployee(String employeeCode);
    List<EmployeeDTO> getAllEmployee();
    CustomDTO employeeIdGenerate();
    Employee searchEmployeeCode(String employeeCode);
}

