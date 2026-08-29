//clase producto
package application.domain.models;


import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Setter
@Getter
@NoArgsConstructor
public abstract class Producto extends Merchants {
    private long id;
    private String name;
    private String productType;

    
    public void post() {
        
    }

    public void suspend() {
        
    }
    

}
