package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Producto;
import application.domain.ports.ProductoPort;

@Service
public class ProductoService implements ProductoPort {
    private final List<Producto> productos = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Producto save(Producto producto) {
        if (producto == null) {
            throw new IllegalArgumentException("Producto cannot be null");
        }
        if (producto.getId() == 0) {
            producto.setId(sequence++);
        }
        productos.removeIf(existing -> existing.getId() == producto.getId());
        productos.add(producto);
        return producto;
    }

    @Override
    public Optional<Producto> findById(Long id) {
        return productos.stream().filter(producto -> producto.getId() == id).findFirst();
    }

    @Override
    public List<Producto> findAll() {
        return new ArrayList<>(productos);
    }

    @Override
    public Producto update(Producto producto) {
        return save(producto);
    }

    @Override
    public void deleteById(Long id) {
        productos.removeIf(producto -> producto.getId() == id);
    }
}
