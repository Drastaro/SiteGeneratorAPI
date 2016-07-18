package com.sitegenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.ThreadLocalRandom;

import com.sitegenerator.pojo.Product;
import com.sitegenerator.pojo.ProductReviews;

public class ProductComparation {

	public static List<Product> sortProductsByPrice(Set<Product> productsList) {

		List<Product> newList = new ArrayList<>();

		for (Product product : productsList) {
			if (product.getPrPrice() != null)
				newList.add(product);

		}

		Collections.sort(newList, (o1, o2) -> Double.compare(Double.parseDouble(o1.getPrPrice().replace("$", "")),
				Double.parseDouble(o2.getPrPrice().replace("$", ""))));

		return newList;
	}

	public static void generateCheapests(Set<Product> productsList) throws IOException {

		List<Product> producsts = sortProductsByPrice(productsList);
		List<Product> newList = new ArrayList<>();
		for (Product product : producsts) {
			System.out.println(product.getPrPrice());
		}
		newList.add(producsts.get(0));
		newList.add(producsts.get(1));
		newList.add(producsts.get(2));
		newList.add(producsts.get(3));
		newList.add(producsts.get(4));

		generateComparePage(newList);
	}

	public static void generateExpensive(Set<Product> productsList) throws IOException {

		List<Product> producsts = sortProductsByPrice(productsList);
		Collections.reverse(producsts);

		List<Product> newList = new ArrayList<>();
		newList.add(producsts.get(0));
		newList.add(producsts.get(1));
		newList.add(producsts.get(2));
		newList.add(producsts.get(3));
		newList.add(producsts.get(4));

		generateComparePage(newList);
	}

	public static void generateRandom(Set<Product> productsList) throws IOException {

		List<Product> producsts = new ArrayList<>(productsList);
		ArrayList<Integer> numbers = new ArrayList<Integer>();
		for (int i = 0; i < producsts.size(); i++) {
			numbers.add(i + 1);
		}
		Collections.shuffle(numbers);
		List<Product> newList = new ArrayList<>();
		newList.add(producsts.get(numbers.get(0)));
		newList.add(producsts.get(numbers.get(1)));
		newList.add(producsts.get(numbers.get(2)));
		newList.add(producsts.get(numbers.get(3)));
		newList.add(producsts.get(numbers.get(4)));

		generateSmartComparePage(newList);
	}

	public static void generateComparePage(List<Product> producstList) throws IOException {

		File f = new File("d:/Development/GeneratedHTML/" + producstList.get(0).getPrId() + "-" + producstList.get(1).getPrId()
				+ producstList.get(2).getPrId() + "-" + producstList.get(3).getPrId() + ".html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));

		bw.write("<body>");
		bw.newLine();
		bw.write("<div class=\"content\">");
		bw.newLine();

		// compare starts

		bw.write("<section id=\"pricePlans\">");
		bw.newLine();
		bw.write("<div class=\"row\">");
		bw.newLine();
		bw.write("<ul id=\"plans\">");
		bw.newLine();

		for (Product product : producstList) {

			/*
			 * this part repareats
			 */

			bw.write("<li class=\"plan\">");
			bw.newLine();
			bw.write("<ul class=\"planContainer\">");
			bw.newLine();
			bw.write("<li class=\"title\"><h2 class=\"bestPlanTitle\">" + product.getPrName() + "</h2></li>"); // product
																												// name
			bw.newLine();

			bw.write("<a href=" + product.getPrUrl() + "><img alt=" + product.getPrName() + "class=\"responsive\" src=\"/products/"
					+ ImageDownloader.downloadImage(product.getPrImgUrl()) + "\" /></a>"); // product
			bw.newLine(); // image

			bw.write("<li class=\"button\"><a href=" + product.getPrUrl() + ">Check price</a></li>"); // product
			bw.newLine(); // amazon
			// link
			bw.write("<li>");
			bw.newLine();
			bw.write("<ul class=\"options pros\">");
			bw.newLine();
			bw.write("<li class=\"first-row\"><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// pro's
			bw.write("<li><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// pro's
			bw.write("<li><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum </li>"); // product
			bw.newLine();

			// pro's
			bw.write("<li><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// pro's
			bw.write("<li><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// pro's
			bw.write("<li><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// pro's
			bw.write("<li class=\"last-row\"><i class=\"fa fa-thumbs-up\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// pro's
			bw.write("</ul>");
			bw.newLine();
			bw.write("<ul class=\"options cons\">");
			bw.newLine();
			bw.write("<li class=\"first-row\"><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("<li><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("<li><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("<li><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("<li><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("<li><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("<li class=\"last-row\"><i class=\"fa fa-thumbs-down\" aria-hidden=\"true\"></i> Lore ipsum</li>"); // product
			bw.newLine();
			// con's
			bw.write("</ul>");
			bw.newLine();
			bw.write("<ul class=\"options bottom-line\">");
			bw.newLine();
			bw.write("<li class=\"first-row\"><i class=\"fa fa-check-circle\"></i>" + product.getAttributes().getPrFeatures().get(0)
					+ "</li>"); // product
			bw.newLine(); // editorial
			// review
			// line
			// 1
			bw.write("</ul>");
			bw.newLine();
			bw.write("</li>");
			bw.newLine();
			bw.write("</ul>");
			bw.newLine();
			bw.write("</li>");
			bw.newLine();

		}

		bw.write("</ul>");
		bw.newLine();
		bw.write("</div>");
		bw.newLine();
		bw.write("</section>");
		bw.newLine();

		// compare ends

		// product details

		bw.write("<section id=\"product-details\">");
		bw.newLine();

		for (Product product2 : producstList) {

			bw.write("<div class=\"row\">");
			bw.newLine();
			bw.write("<div class=\"col-md-12\" style=\"width:90%\">");
			bw.newLine();
			bw.write("<a href=" + product2.getPrUrl() + "><h2 class=\"product-details-product-title\">" + product2.getPrName()
					+ "</h2></a>");
			bw.newLine();
			bw.write("<div class=\"col-md-8 product-details-features\">");
			bw.newLine();
			List<String> featuresList = product2.getAttributes().getPrFeatures();
			bw.write("<ul>");
			bw.newLine();
			for (String string : featuresList) {
				bw.write("<li>" + string + "</li>");
				bw.newLine();
			}
			bw.write("</ul>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("<div class=\"col-md-4\">");
			bw.newLine();
			List<String> imageSet = product2.getAttributes().getPrImageSetUrl();
			if (imageSet.get(0) != null) {
				bw.write("<a href=" + product2.getPrUrl() + "><img alt=" + product2.getPrName() + "class=\"responsive\" src=\"/products/"
						+ ImageDownloader.downloadImage(imageSet.get(0)) + " \" style=\"width:100%;height:100%\"/></a>");
			}

			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();

			bw.write("<div class=\"row\">");
			bw.newLine();
			bw.write("<div class=\"col-md-12\" style=\"width:90%\">");
			bw.newLine();
			bw.write("<div class=\"col-md-4\">");
			bw.newLine();
			if (imageSet.size() > 1) {
				bw.write("<a href=" + product2.getPrUrl() + "><img alt=" + product2.getPrName() + "class=\"responsive\" src=\"/products/"
						+ ImageDownloader.downloadImage(imageSet.get(1)) + " \" style=\"width:100%;height:100%\"/></a>");
			}

			bw.newLine();

			bw.write("</div>");
			bw.newLine();
			bw.write("<div class=\"col-md-8\">");
			bw.newLine();
			bw.write("<p>" + product2.getAttributes().getPrEditorialReview() + "</p>");
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();

			bw.write("<div class=\"presentation-customer-reviews\">");
			bw.newLine();

			bw.write("<div class=\"col-md-12\">");
			bw.newLine();
			List<ProductReviews> customerReviews = product2.getProductReview();
			if (customerReviews.size() != 0 && customerReviews.size() >= 3) {

				for (int i = 0; i < 3; i++) {

					bw.write("<h5>" + customerReviews.get(i).getTitle() + "</h5>");
					bw.newLine();
					String rating = Double.toString(customerReviews.get(i).getRating());
					String ratingFormatted = rating.replace(".", "");
					bw.write("<span class=\"rating-static rating-" + ratingFormatted + "\"></span>");
					bw.newLine();

					bw.write("<p>" + customerReviews.get(i).getAuthor() + customerReviews.get(i).getDate() + "</p>");
					bw.newLine();
					bw.write("<br>");
					bw.write("<p>" + customerReviews.get(i).getReviewText() + "</p>");
					bw.newLine();

				}
			}

			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();

		}

		bw.write("</section>");
		bw.newLine();

		// product details end

		bw.write("</div>");
		bw.newLine();
		bw.write("</body>");
		bw.newLine();

		System.out.println("HTML File Generated!");
		bw.close();
	}

	public static void generateSmartComparePage(List<Product> producstList) throws IOException {

		File f = new File("d:/Development/GeneratedHTML/" + producstList.get(0).getPrId() + "-" + producstList.get(1).getPrId()
				+ producstList.get(2).getPrId() + "-" + producstList.get(3).getPrId() + ".html");
		BufferedWriter bw = new BufferedWriter(new FileWriter(f));

		bw.write("<body>");
		bw.newLine();
		bw.write("<div class=\"inner-xs\">");
		bw.newLine();
		bw.write("<div class=\"page-header\">");
		bw.newLine();
		bw.write("<h2 class=\"page-title\">Product Comparison </h2>");
		bw.newLine();
		bw.write("</div>");
		bw.newLine();
		bw.write("</div>");
		bw.newLine();

		// title end

		bw.write("<div class=\"table-responsive inner-bottom-xs inner-top-xs\">");
		bw.newLine();
		bw.write("<table class=\"table table-bordered table-striped compare-list\">");
		bw.newLine();
		bw.write("<thead>");
		bw.newLine();
		bw.write("<tr>");
		bw.newLine();
		bw.write("<td>&nbsp;</td>");
		bw.newLine();

		for (Product product : producstList) {

			bw.write("<td class=\"text-center\">");
			bw.newLine();
			bw.write("<div class=\"image-wrap\">");
			bw.newLine();
			bw.write("<a data-product_id=\"39\" href=\"" + product.getPrUrl() + "\" class=\"remove-link\"></a>");
			bw.newLine();
			bw.write("<a href=\"" + product.getPrUrl() + "\"><img width=\"220\" height=\"154\" alt=\"" + product.getPrName()
					+ "\" class=\"attachment-yith-woocompare-image\" src=\"/products/"
					+ ImageDownloader.downloadImage(product.getPrImgUrl()) + "\"></a>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("<a href=\"" + product.getPrUrl() + "\"><p><strong>" + product.getPrName() + "</strong></p></a>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// check price button

		bw.write("<tr class=\"tr-add-to-cart\">");
		bw.newLine();
		bw.write("<td>&nbsp;</td>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"text-center\">");
			bw.newLine();
			bw.write("<div class=\"add-cart-button\">");
			bw.newLine();
			bw.write("<a class=\"le-button add_to_cart_button  product_type_simple\" href=\"" + product.getPrUrl() + "\">Check Price</a>");
			bw.newLine();
			bw.write("</div> ");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.write("</thead>");

		// body

		bw.write("<tbody>");
		bw.newLine();
		bw.write("<tr class=\"comparison-item price\">");
		bw.newLine();
		bw.write("<th>Rating</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd \">");
			bw.newLine();
			Double rating = Double.parseDouble(product.getAttributes().getProductReviewsRateAvarage());
			Integer ratingFormat = rating.intValue();
			for (int i = 1; i <= ratingFormat; i++) {
				bw.write("<span class=\"star-rating\"></span>");

			}

			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// id

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>SKU</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getPrId() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// sales rank

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Sales Rank</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getPrSalesRank() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// stock

		bw.write("<tr class=\"comparison-item stock\">");
		bw.newLine();
		bw.write("<th>Availability</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label-success\"><span class=\"\">In stock</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// brand

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Brand</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getPrBrand() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// model

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Model</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getPrModel() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// color

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Color</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getPrColor() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// warranity

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Warranity</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getPrWarranity() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// weight

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Weight</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getProductWeight() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// dimensions

		bw.write("<tr class=\"comparison-item\">");
		bw.newLine();
		bw.write("<th>Dimensions</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<span class=\"label label2\"><span class=\"\">" + product.getAttributes().getProductDimensions() + "</span></span>");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();

		// description

		bw.write("<tr class=\"comparison-item description\">");
		bw.newLine();
		bw.write("<th>Description</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"comparison-item-cell odd product_39\">");
			bw.newLine();
			bw.write("<p>" + "short description" + "</p>");
			bw.write("</td>");
			bw.newLine();

		}
		bw.write("</tr>");
		bw.newLine();

		// button repeated

		bw.write("<tr class=\"price repeated\">");
		bw.newLine();
		bw.write("<th>Details</th>");
		bw.newLine();
		for (Product product : producstList) {
			bw.write("<td class=\"text-center\">");
			bw.newLine();
			bw.write("<div class=\"add-cart-button\">");
			bw.newLine();
			bw.write("<a class=\"le-button add_to_cart_button  product_type_simple\" href=\"" + product.getPrUrl() + "\">Check Price</a>");
			bw.newLine();
			bw.write("</div> ");
			bw.newLine();
			bw.write("</td>");
			bw.newLine();
		}
		bw.write("</tr>");
		bw.newLine();
		bw.write("</tbody>");
		bw.newLine();
		bw.write("</table>");
		bw.newLine();
		bw.write("</div>");
		bw.newLine();

		bw.write("<div class=\"product-details\">");
		bw.newLine();
		for (Product product : producstList) {

			bw.write("<div class=\"col-md-12 \">");
			bw.write("<a href=\"" + product.getPrUrl() + "\"><h2>" + product.getPrName() + "</h2></a>");
			bw.newLine();
			bw.newLine();
			bw.write("<div class=\"col-md-4\">");
			bw.newLine();
			List<String> imageSet = product.getAttributes().getPrImageSetUrl();

			bw.write("<img alt=\"" + product.getPrName() + "\" src=\"/products/" + ImageDownloader.downloadImage(imageSet.get(0))
					+ "\"></a>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("<div class=\"col-md-8\">");
			bw.newLine();
			List<String> featuresList = product.getAttributes().getPrFeatures();
			bw.write("<p>" + featuresList.toString() + "</p>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();

			bw.write("<div class=\"col-md-12\">");
			bw.newLine();
			bw.write("<div class=\"col-md-8\">");
			bw.newLine();
			bw.write("<p>" + product.getAttributes().getPrEditorialReview() + "</p>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.newLine();
			bw.write("<div class=\"col-md-4\">");
			bw.newLine();
			bw.write("<img alt=\"" + product.getPrName() + "\" src=\"/products/" + ImageDownloader.downloadImage(imageSet.get(1))
					+ "\"></a>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();

			bw.write("</div>");
			bw.newLine();

		}

		bw.write("</div>");
		bw.newLine();
		bw.write("</body>");
		bw.newLine();

		System.out.println("HTML File Generated!");
		bw.close();
	}
}
