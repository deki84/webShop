package shop.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.webshop.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
