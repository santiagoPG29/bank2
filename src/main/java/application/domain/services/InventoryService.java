//PUERTO PARA EL MANEJO DE INVENTARIO
package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Inventory;
import application.domain.ports.InventoryPort;

@Service
public class InventoryService implements InventoryPort {
    private final List<Inventory> inventories = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Inventory save(Inventory inventory) {
        if (inventory == null) {
            throw new IllegalArgumentException("El inventario no puede ser nulo");
        }
        if (inventory.getId() == 0) {
            inventory.setId(sequence++);
        }
        inventories.removeIf(existing -> existing.getId() == inventory.getId());
        inventories.add(inventory);
        return inventory;
    }

    @Override
    public Optional<Inventory> findById(Long id) {
        return inventories.stream().filter(inventory -> inventory.getId() == id).findFirst();
    }

    @Override
    public List<Inventory> findAll() {
        return new ArrayList<>(inventories);
    }

    @Override
    public Inventory update(Inventory inventory) {
        return save(inventory);
    }

    @Override
    public void deleteById(Long id) {
        inventories.removeIf(inventory -> inventory.getId() == id);
    }
}
