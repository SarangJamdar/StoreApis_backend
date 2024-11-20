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

import com.sarang.Entity.Category;
import com.sarang.Services.CategoryService;

@RestController
@RequestMapping("/api/categories")
public class CategoryController {
	@Autowired
	CategoryService service;

	@GetMapping()
	public List<Category> getallCategory(@RequestParam(defaultValue = "1") int page,
			@RequestParam(defaultValue = "2") int size) {
		List<Category> list = service.getallCategory(page, size);
		return list;
	}

	@PostMapping()
	public ResponseEntity<String> addCategory(@RequestBody Category c) {
		String msg = service.addCategory(c);
		return ResponseEntity.ok(msg);

	}

	@GetMapping("/{id}")
	public Category getParticularCategoryID(@PathVariable int id) {
		Category c = service.getParticularCategoryID(id);
		return c;
	}

	@PutMapping("/{id}")
	public ResponseEntity<String> updateCategory(@RequestBody Category c, @PathVariable int id) {
		String msg = service.updateCategory(c, id);
		return ResponseEntity.ok(msg);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteCategory(@PathVariable int id) {
		String msg = service.deleteCategory(id);
		return ResponseEntity.ok(msg);
	}
}
