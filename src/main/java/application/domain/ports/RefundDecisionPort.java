//PUERTO PARA LA TOMA DE DECISIONES DE REEMBOLSO
package application.domain.ports;

public interface RefundDecisionPort {
    void approve(Long refundId);
    void decline(Long refundId);
}