//PUERTO PARA LA CONFIRMACIÓN DE ENTREGA
package application.domain.services;

import org.springframework.stereotype.Service;

import application.domain.models.enums.DeliveryStatus;
import application.domain.ports.DeliveryConfirmationPort;
import application.domain.ports.DeliveryPort;

@Service
public class DeliveryConfirmationService implements DeliveryConfirmationPort {
    private final DeliveryPort deliveryPort;

    public DeliveryConfirmationService(DeliveryPort deliveryPort) {
        this.deliveryPort = deliveryPort;
    }

    @Override
    public void confirmDelivery(Long deliveryId) {
        deliveryPort.findById(deliveryId)
                .orElseThrow(() -> new IllegalArgumentException("Entrega no encontrada"))
                .setDeliveryStatus(DeliveryStatus.DELIVERED);
    }
}