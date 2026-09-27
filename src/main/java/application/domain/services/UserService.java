package application.domain.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import application.domain.models.User;
import application.domain.ports.UserPort;

@Service
public class UserService implements UserPort {
    private final List<User> users = new ArrayList<>();
    private long sequence = 1L;

    @Override
    public User save(User user) {
        if (user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }
        if (user.getId() == 0) {
            user.setId(sequence++);
        }
        users.removeIf(existingUser -> existingUser.getId() == user.getId());
        users.add(user);
        return user;
    }

    @Override
    public Optional<User> findById(Long id) {
        return users.stream()
                .filter(user -> user.getId() == id)
                .findFirst();
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public User update(User user) {
        return save(user);
    }

    @Override
    public void deleteById(Long id) {
        users.removeIf(user -> user.getId() == id);
    }
}
