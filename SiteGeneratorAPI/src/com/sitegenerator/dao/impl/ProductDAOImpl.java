package com.sitegenerator.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sitegenerator.dao.ProductDAO;
import com.sitegenerator.pojo.Product;

@Repository("productDAO")
public class ProductDAOImpl implements ProductDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductDAOImpl() {

	}

	public ProductDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<Product> list() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Product.class);
		List results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public List<Product> listByCategory(Enum category) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Product.class).add(Restrictions.eq("category", category));
		;
		List results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public Product getByID(String prID) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(Product.class);
		cr.add(Restrictions.eq("prId", prID)).uniqueResult();
		List results = cr.list();
		Product details = (Product) results.get(0);

		return details;
	}

	@Override
	@Transactional
	public void saveOrUpdate(Product product) {
		sessionFactory.getCurrentSession().saveOrUpdate(product);

	}

	@Override
	@Transactional
	public void delete(int id) {
		Product productDetails = new Product();
		productDetails.setId(id);
		sessionFactory.getCurrentSession().delete(productDetails);
	}

}
