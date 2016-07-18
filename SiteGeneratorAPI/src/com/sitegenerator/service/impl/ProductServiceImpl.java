package com.sitegenerator.service.impl;

import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sitegenerator.dao.ProductDAO;
import com.sitegenerator.pojo.Product;
import com.sitegenerator.service.ProductService;

@Service("productService")
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDAO productDAO;

	@Override
	public void saveProductToDB(Product product) {

		productDAO.saveOrUpdate(product);

	}

	@Override
	public Product getProductByID(String id) {

		Product newProduct = productDAO.getByID(id);

		return newProduct;
	}
}
