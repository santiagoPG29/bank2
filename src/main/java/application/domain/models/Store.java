//calase bodega
package application.domain.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public abstract class Store extends Merchants {
    private long id;
    private String name;
    private String ubication;


    public void record() {
        
    }

    public void consultCapaciti() {
        
    }
    

    
}