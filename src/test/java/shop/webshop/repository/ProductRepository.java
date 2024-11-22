package shop.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.webshop.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
