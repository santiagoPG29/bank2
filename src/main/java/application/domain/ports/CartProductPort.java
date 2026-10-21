//PUERTO PARA EL MANEJO DE PRODUCTOS EN EL CARRITO DE COMPRAS
package application.domain.ports;

import application.domain.models.Producto;

public interface CartProductPort {
    void addProduct(Long cartId, Producto producto);
    void removeProduct(Long cartId, Long productId);
    void clear(Long cartId);
}