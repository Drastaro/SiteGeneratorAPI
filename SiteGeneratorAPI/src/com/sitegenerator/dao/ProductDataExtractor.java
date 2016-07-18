package com.sitegenerator.dao;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

import com.amazon.client.ProductsAdvertisingClient;
import com.amazon.generated.DecimalWithUnits;
import com.amazon.generated.EditorialReview;
import com.amazon.generated.EditorialReviews;
import com.amazon.generated.Image;
import com.amazon.generated.ImageSet;
import com.amazon.generated.Item;
import com.amazon.generated.Item.ImageSets;
import com.amazon.generated.ItemAttributes;
import com.amazon.generated.Price;
import com.amazon.generated.SimilarProducts.SimilarProduct;
import com.amazon.service.ProductsAdvertisingService;
import com.sitegenerator.generator.ProductPresentation;
import com.sitegenerator.pojo.Product;
import com.sitegenerator.pojo.ProductAttributes;
import com.sitegenerator.pojo.ProductReviews;
import com.sitegenerator.pojo.RelatedProduct;
import com.sitegenerator.utils.properties.AmazonPropertiesUtils;

public class ProductDataExtractor {

	private static Logger logger = LoggerFactory.getLogger(ProductDataExtractor.class);

	private ProductsAdvertisingClient client;
	private ProductsAdvertisingService service;

	public void setUp() throws Exception {

		client = new ProductsAdvertisingClient(AmazonPropertiesUtils.AWS_ENDPOINT, AmazonPropertiesUtils.AWS_ACCESS_KEY,
				AmazonPropertiesUtils.AWS_SECRET, AmazonPropertiesUtils.AWS_ASSOCIATES_KEY);
		service = new ProductsAdvertisingService(client);
	}

	public List<Product> findProducts(String keyword) throws Exception {

		setUp();
		logger.debug("FIND PRODUCTS CALLED");

		List<Item> items = service.findProducts(keyword);
		List<Product> producstList = getProductDetails(items);

		ProductPresentation.generateHtmlPage(producstList);

		return producstList;
	}

	public RelatedProduct getRelatedProducts(String keyword) throws Exception {

		List<Item> items = service.findProducts(keyword);
		RelatedProduct relatedProduct = getSimilarProductDetails(items);

		return relatedProduct;

	}

	public List<ProductReviews> extractProductReviews(String id) {

		List<ProductReviews> reviewsList = new ArrayList<>();

		String url = "http://www.amazon.com/product-reviews/" + id + "/?showViewpoints=0&sortBy=byRankDescending&pageNumber=" + 1;

		try {
			Document doc = Jsoup.connect(url).timeout(30000)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2")
					.get();
			Elements description = doc.select(
					"div.a-section.a-spacing-none.reviews.celwidget i.review-rating,a.review-title,a.author,div.a-section.a-spacing-none.reviews.celwidget span.review-date,span.review-text");

			String output = description.html();
			// System.out.println(output);

			String x = output.replace("<span class=\"a-icon-alt\">", "##");
			String y = x.replace("out of 5 stars</span>", "");
			String z = y.replace("<br>", "");

			String[] res = z.split("##");

			ProductReviews pr = null;
			for (String string : res) {
				if (!string.isEmpty()) {

					String[] sec = string.split("\n");

					if (!StringUtils.isEmpty(sec[0])) {
						pr = new ProductReviews();
						pr.setRating(Double.parseDouble(sec[0]));
						pr.setTitle(sec[1]);
						pr.setAuthor(sec[2]);
						pr.setDate(sec[3]);
						pr.setReviewText(sec[4]);
						reviewsList.add(pr);
						reviewsList.removeAll(Collections.singleton(null));
					}
				}
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return reviewsList;
	}

	public String extractProductReviewAvarage(String id) {

		// #customerReviews after the URL

		String url = "http://www.amazon.com/product-reviews/" + id + "/?showViewpoints=0&sortBy=byRankDescending&pageNumber=" + 1;
		try {
			Document doc = Jsoup.connect(url).timeout(30000)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2")
					.get();
			Elements description = doc.select("span.AverageCustomerReviews>i>span");

			String output = description.html();
			String result = output.replace("out of 5 stars", "");
			String result2 = result.replace(" ", "");

			return result2;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public String extractReviewCount(String id) {

		String url = "http://www.amazon.com/product-reviews/" + id + "/?showViewpoints=0&sortBy=byRankDescending&pageNumber=" + 1;
		try {
			Document doc = Jsoup.connect(url).timeout(30000)
					.userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/535.2 (KHTML, like Gecko) Chrome/15.0.874.120 Safari/535.2")
					.get();
			Elements description = doc.select("span.totalReviewCount");

			String output = description.html();

			return output;

		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}

	public RelatedProduct getSimilarProductDetails(List<Item> items) {

		for (Item item : items) {

			RelatedProduct related = new RelatedProduct();
			related.setPrId(item.getASIN());
			related.setPrUrl(item.getDetailPageURL());
			related.setPrName(item.getItemAttributes().getTitle());
			Price price = item.getItemAttributes().getListPrice();
			if (price != null) {
				related.setPrPrice(price.getFormattedPrice());
			}
			related.setPrImgUrl(item.getLargeImage().getURL());

			return related;

		}
		return null;

	}

	public List<Product> getProductDetails(List<Item> items) throws Exception {

		List<Product> productsList = new ArrayList<>();

		for (Item item : items) {

			Product product = new Product();
			ProductAttributes prAttribute = new ProductAttributes();
			ItemAttributes attributes = item.getItemAttributes();
			product.setPrId(item.getASIN());
			product.setPrName(attributes.getTitle());
			Price price = attributes.getListPrice();
			if (price != null) {
				product.setPrPrice(price.getFormattedPrice());
			}

			product.setPrUrl(item.getDetailPageURL());

			EditorialReviews editorialRev = item.getEditorialReviews();
			List<EditorialReview> reviews = editorialRev.getEditorialReview();
			for (EditorialReview editorialReview : reviews) {
				prAttribute.setPrEditorialReview(editorialReview.getContent());
			}
			Image bigImage = item.getLargeImage();
			if (bigImage != null) {
				product.setPrImgUrl(bigImage.getURL());
			}

			List<ImageSets> imagesSets = item.getImageSets();
			for (ImageSets imageSets : imagesSets) {
				List<ImageSet> set = imageSets.getImageSet();
				List<String> itemImages = new ArrayList<>();
				for (ImageSet imageSet : set) {

					itemImages.add(imageSet.getLargeImage().getURL());
					prAttribute.setPrImageSetUrl(itemImages);

				}
			}

			if (item.getItemAttributes().getItemDimensions().equals(null)) {

				DecimalWithUnits length = item.getItemAttributes().getItemDimensions().getLength();
				DecimalWithUnits width = item.getItemAttributes().getItemDimensions().getWidth();
				DecimalWithUnits height = item.getItemAttributes().getItemDimensions().getHeight();

				String resultLength = (length.getValue().divide(new BigDecimal(100)).toString());
				String resultWidth = (width.getValue().divide(new BigDecimal(100)).toString());
				String resultHeight = (height.getValue().divide(new BigDecimal(100)).toString());
				prAttribute.setProductDimensions(resultLength + " x " + resultWidth + " x " + resultHeight + " inches");
			}

			DecimalWithUnits weight = item.getItemAttributes().getItemDimensions().getWeight();
			String resultWeight = (weight.getValue().divide(new BigDecimal(100)).toString());
			prAttribute.setProductWeight(resultWeight + " pounds");

			prAttribute.setPrFeatures(item.getItemAttributes().getFeature());
			prAttribute.setPrBrand(attributes.getBrand());
			prAttribute.setPrBinding(item.getItemAttributes().getBinding());
			prAttribute.setPrEdition(item.getItemAttributes().getEdition());
			prAttribute.setPrHardwarePlatform(item.getItemAttributes().getHardwarePlatform());
			prAttribute.setPrGenre(item.getItemAttributes().getGenre());
			prAttribute.setPrPublicationDate(attributes.getPublicationDate());
			prAttribute.setPrManufacturer(attributes.getManufacturer());
			prAttribute.setPrLabel(attributes.getLabel());
			prAttribute.setPrPublisher(attributes.getPublisher());
			prAttribute.setPrColor(attributes.getColor());
			prAttribute.setPrGroup(attributes.getProductGroup());
			prAttribute.setPrModel(attributes.getModel());
			if (attributes.getPackageQuantity() != null) {
				prAttribute.setPrPackageQuantity(attributes.getPackageQuantity().toString());
			}

			prAttribute.setPrPublisher(attributes.getPublisher());
			prAttribute.setPrSalesRank(item.getSalesRank());
			prAttribute.setPrTypeName(attributes.getProductTypeName());
			prAttribute.setPrWarranity(attributes.getWarranty());

			List<ProductReviews> reviewsList = extractProductReviews(item.getASIN());
			for (ProductReviews productReviews : reviewsList) {
				productReviews.setPrId(item.getASIN());
			}
			List<RelatedProduct> relatedProducts = new ArrayList<>();

			// if (item.getSimilarProducts().getSimilarProduct() != null) {
			// List<SimilarProduct> similar =
			// item.getSimilarProducts().getSimilarProduct();
			// for (SimilarProduct similarProduct : similar) {
			// relatedProducts.add(getRelatedProducts(similarProduct.getASIN()));
			//
			// }
			// product.setRelatedProductsList(relatedProducts);
			// }

			prAttribute.setProductReviewsCount(extractReviewCount(item.getASIN()));
			prAttribute.setProductReviewsRateAvarage(extractProductReviewAvarage(item.getASIN()));
			prAttribute.setPrId(item.getASIN());
			product.setAttributes(prAttribute);
			product.setProductReview(reviewsList);
			productsList.add(product);
		}
		return productsList;
	}
}
