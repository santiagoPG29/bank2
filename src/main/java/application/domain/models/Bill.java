//clase factura 
package application.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Bill extends Order {    
    private LocalDateTime dateIssue;
    private float taxes;


    public void generateBill() {
        
    }


    public void updateBill() {
        
    }   



    public void confirmBill() {
        
    }



    public void cancelBill() {
        
    }       

    
}
