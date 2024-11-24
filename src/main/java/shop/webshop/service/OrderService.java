package shop.webshop.service;

import org.springframework.stereotype.Service;
import shop.webshop.model.Order;
import shop.webshop.repository.OrderRepository;

import java.util.Optional;

@Service
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    // Bestellung erstellen
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    // Bestellung aktualisieren
    public Order updateOrder(Long id, Order updatedOrder) {
        Optional<Order> existingOrder = orderRepository.findById(id);
        if (existingOrder.isPresent()) {
            Order order = existingOrder.get();
            order.setStatus(updatedOrder.getStatus()); // Beispiel: Status aktualisieren
            order.setItems(updatedOrder.getItems());   // Beispiel: Artikel aktualisieren
            return orderRepository.save(order);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    // Alle Bestellungen abrufen
    public Iterable<Order> getAllOrders() {
        return orderRepository.findAll();
    }

    // Bestellung nach ID abrufen
    public Order getOrderById(Long id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Order not found"));
    }

    // Bestellung löschen
    public void deleteOrder(Long id) {
        if (orderRepository.existsById(id)) {
            orderRepository.deleteById(id);
        } else {
            throw new RuntimeException("Order not found");
        }
    }

    // Bestellungen eines bestimmten Benutzers abrufen
    public Iterable<Order> getOrdersByUserId(Long userId) {
        return orderRepository.findByUserId(userId);
    }

    // Bestellstatus aktualisieren
    public Order updateOrderStatus(Long id, String status) {
        Order order = getOrderById(id);
        order.setStatus(status);
        return orderRepository.save(order);
    }
}
