package com.sarang.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sarang.Entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>  {

}
