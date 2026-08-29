//clase reembolso
package application.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Refund extends Return {
    
    private long id;
    private String reason;
    private float amount;


    public void confirm() {
        
    }   
    
}
