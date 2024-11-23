package shop.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
    // Methode für die Suche nach Produkten basierend auf Namen
    Iterable<Product> findByNameContainingIgnoreCase(String name);
}
