package shop.webshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.webshop.model.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
