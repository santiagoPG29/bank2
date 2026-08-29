//calse carrito de compras
package application.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;


@NoArgsConstructor
@Getter
@Setter
public class Cart extends Buyer {
    private long id;
    private LocalDateTime date;
    
    public void addProduct() {
        
    }

    public void removeProduct() {
        
    }
    
}
