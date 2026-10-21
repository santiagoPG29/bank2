//PUERTO PARA EL MANEJO DEL INVENTARIO
package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Inventory;

public interface InventoryPort {
    Inventory save(Inventory inventory);
    Optional<Inventory> findById(Long id);
    List<Inventory> findAll();
    Inventory update(Inventory inventory);
    void deleteById(Long id);
}
