//calse carrito de compras
package application.domain.models;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
public class Cart extends Buyer {
    private long id;
    private LocalDateTime date;
    private List<Producto> products = new ArrayList<>();

    public void addProduct() {

    }

    public void removeProduct() {

    }

}
