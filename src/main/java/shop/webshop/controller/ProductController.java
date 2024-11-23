package shop.webshop.controller;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;
import shop.webshop.model.Product;
import shop.webshop.service.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }



    // Produkt erstellen
    @PostMapping
    public Product createProduct(@Valid @RequestBody Product product) {
        return productService.createProduct(product);
    }

    // Produkt aktualisieren
    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @Valid @RequestBody Product updateProduct) {
        return productService.updateProduct(id, updateProduct);
    }

    // Alle Produkte abrufen
    @GetMapping
    public Iterable<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Produkt nach ID abrufen
    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id) {
        return productService.getProductById(id);
    }

    // Produkt löschen
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        productService.deleteProduct(id);
    }
    // Produkte nach Namen suchen
    @GetMapping("/search")
    public Iterable<Product> searchProducts(@RequestParam String name) {
        return productService.searchProducts(name);
    }

}
