//PUERTO PARA EL MANEJO DE DECISIONES DE REEMBOLSO
package application.domain.services;

import org.springframework.stereotype.Service;

import application.domain.models.Refund;
import application.domain.models.enums.OrderStatus;
import application.domain.ports.RefundDecisionPort;
import application.domain.ports.RefundPort;

@Service
public class RefundDecisionService implements RefundDecisionPort {
    private final RefundPort refundPort;

    public RefundDecisionService(RefundPort refundPort) {
        this.refundPort = refundPort;
    }

    @Override
    public void approve(Long refundId) {
        Refund refund = findRefund(refundId);
        if (refund.getOrder() == null) {
            throw new IllegalStateException("El reembolso no tiene ningún pedido asociado");
        }
        refund.getOrder().setStatus(OrderStatus.CANCELLED);
        refund.setReason("aprovado");
    }

    @Override
    public void decline(Long refundId) {
        findRefund(refundId).setReason("rechazado");
    }

    private Refund findRefund(Long refundId) {
        return refundPort.findById(refundId)
                .orElseThrow(() -> new IllegalArgumentException("El reembolso no fue encontrado"));
    }
}