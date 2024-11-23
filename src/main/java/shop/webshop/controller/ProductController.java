package shop.webshop.controller;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.webshop.model.Product;
import shop.webshop.repository.ProductRepository;
import shop.webshop.service.ProductService;

import java.util.List;

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    private final ProductService productService;
    private final ProductRepository productRepository;


    public ProductController(ProductService productService, ProductRepository productRepository) {
        this.productService = productService;
        this.productRepository = productRepository;
    }

    // Alle Produkte abrufen
    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // neues Produkt erstellen
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);


    }

    //Produkt aktualisieren
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id,@RequestBody Product updateProduct){
        return productService.updateProduct(id, updateProduct);
    }

}

