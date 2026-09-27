package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.Refund;

public interface RefundPort {
    Refund save(Refund refund);
    Optional<Refund> findById(Long id);
    List<Refund> findAll();
    Refund update(Refund refund);
    void deleteById(Long id);
    void approve(Long refundId);
    void decline(Long refundId);
}
