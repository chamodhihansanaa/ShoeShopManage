package lk.ijse.helloshoe.service;


import lk.ijse.helloshoe.dto.InventoryDTO;
import lk.ijse.helloshoe.entity.Inventory;

import java.util.List;

public interface InventoryService {
    void saveInventory(InventoryDTO dto);
    void updateInventory(InventoryDTO dto);
    void deleteInventory(String itemCode);
    List<InventoryDTO> getAllInventory();
    Inventory searchInventoryCode(String itemCode);
}


