package shop.webshop.model;

import jakarta.persistence.*;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;

import java.util.List;

@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String status;

    @OneToMany
    private List<AbstractReadWriteAccess.Item> items;

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<AbstractReadWriteAccess.Item> getItems() {
        return items;
    }

    public void setItems(List<AbstractReadWriteAccess.Item> items) {
        this.items = items;
    }
}
