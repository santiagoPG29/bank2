//clase inventario
package application.domain.models;

import application.domain.models.enums.InventoryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Inventory extends Store {
    
    private String name;
    private int quantity;
    private InventoryStatus estado;



    public void updateInventory() {
        
    }

    public void checkInventory() {
        
    }

    public void enterInventory() {
        
    }

    public void validateInventory() {
        
    }


    public void removeInventory() {
        
    }


    
}
