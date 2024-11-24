package shop.webshop.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import shop.webshop.model.Order;
import shop.webshop.service.OrderService;

import java.util.List;


@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final OrderService orderService;

    // Konstruktor für Dependency Injection
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Bestellung erstellen
    @PostMapping
    public ResponseEntity<Order> createOrder(@RequestBody Order order) {
        Order createdOrder = orderService.createOrder(order);
        return ResponseEntity.ok(createdOrder);
    }

    // Alle Bestellungen abrufen
    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = (List<Order>) orderService.getAllOrders();
        return ResponseEntity.ok(orders);
    }

    // Bestellung nach ID abrufen
    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        Order order = orderService.getOrderById(id);
        return ResponseEntity.ok(order);
    }

    // Bestellungen eines bestimmten Benutzers abrufen
    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Order>> getOrdersByUserId(@PathVariable Long userId) {
        List<Order> orders = (List<Order>) orderService.getOrdersByUserId(userId);
        return ResponseEntity.ok(orders);
    }

    // Bestellung aktualisieren
    @PutMapping("/{id}")
    public ResponseEntity<Order> updateOrder(@PathVariable Long id, @RequestBody Order updatedOrder) {
        Order order = orderService.updateOrder(id, updatedOrder);
        return ResponseEntity.ok(order);
    }

    // Bestellstatus aktualisieren
    @PatchMapping("/{id}/status")
    public ResponseEntity<Order> updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        Order order = orderService.updateOrderStatus(id, status);
        return ResponseEntity.ok(order);
    }

    // Bestellung löschen
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
        return ResponseEntity.noContent().build();
    }
}
