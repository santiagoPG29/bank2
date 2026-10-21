//PUERTO PARA LA CONFIRMACION DE ENTREGA
package application.domain.ports;

public interface DeliveryConfirmationPort {
    void confirmDelivery(Long deliveryId);
}