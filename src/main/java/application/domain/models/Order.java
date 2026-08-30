//clase pedido
package application.domain.models;

import java.time.LocalDateTime;

import application.domain.models.enums.OrderStatus;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@NoArgsConstructor
public class Order extends Buyer {
    private long id;
    private LocalDateTime date;
    private String total;
    private OrderStatus status;
    
    public void changeStatus() {
        
    }

    public void cancelOrder() {
        
    }

    public void finishOrder() {
        
    }
    
}
