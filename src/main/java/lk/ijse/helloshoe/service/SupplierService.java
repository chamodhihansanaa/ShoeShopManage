package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.dto.CustomDTO;
import lk.ijse.helloshoe.dto.SupplierDTO;
import lk.ijse.helloshoe.entity.Supplier;

import java.util.List;

public interface SupplierService {
    void saveSupplier(SupplierDTO dto);
    void updateSupplier(SupplierDTO dto);
    void deleteSupplier(String supplierCode);
    List<SupplierDTO> getAllSupplier();
    CustomDTO supplierIdGenerate();
    Supplier searchSupplierCode(String supplierCode);
}


