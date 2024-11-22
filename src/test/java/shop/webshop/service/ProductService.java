package shop.webshop.service;

import org.springframework.stereotype.Service;
import shop.webshop.model.Product;
import shop.webshop.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {
    private final ProductRepository productRepository;

    // Konstruktor für Dependency Injection
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;

        }
    // Product speichern
    public Product saveProduct(Product product){
        return productRepository.save(product);
    }
    // Alle Produkte abrufen
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }
    // Produkt ID abrufen
    public Product getProductById(long id) {
        return productRepository.findById(id).orElse(null);
    }
    public void deleteProduct(long id) {
        productRepository.deleteById(id);
    }
}
