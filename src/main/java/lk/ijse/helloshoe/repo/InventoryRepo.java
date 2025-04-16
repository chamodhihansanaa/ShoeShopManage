package lk.ijse.helloshoe.repo;


import lk.ijse.helloshoe.entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepo extends JpaRepository<Inventory,String> {
}
