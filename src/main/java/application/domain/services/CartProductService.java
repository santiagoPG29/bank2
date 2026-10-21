//PUERTO PARA EL MANEJO DE PRODUCTOS EN EL CARRITO
package application.domain.services;

import org.springframework.stereotype.Service;

import application.domain.models.Cart;
import application.domain.models.Producto;
import application.domain.ports.CartPort;
import application.domain.ports.CartProductPort;

@Service
public class CartProductService implements CartProductPort {
    private final CartPort cartPort;

    public CartProductService(CartPort cartPort) {
        this.cartPort = cartPort;
    }

    @Override
    public void addProduct(Long cartId, Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("El producto no puede ser nulo");
        }
        findCart(cartId).getProducts().add(producto);
    }

    @Override
    public void removeProduct(Long cartId, Long productId) {
        findCart(cartId).getProducts().removeIf(producto -> producto.getId() == productId);
    }

    @Override
    public void clear(Long cartId) {
        findCart(cartId).getProducts().clear();
    }

    private Cart findCart(Long cartId) {
        return cartPort.findById(cartId).orElseThrow(() -> new IllegalArgumentException("Cart not found"));
    }
}