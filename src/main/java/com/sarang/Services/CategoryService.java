package com.sarang.Services;

import java.util.List;
import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sarang.Entity.Category;
import com.sarang.dao.CategoryDao;

@Service
public class CategoryService {
	@Autowired
	CategoryDao dao;

	public List<Category> getallCategory(int page,int size) {
		List<Category> list = dao.getallCategory(page,size);
		return list;
	}

	public String addCategory(Category c) {
		String msg = dao.addCategory(c);
		if (Objects.isNull(c)) {
			msg = "Category is not added";
		}
		return msg;
	}

	public Category getParticularCategoryID(int id) {
		Category c = dao.getParticularCategoryID(id);
		return c;
	}

	public String updateCategory(Category c, int id) {
		String msg = dao.updateCategory(c, id);
		if (Objects.isNull(c)) {
			msg = "Category is not updated";
		}
		return msg;
	}

	public String deleteCategory(int id) {
		String msg = dao.deleteCategory(id);
		if (Objects.isNull(id)) {
			msg = "Category is not Deleted";
		}
		return msg;
	}
}
