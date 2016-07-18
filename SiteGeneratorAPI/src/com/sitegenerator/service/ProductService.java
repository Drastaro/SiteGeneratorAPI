package com.sitegenerator.service;

import com.sitegenerator.pojo.Product;

public interface ProductService {

	public void saveProductToDB(Product product);

	public Product getProductByID(String id);

}
