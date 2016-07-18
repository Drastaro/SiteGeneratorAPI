package com.sitegenerator.test;

import static org.junit.Assert.assertNotNull;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.eclipse.jdt.internal.compiler.parser.Scanner;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.junit.Before;
import org.junit.Test;
import org.springframework.util.StringUtils;

import com.amazon.client.ProductsAdvertisingClient;
import com.amazon.generated.Item;
import com.amazon.generated.ItemAttributes;
import com.amazon.generated.ItemLink;
import com.amazon.generated.ItemLinks;
import com.amazon.service.ProductsAdvertisingService;
import com.amazonaws.services.codepipeline.model.ActionDeclaration;
import com.sitegenerator.pojo.ProductReviews;
import com.sitegenerator.utils.properties.AmazonPropertiesUtils;

public class ProductsServiceTest {

	private ProductsAdvertisingClient client;
	private ProductsAdvertisingService service;

	public static void main(String[] args) {

		ProductsServiceTest test = new ProductsServiceTest();
		try {
			test.setUp();
			test.shouldFindProducts();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Before
	public void setUp() throws Exception {

		client = new ProductsAdvertisingClient(AmazonPropertiesUtils.AWS_ENDPOINT, AmazonPropertiesUtils.AWS_ACCESS_KEY,
				AmazonPropertiesUtils.AWS_SECRET, AmazonPropertiesUtils.AWS_ASSOCIATES_KEY);
		service = new ProductsAdvertisingService(client);
	}

	@Test
	public void shouldFindProducts() {
		// given
		String keywords = "B00MTWV0II";

		// when
		List<Item> items = service.findProducts(keywords);

		// then
		print(items);
	}

	@Test
	public void shouldFindProductsWithCategory() {
		// given
		String keywords = "car";
		String category = "Toys";

		// when
		List<Item> items = service.findProducts(keywords, category);

		// then
		assertNotNull(items);
		print(items);
	}

	@Test
	public void shouldFindProductsWithCategoryAndMinPriceAndMaxPrice() {
		// given
		String keywords = "gloves";
		String category = "Apparel";
		Integer minPrice = 5000;
		Integer maxPrice = 150000;

		// when
		List<Item> items = service.findProducts(keywords, category, minPrice, maxPrice);

		// then
		assertNotNull(items);
		print(items);
	}

	private void print(List<Item> items) {
		int nr = 0;
		System.out.println("\n");
		for (Item item : items) {
			ItemAttributes attributes = item.getItemAttributes();
			ItemLinks links = item.getItemLinks();
			List<ItemLink> itemLinks = links.getItemLink();
			 for (ItemLink itemLink : itemLinks) {
			 System.out.println(itemLink.getURL());

			/*
			 * JSoup Test
			 * 
			 */
			// String keywords = "B00MTWV0II";
			// String url = "http://www.amazon.com/product-reviews/" + keywords
			// + "/?showViewpoints=0&sortBy=byRankDescending&pageNumber=" + 1;
			// try {
			// Document doc = Jsoup.connect(url).timeout(30000)
			// .userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2
			// (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2")
			// .get();
			// Elements description = doc.select(
			// "div.a-section.a-spacing-none.reviews.celwidget
			// i.review-rating,a.review-title,a.author,div.a-section.a-spacing-none.reviews.celwidget
			// span.review-date,span.review-text");
			//
			// String output = description.html();
			// // System.out.println(output);
			//
			// String x = output.replace("<span class=\"a-icon-alt\">", "##");
			// String y = x.replace("out of 5 stars</span>", "");
			//
			// String[] res = y.split("##");
			//
			// ProductReviews pr = null;
			// for (String string : res) {
			//
			// String[] sec = string.split("\n");
			//
			// if (!StringUtils.isEmpty(sec[0])) {
			// pr = new ProductReviews();
			// pr.setRating(Double.parseDouble(sec[0]));
			// pr.setTitle(sec[1]);
			// pr.setAuthor(sec[2]);
			// pr.setDate(sec[3]);
			// pr.setReviewText(sec[4]);
			// }
			// }
			// } catch (IOException e) {
			// e.printStackTrace();
			// }
			}

			String id = item.getASIN();
			System.out.println(id);
		}
		System.out.println("\n");
	}
}
