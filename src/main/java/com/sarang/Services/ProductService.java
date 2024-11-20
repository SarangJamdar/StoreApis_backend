package com.sarang.Services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarang.Entity.Product;
import com.sarang.dao.ProductDao;

@Service
public class ProductService {
	@Autowired
	ProductDao dao;
	

	public String addProduct(Product p) {
		String msg = dao.addProduct(p);
		if (Objects.isNull(p)) {
			msg = "Product is not added";
		}
		return msg;
	}


	public List<Product> getallProduct(int page,int size) {
		List<Product> list = dao.getallProduct(page,size);
		return list;
	}


	public Product getParticularProductID(int id) {
		Product p = dao.getParticularProductID(id);
		return p;
	}


	public String updateProduct(Product p, int id) {
		String msg = dao.updateProduct(p, id);
		if (Objects.isNull(p)) {
			msg = "Product is not updated";
		}
		return msg;
	}


	public String deleteProduct(int id) {
		String msg = dao.deleteProduct(id);
		if (Objects.isNull(id)) {
			msg = "Product is not Deleted";
		}
		return msg;
	}
}
