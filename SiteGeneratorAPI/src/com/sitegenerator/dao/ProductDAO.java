package com.sitegenerator.dao;

import java.util.List;
import java.util.Set;

import com.sitegenerator.pojo.Product;

public interface ProductDAO {

	public List<Product> list();

	public List<Product> listByCategory(Enum category);

	public Product getByID(String prID);

	public void saveOrUpdate(Product product);

	public void delete(int id);

}
