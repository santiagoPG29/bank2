//PUERTO PARA EL MANEJO DEL CARRITO DE COMPRAS
package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Cart;

public interface CartPort {
    Cart save(Cart cart);
    Optional<Cart> findById(Long id);
    List<Cart> findAll();
    Cart update(Cart cart);
    void deleteById(Long id);
}
