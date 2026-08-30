//clase factura
package application.domain.models;

import java.time.LocalDateTime;

import application.domain.models.enums.DeliveryStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Delivery extends Order {
    
    private long id;
    private LocalDateTime deliverydate;
    private DeliveryStatus deliveryStatus;


    public void delivery() {
        
    }

    public void update() {
        
    }


    public void confirmDelivery() {
        
    }
    
}
