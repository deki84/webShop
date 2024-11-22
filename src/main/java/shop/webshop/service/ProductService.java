package shop.webshop.service;

import org.springframework.stereotype.Service;
import shop.webshop.model.Product;
import shop.webshop.repository.ProductRepository;

import java.util.List;
@Service
public class ProductService {
    private final ProductRepository productRepository;
        public ProductService(ProductRepository productRepository) {
            this.productRepository = productRepository;
        }
        public List<Product> getAllProducts() {
            return productRepository.findAll();
        }
        public Product createProduct(Product product) {
            return productRepository.save(product);
        }
}
