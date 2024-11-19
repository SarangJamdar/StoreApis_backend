package com.sarang.Services;

//import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.sarang.Entity.Category;
import com.sarang.Entity.Product;
import com.sarang.Repositories.ProductRepository;

@Service
public class ProductService {
	@Autowired
    private ProductRepository productRepository;

    @Autowired
    private CategoryService categoryService;

//    public List<Product> getAllProducts() {
//        return productRepository.findAll();
//    }
    public Page<Product> getProducts(int page) {
        return productRepository.findAll(PageRequest.of(page - 1, 10));
    }

    public Product getProductById(Long id) {
        return productRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Product not found with ID: " + id));
    }

    public Product createProduct(Product product) {
        Category category = categoryService.getCategoryById(product.getCategory().getId());
        product.setCategory(category);
        return productRepository.save(product);
    }

    public Product updateProduct(Long id, Product product) {
        Product existing = getProductById(id);
        Category category = categoryService.getCategoryById(product.getCategory().getId());
        existing.setName(product.getName());
        existing.setPrice(product.getPrice());
        existing.setCategory(category);
        return productRepository.save(existing);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
