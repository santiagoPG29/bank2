package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Cart;
import application.domain.models.Producto;

public interface CartPort {
    Cart save(Cart cart);
    Optional<Cart> findById(Long id);
    List<Cart> findAll();
    Cart update(Cart cart);
    void deleteById(Long id);
    void addProduct(Long cartId, Producto producto);
    void removeProduct(Long cartId, Long productId);
    void clear(Long cartId);
}
