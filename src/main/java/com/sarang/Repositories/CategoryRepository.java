package com.sarang.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarang.Entity.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

}
