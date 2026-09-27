package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Delivery;
import application.domain.models.enums.DeliveryStatus;
import application.domain.ports.DeliveryPort;

@Service
public class DeliveryService implements DeliveryPort {
    private final List<Delivery> deliveries = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Delivery save(Delivery delivery) {
        if (delivery == null) {
            throw new IllegalArgumentException("Delivery cannot be null");
        }
        if (delivery.getId() == 0) {
            delivery.setId(sequence++);
        }
        deliveries.removeIf(existing -> existing.getId() == delivery.getId());
        deliveries.add(delivery);
        return delivery;
    }

    @Override
    public Optional<Delivery> findById(Long id) {
        return deliveries.stream().filter(delivery -> delivery.getId() == id).findFirst();
    }

    @Override
    public List<Delivery> findAll() {
        return new ArrayList<>(deliveries);
    }

    @Override
    public Delivery update(Delivery delivery) {
        return save(delivery);
    }

    @Override
    public void deleteById(Long id) {
        deliveries.removeIf(delivery -> delivery.getId() == id);
    }

    @Override
    public void confirmDelivery(Long deliveryId) {
        Delivery delivery = findById(deliveryId).orElseThrow(() -> new IllegalArgumentException("Delivery not found"));
        delivery.setDeliveryStatus(DeliveryStatus.DELIVERED);
    }
}
