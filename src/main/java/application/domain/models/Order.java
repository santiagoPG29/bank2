//clase pedido
package application.domain.models;

import java.time.LocalDateTime;

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
    
    public void changeStatus() {
        
    }

    public void cancelOrder() {
        
    }

    public void finishOrder() {
        
    }
    
}
