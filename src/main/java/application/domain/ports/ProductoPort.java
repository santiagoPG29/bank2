package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Producto;

public interface ProductoPort {
    Producto save(Producto producto);
    Optional<Producto> findById(Long id);
    List<Producto> findAll();
    Producto update(Producto producto);
    void deleteById(Long id);
}
