package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.Refund;
import application.domain.models.enums.OrderStatus;
import application.domain.ports.RefundPort;

@Service
public class RefundService implements RefundPort {
    private final List<Refund> refunds = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public Refund save(Refund refund) {
        if (refund == null) {
            throw new IllegalArgumentException("Refund cannot be null");
        }
        if (refund.getId() == 0) {
            refund.setId(sequence++);
        }
        refunds.removeIf(existing -> existing.getId() == refund.getId());
        refunds.add(refund);
        return refund;
    }

    @Override
    public Optional<Refund> findById(Long id) {
        return refunds.stream().filter(refund -> refund.getId() == id).findFirst();
    }

    @Override
    public List<Refund> findAll() {
        return new ArrayList<>(refunds);
    }

    @Override
    public Refund update(Refund refund) {
        return save(refund);
    }

    @Override
    public void deleteById(Long id) {
        refunds.removeIf(refund -> refund.getId() == id);
    }

    @Override
    public void approve(Long refundId) {
        Refund refund = findById(refundId).orElseThrow(() -> new IllegalArgumentException("Refund not found"));
        refund.getOrder().setStatus(OrderStatus.CANCELLED);
        refund.setReason("Approved");
    }

    @Override
    public void decline(Long refundId) {
        Refund refund = findById(refundId).orElseThrow(() -> new IllegalArgumentException("Refund not found"));
        refund.setReason("Declined");
    }
}
