package shop.webshop.service;

import org.springframework.stereotype.Service;
import shop.webshop.exception.ProductNotFoundException;
import shop.webshop.model.Product;
import shop.webshop.repository.ProductRepository;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

    public Product updateProduct(Long id, Product updateProduct) {
            return productRepository.findById(id).map(product ->{
                product.setName(updateProduct.getName());
                product.setDescription(updateProduct.getDescription());
                product.setPrice(updateProduct.getPrice());
                return productRepository.save(product);
            }).orElseThrow(() -> new RuntimeException("Product not found with id " + id ));


    }
    public void deleteProduct(Long id) {
            if(!productRepository.existsById(id)) {
              throw new ProductNotFoundException("Product not found with id " + id);
        }
        productRepository.deleteById(id);
    }
}
