package lk.ijse.helloshoe.repo;


import lk.ijse.helloshoe.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SupplierRepo extends JpaRepository<Supplier, String> {
    @Query(value = "SELECT supplier_code FROM supplier ORDER BY supplier_code DESC LIMIT 1", nativeQuery = true)
    String getLastIndex();
}

