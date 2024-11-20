package com.sarang.dao;

import org.springframework.stereotype.Repository;

import com.sarang.Entity.Product;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

@Repository
public class ProductDao {
	@Autowired
	SessionFactory factory;

	public String addProduct(Product p) {
		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			session.persist(p);
			tx.commit();
			msg = "Product is added successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public List<Product> getallProduct(int page, int size) {
		Session session = null;
		Transaction tx = null;

		List<Product> list = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			String hql = "from Product";
			Query<Product> query = session.createQuery(hql, Product.class);
			query.setFirstResult((page - 1) * size);
			query.setMaxResults(size);
			list = query.getResultList();
			tx.commit();

		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return list;
	}

	public Product getParticularProductID(int id) {
		Session session = null;
		Transaction tx = null;
		Product product = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			product = session.get(Product.class, id);
			tx.commit();
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return product;
	}

	public String updateProduct(Product c, int id) {
		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Product product = session.get(Product.class, id);
			product.setName(c.getName());
			product.setPrice(c.getPrice());
			session.merge(product);

			tx.commit();
			msg = "Product is Update successfully";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}

	public String deleteProduct(int id) {
		Session session = null;
		Transaction tx = null;

		String msg = null;
		try {
			session = factory.openSession();
			tx = session.beginTransaction();
			Product product = session.get(Product.class, id);

			session.remove(product);
			tx.commit();
			msg = "Product is Deleted";
		} catch (Exception e) {
			if (tx != null) {
				tx.rollback();
			}
			e.printStackTrace();

		} finally {
			if (session != null) {
				session.close();
			}
		}
		return msg;
	}
}
