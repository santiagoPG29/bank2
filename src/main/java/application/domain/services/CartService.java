package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Cart;
import application.domain.models.Producto;
import application.domain.ports.CartPort;

@Service
public class CartService implements CartPort {
    private final List<Cart> carts = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Cart save(Cart cart) {
        if (cart == null) {
            throw new IllegalArgumentException("Cart cannot be null");
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

    @Override
    public void addProduct(Long cartId, Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Product cannot be null");
        }
        Cart cart = findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        cart.getProducts().add(producto);
    }

    @Override
    public void removeProduct(Long cartId, Long productId) {
        Cart cart = findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        cart.getProducts().removeIf(producto -> producto.getId() == productId);
    }

    @Override
    public void clear(Long cartId) {
        Cart cart = findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
        cart.getProducts().clear();
    }
}
