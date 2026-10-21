//PUERTO PARA EL MANEJO DE CARRITOS
package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Cart;
import application.domain.ports.CartPort;

@Service
public class CartService implements CartPort {
    private final List<Cart> carts = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Cart save(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("El carrito no puede ser nulo");
        }
        if (cart.getId() == 0) {
            cart.setId(sequence++);
        }
        carts.removeIf(existing -> existing.getId() == cart.getId());
        carts.add(cart);
        return cart;
    }

    @Override
    public Optional<Cart> findById(Long id) {
        return carts.stream().filter(cart -> cart.getId() == id).findFirst();
    }

    @Override
    public List<Cart> findAll() {
        return new ArrayList<>(carts);
    }

    @Override
    public Cart update(Cart cart) {
        return save(cart);
    }

    @Override
    public void deleteById(Long id) {
        carts.removeIf(cart -> cart.getId() == id);
    }
}
