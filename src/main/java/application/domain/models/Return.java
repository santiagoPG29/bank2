//clase devolucion
package application.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Return extends Order {
    private String reason;


    public void request() {
        
    }


    public void approve() {
        
    }


    public void decline() {
        
    }
   
}
