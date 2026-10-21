//PUERTO PARA EL MANEJO DEL STOCK DEL INVENTARIO
package application.domain.ports;

public interface InventoryStockPort {
    void increaseStock(Long inventoryId, int quantity);
    void decreaseStock(Long inventoryId, int quantity);
    boolean hasStock(Long inventoryId, int quantity);
}