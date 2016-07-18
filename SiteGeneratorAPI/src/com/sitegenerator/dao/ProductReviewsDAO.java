package com.sitegenerator.dao;

import java.util.List;

import com.sitegenerator.pojo.ProductReviews;

public interface ProductReviewsDAO {

	public List<ProductReviews> list();

	public List<ProductReviews> getByID(String prId);

	public void saveOrUpdate(ProductReviews productReviews);

	public void delete(int id);

}
