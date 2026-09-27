package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Order;
import application.domain.ports.OrderPort;

@Service
public class OrderService implements OrderPort {
    private final List<Order> orders = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Order save(Order order) {
        if (order == null) {
            throw new IllegalArgumentException("Order cannot be null");
        }
        if (order.getId() == 0) {
            order.setId(sequence++);
        }
        orders.removeIf(existingOrder -> existingOrder.getId() == order.getId());
        orders.add(order);
        return order;
    }

    @Override
    public Optional<Order> findById(Long id) {
        return orders.stream()
                .filter(order -> order.getId() == id)
                .findFirst();
    }

    @Override
    public List<Order> findAll() {
        return new ArrayList<>(orders);
    }

    @Override
    public Order update(Order order) {
        return save(order);
    }

    @Override
    public void deleteById(Long id) {
        orders.removeIf(order -> order.getId() == id);
    }
}
