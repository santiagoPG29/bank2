package application.domain.ports;

import java.util.List;
import java.util.Optional;

import application.domain.models.User;

public interface UserPort {
    User save(User user);
    Optional<User> findById(Long id);
    List<User> findAll();
    User update(User user);
    void deleteById(Long id);
}
