package com.sitegenerator.dao.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.sitegenerator.dao.ProductReviewsDAO;
import com.sitegenerator.pojo.ProductReviews;

@Repository("productReviewsDAO")
public class ProductReviewsDAOImpl implements ProductReviewsDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public ProductReviewsDAOImpl() {

	}

	public ProductReviewsDAOImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public List<ProductReviews> list() {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ProductReviews.class);
		List results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public List<ProductReviews> getByID(String prId) {
		Criteria cr = sessionFactory.getCurrentSession().createCriteria(ProductReviews.class);
		cr.add(Restrictions.eq("prId", prId)).uniqueResult();
		List<ProductReviews> results = cr.list();

		return results;
	}

	@Override
	@Transactional
	public void saveOrUpdate(ProductReviews productReviews) {
		sessionFactory.getCurrentSession().saveOrUpdate(productReviews);
	}

	@Override
	@Transactional
	public void delete(int id) {
		ProductReviews productReviews = new ProductReviews();
		productReviews.setId(id);
		sessionFactory.getCurrentSession().delete(productReviews);
	}

}
