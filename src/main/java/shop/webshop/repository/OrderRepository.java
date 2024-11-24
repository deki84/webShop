package shop.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import shop.webshop.model.Order;

import java.util.List;

// Repository für Datenbankoperationen von Bestellungen
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    // Methode zum Abrufen von Bestellungen eines bestimmten Benutzers
    List<Order> findByUserId(Long userId);
}
