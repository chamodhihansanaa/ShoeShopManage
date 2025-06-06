package lk.ijse.helloshoe.service.impl;


import lk.ijse.helloshoe.dto.InventoryDTO;
import lk.ijse.helloshoe.entity.Inventory;
import lk.ijse.helloshoe.repo.InventoryRepo;
import lk.ijse.helloshoe.service.InventoryService;
import lk.ijse.helloshoe.service.exception.NotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InventoryServiceImpl  implements InventoryService {
    @Autowired
    InventoryRepo repo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public void saveInventory(InventoryDTO dto) {
        if (repo.existsById(dto.getItemCode())) {
            throw new RuntimeException("Item Already Exist. Please enter another id..!");
        }
        repo.save(mapper.map(dto, Inventory.class));
    }

    @Override
    public void updateInventory(InventoryDTO dto) {
        if (!repo.existsById(dto.getItemCode())) {
            throw new NotFoundException("Update Failed; item code: " + dto.getItemCode() + " does not exist");
        }
        repo.save(mapper.map(dto, Inventory.class));
    }

    @Override
    public void deleteInventory(String itemCode) {
        if (!repo.existsById(itemCode)) {
            throw new NotFoundException("Delete Failed; item code: " + itemCode + " does not exist");
        }
        repo.deleteById(itemCode);
    }

    @Override
    public List<InventoryDTO> getAllInventory() {
        return repo.findAll().stream().map(inventory -> mapper.map(inventory, InventoryDTO.class)).toList();
    }

    @Override
    public Inventory searchInventoryCode(String itemCode) {
        if (!repo.existsById(itemCode)) {
            throw new RuntimeException("Wrong ID. Please enter Valid id..!");
        }
        return mapper.map(repo.findById(itemCode).get(), Inventory.class);
    }
}



