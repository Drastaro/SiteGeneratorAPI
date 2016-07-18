package com.sitegenerator.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sitegenerator.dao.ProductDataExtractor;
import com.sitegenerator.dao.ProductDAO;
import com.sitegenerator.dao.ProductReviewsDAO;

@Controller
public class TestController {

	@Autowired
	private ProductDAO productDetailsDAO;

	@Autowired
	private ProductReviewsDAO productReviewsDAO;

	@RequestMapping("/saveobject")
	public void saveObject() throws Exception {

		ProductDataExtractor extract = new ProductDataExtractor();
		extract.setUp();
		// extract.findProducts(productDetailsDAO, productReviewsDAO);

	}

}
