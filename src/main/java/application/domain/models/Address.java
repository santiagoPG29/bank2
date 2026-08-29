//clase direccion
package application.domain.models;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
public class Address extends Buyer {
    private long id;
    private String calle;
    private String ciudad;

    public void validateAddress() {
        
    }


}
