package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Delivery;

public interface DeliveryPort {
    Delivery save(Delivery delivery);
    Optional<Delivery> findById(Long id);
    List<Delivery> findAll();
    Delivery update(Delivery delivery);
    void deleteById(Long id);
    void confirmDelivery(Long deliveryId);
}
