package com.sarang.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.sarang.Entity.Product;
import com.sarang.Services.ProductService;

@RestController
@RequestMapping("/api/products")
public class ProductController {
	@Autowired
	ProductService service;

//	ADD PRODUCT
	@PostMapping
	public ResponseEntity<String> addProduct(@RequestBody Product p) {
		String msg = service.addProduct(p);
		return ResponseEntity.ok(msg);
	}

//	GET ALL PRODUCT
	@GetMapping()
	public List<Product> getallProduct(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "2") int size) {
		List<Product> list = service.getallProduct(page,size);
		return list;
	}

//	GET PARTICULAR PRODUCT BY ID
	@GetMapping("/{id}")
	public Product getParticularProductID(@PathVariable int id) {
		Product p = service.getParticularProductID(id);
		return p;
	}

//	UPDATE PRODUCT
	@PutMapping("/{id}")
	public ResponseEntity<String> updateProduct(@RequestBody Product p, @PathVariable int id) {
		String msg = service.updateProduct(p, id);
		return ResponseEntity.ok(msg);
	}

//	DELETE PRODUCT
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteProduct(@PathVariable int id) {
		String msg = service.deleteProduct(id);
		return ResponseEntity.ok(msg);
	}
}
