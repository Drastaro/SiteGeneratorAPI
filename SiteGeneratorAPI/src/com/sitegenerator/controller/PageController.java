package com.sitegenerator.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.sitegenerator.dao.ProductDAO;
import com.sitegenerator.dao.ProductDataExtractor;
import com.sitegenerator.generator.ProductComparation;
import com.sitegenerator.pojo.Product;
import com.sitegenerator.service.ProductService;

@Controller
public class PageController {

	@Autowired
	private ProductDAO productDAO;

	@Autowired
	ProductService productService;

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {

		return "index";
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public String listProducts() {

		return "index";
	}

	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ModelAndView saveProductToDB() {

		return new ModelAndView("searchform", "command", new Product());
	}

	@RequestMapping(value = "/saveproduct", method = RequestMethod.POST)
	public ModelAndView submitProductToDB(@ModelAttribute("command") Product newProduct,
			@RequestParam(value = "q", required = false) String query) throws Exception {

		ProductDataExtractor extractor = new ProductDataExtractor();
		List<Product> producstList = extractor.findProducts(query);
		for (Product product : producstList) {
			product.setCategory(newProduct.getCategory());
			productService.saveProductToDB(product);
		}

		ModelMap model = new ModelMap();
		model.put("query", query);

		return new ModelAndView("searchform", "model", model);

	}

	@RequestMapping(value = "/get", method = RequestMethod.GET)
	public ModelAndView getProduct() {

		return new ModelAndView("getproduct");
	}

	@RequestMapping(value = "/returnproduct", method = RequestMethod.POST)
	public ModelAndView getProductFromDB(@RequestParam(value = "q", required = false) String query) throws Exception {

		Product product = productService.getProductByID(query);

		System.out.println(product.getPrName());
		List<String> features = product.getAttributes().getPrFeatures();
		for (String string : features) {
			System.out.println(string);
		}
		System.out.println(product.getPrId());
		ModelMap model = new ModelMap();
		model.put("query", query);

		return new ModelAndView("searchform", "model", model);
	}

	@RequestMapping(value = "/urlsearch", method = RequestMethod.GET)
	public ModelAndView saveProductFromUrl() {

		return new ModelAndView("urlform", "command", new Product());
	}

	@RequestMapping(value = "/urlsaveproduct", method = RequestMethod.POST)
	public ModelAndView saveProductFromURLToDB(@ModelAttribute("command") Product newProduct,
			@RequestParam(value = "q", required = false) String query) throws Exception {

		String string1 = query.substring(query.indexOf("dp"));
		String prId = string1.substring(3, 13);
		ProductDataExtractor extractor = new ProductDataExtractor();
		List<Product> producstList = extractor.findProducts(prId);
		for (Product product : producstList) {
			product.setCategory(newProduct.getCategory());
			productService.saveProductToDB(product);
		}

		ModelMap model = new ModelMap();
		model.put("query", prId);

		return new ModelAndView("urlform", "model", model);
	}

	@RequestMapping(value = "/compare", method = RequestMethod.GET)
	public ModelAndView comparePage() {

		return new ModelAndView("compare");

	}

	@RequestMapping(value = "/submitcompare", method = RequestMethod.POST)
	public ModelAndView generateComparePage(@RequestParam(value = "p1", required = false) String p1,
			@RequestParam(value = "p2", required = false) String p2, @RequestParam(value = "p3", required = false) String p3,
			@RequestParam(value = "p4", required = false) String p4, @RequestParam(value = "p5", required = false) String p5)
			throws IOException {

		List<Product> products = new ArrayList<Product>();
		Product product1 = productService.getProductByID(p1);
		products.add(product1);
		Product product2 = productService.getProductByID(p2);
		products.add(product2);
		Product product3 = productService.getProductByID(p3);
		products.add(product3);
		Product product4 = productService.getProductByID(p4);
		products.add(product4);
		Product product5 = productService.getProductByID(p5);
		products.add(product5);
		ProductComparation.generateSmartComparePage(products);

		ModelMap model = new ModelMap();
		model.put("p1", p1);
		model.put("p2", p2);
		model.put("p3", p3);
		model.put("p4", p4);
		model.put("p5", p5);

		return new ModelAndView("compare", "model", model);

	}

	@RequestMapping(value = "/comparecheapest", method = RequestMethod.GET)
	public ModelAndView compareCheapestPage() {

		return new ModelAndView("comparecheapest", "command", new Product());
	}

	@RequestMapping(value = "/submitcomparecheapest", method = RequestMethod.POST)
	public ModelAndView submitCompareCheapestPage(@ModelAttribute("command") Product newProduct) throws IOException {

		List<Product> productsList = productDAO.listByCategory(newProduct.getCategory());
		Set<Product> productsSet = new HashSet<>();
		productsSet.addAll(productsList);
		ProductComparation.generateCheapests(productsSet);

		return new ModelAndView("comparecheapest");

	}

	@RequestMapping(value = "/compareexpensive", method = RequestMethod.GET)
	public ModelAndView compareExpensivePage() throws IOException {

		return new ModelAndView("compareexpensive", "command", new Product());
	}

	@RequestMapping(value = "/submitcompareexpensive", method = RequestMethod.POST)
	public ModelAndView submitCompareExpensive(@ModelAttribute("command") Product newProduct) throws IOException {

		List<Product> productsList = productDAO.listByCategory(newProduct.getCategory());
		Set<Product> productsSet = new HashSet<>();
		productsSet.addAll(productsList);
		ProductComparation.generateExpensive(productsSet);

		return new ModelAndView("compareexpensive");

	}

	@RequestMapping(value = "/comparerandom", method = RequestMethod.GET)
	public ModelAndView compareRandomPage() throws IOException {

		return new ModelAndView("comparerandom", "command", new Product());
	}

	@RequestMapping(value = "/submitcomparerandom", method = RequestMethod.POST)
	public ModelAndView submitCompareRandom(@ModelAttribute("command") Product newProduct) throws IOException {

		List<Product> productsList = productDAO.listByCategory(newProduct.getCategory());
		Set<Product> productsSet = new HashSet<>();
		productsSet.addAll(productsList);
		ProductComparation.generateRandom(productsSet);

		return new ModelAndView("comparerandom");

	}
}
