//PUERTO PARA EL MANEJO DE STOCK DE INVENTARIO
package application.domain.services;

import org.springframework.stereotype.Service;

import application.domain.ports.InventoryPort;
import application.domain.ports.InventoryStockPort;

@Service
public class InventoryStockService implements InventoryStockPort {
    private final InventoryPort inventoryPort;

    public InventoryStockService(InventoryPort inventoryPort) {
        this.inventoryPort = inventoryPort;
    }

    @Override
    public void increaseStock(Long inventoryId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        var inventory = inventoryPort.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventario no encontrado"));
        inventory.setQuantity(inventory.getQuantity() + quantity);
    }

    @Override
    public void decreaseStock(Long inventoryId, int quantity) {
        if (quantity <= 0) {
            throw new IllegalArgumentException("La cantidad debe ser positiva");
        }
        var inventory = inventoryPort.findById(inventoryId)
                .orElseThrow(() -> new IllegalArgumentException("Inventario no encontrado"));
        if (inventory.getQuantity() < quantity) {
            throw new IllegalStateException("No hay suficiente stock disponible");
        }
        inventory.setQuantity(inventory.getQuantity() - quantity);
    }

    @Override
    public boolean hasStock(Long inventoryId, int quantity) {
        return inventoryPort.findById(inventoryId)
                .map(inventory -> inventory.getQuantity() >= quantity)
                .orElse(false);
    }
}