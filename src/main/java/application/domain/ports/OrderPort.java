package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Order;

public interface OrderPort {
    Order save(Order order);
    Optional<Order> findById(Long id);
    List<Order> findAll();
    Order update(Order order);
    void deleteById(Long id);
}
