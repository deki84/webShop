package shop.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.webshop.model.Order;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Long> {
    List<Order> findByUserId(Long userId);
}
