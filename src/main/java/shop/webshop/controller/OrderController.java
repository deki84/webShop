package shop.webshop.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.webshop.model.Order;
import shop.webshop.service.OrderService;

@RestController
@RequestMapping("/api/orders") // Basis-URL für Bestellungen
public class OrderController {

    private final OrderService orderService;

    // Konstruktor-Injection für den Service
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    // Bestellung erstellen**
    @PostMapping
    public Order createOrder(@Valid @RequestBody Order order) {
        return orderService.createOrder(order);
    }

    // Bestellung aktualisieren (z. B. Status oder Artikel ändern)**
    @PutMapping("/{id}")
    public Order updateOrder(@PathVariable Long id, @Valid @RequestBody Order updatedOrder) {
        return orderService.updateOrder(id, updatedOrder);
    }

    // Alle Bestellungen abrufen**
    @GetMapping
    public Iterable<Order> getAllOrders() {
        return orderService.getAllOrders();
    }

    // Bestellung nach ID abrufen**
    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id);
    }

    // Bestellung löschen**
    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable Long id) {
        orderService.deleteOrder(id);
    }

    // Bestellungen eines bestimmten Benutzers abrufen**
    @GetMapping("/user/{userId}")
    public Iterable<Order> getOrdersByUserId(@PathVariable Long userId) {
        return orderService.getOrdersByUserId(userId);
    }

    // Status einer Bestellung aktualisieren**
    @PutMapping("/{id}/status")
    public Order updateOrderStatus(@PathVariable Long id, @RequestParam String status) {
        return orderService.updateOrderStatus(id, status);
    }
}
