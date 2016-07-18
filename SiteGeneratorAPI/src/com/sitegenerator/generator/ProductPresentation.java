package com.sitegenerator.generator;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import com.sitegenerator.pojo.Product;
import com.sitegenerator.pojo.ProductReviews;

public class ProductPresentation {

	public static void generateHtmlPage(List<Product> producstList) throws IOException {

		for (Product product : producstList) {

			File f = new File("d:/Development/GeneratedHTML/" + product.getPrId() + ".html");
			BufferedWriter bw = new BufferedWriter(new FileWriter(f));

			bw.write("<body>");
			bw.newLine();
			bw.write("<div class=\"content\">");
			bw.newLine();

			bw.write("<div class=\"product-title-container\">");
			bw.newLine();
			bw.write("<h2 class=\"product-title\">" + product.getPrName() + " Review" + "</h2>");
			bw.write("</div>");
			bw.newLine();

			//
			bw.write("<div class=\"presentation-features\">");
			bw.newLine();
			bw.write("<div class=\"row\">");
			bw.newLine();
			bw.write("<div class=\"col-md-12\">");
			bw.newLine();
			bw.write("<div class=\"col-md-4\">");
			bw.newLine();
			bw.write("<a href=" + product.getPrUrl() + "><img src=" + product.getPrImgUrl() + " alt=" + product.getPrName()
					+ " class=\"image-responsive\"style=\"width:100%;height:100%;\"/></a>");
			bw.write("</div>");
			bw.newLine();
			bw.write("<div class=\"col-md-8\">");
			bw.newLine();
			List<String> featuresList = product.getAttributes().getPrFeatures();
			bw.write("<ul>");
			bw.newLine();
			for (String string : featuresList) {
				bw.write("<li>" + string + "</li>");
				bw.newLine();
			}
			bw.write("</ul>");
			bw.write("<a href=" + product.getPrUrl()
					+ "><button type=\"button\" class=\"btn btn-primary\" >Check BEST price available</button></a>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			//
			// container 1 end

			bw.write("<div class=\"presentation-editorial-review\">");
			bw.newLine();
			bw.write("<div class=\"row\">");
			bw.newLine();
			bw.write("<div class=\"col-md-12\">");
			bw.newLine();
			bw.write("<div class=\"col-md-8\">");
			bw.newLine();
			bw.write("<p>" + product.getAttributes().getPrEditorialReview() + "</p>");
			bw.write("</div>");
			bw.newLine();
			bw.write("<div class=\"col-md-4\">");
			bw.newLine();
			if (product.getAttributes().getPrImageSetUrl().size() > 0) {

				bw.write("<a href=" + product.getPrUrl() + "><img alt=\"" + product.getPrName()
						+ "\" \" class=\"presentation-img2\"src=\"/products/"
						+ ImageDownloader.downloadImage(product.getAttributes().getPrImageSetUrl().get(0))
						+ "\" class=\"image-responsive\"style=\"width:100%;height:100%;\"/></a>");
			}
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			// container 2 end

			bw.write("<div class=\"presentation-table\">");
			bw.newLine();
			bw.write("<div class=\"row\">");
			bw.newLine();
			bw.write("<div class=\"col-md-12\">");
			bw.newLine();
			if (product.getAttributes().getPrImageSetUrl().size() > 1) {

				bw.write("<div class=\"col-md-6\">");
				bw.newLine();
				bw.write(
						"<a href=" + product.getPrUrl() + "><img alt=" + product.getPrName() + "class=\"presentation-img3\"src=\"/products/"
								+ ImageDownloader.downloadImage(product.getAttributes().getPrImageSetUrl().get(1))
								+ "\" class=\"image-responsive\"style=\"width:100%;height:100%;\"/></a>");
				bw.write("</div>");
				bw.newLine();
				bw.write("<div class=\"col-md-6\">");
				bw.newLine();
				bw.write("<table class=\"table table-bordered\">");
				bw.newLine();
				bw.write("<tbody>");
				bw.newLine();

				if (product.getAttributes().getPrBrand() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Brand name:</td>");
					bw.write("<td>" + product.getAttributes().getPrBrand() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				if (product.getAttributes().getPrModel() != null) {
					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Model Number:</td>");
					bw.write("<td>" + product.getAttributes().getPrModel() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				if (product.getAttributes().getPrSalesRank() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Sales Rank:</td>");
					bw.write("<td>" + product.getAttributes().getPrSalesRank() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				if (product.getAttributes().getPrColor() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Color:</td>");
					bw.write("<td>" + product.getAttributes().getPrColor() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				if (product.getAttributes().getPrWarranity() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Warranity:</td>");
					bw.write("<td>" + product.getAttributes().getPrWarranity() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				if (product.getAttributes().getPrPublicationDate() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Warranity:</td>");
					bw.write("<td>" + product.getAttributes().getPrPublicationDate() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				bw.write("</tbody>");
				bw.newLine();
				bw.write("</table>");
				bw.newLine();

				bw.write("</div>");
				bw.newLine();
			} else {
				bw.write("<table class=\"table table-bordered\">");
				bw.newLine();
				bw.write("<tbody>");
				bw.newLine();

				bw.write("<tr>");
				bw.newLine();
				bw.write("<td>Brand name:</td>");
				bw.write("<td>" + product.getAttributes().getPrBrand() + "</td>");
				bw.write("</tr>");
				bw.newLine();
				bw.write("<tr>");
				bw.newLine();
				bw.write("<td>Model Number:</td>");
				bw.write("<td>" + product.getAttributes().getPrModel() + "</td>");
				bw.write("</tr>");
				bw.newLine();
				bw.write("<tr>");
				bw.newLine();
				bw.write("<td>Sales Rank:</td>");
				bw.write("<td>" + product.getAttributes().getPrSalesRank() + "</td>");
				bw.write("</tr>");
				bw.newLine();
				bw.write("<tr>");
				bw.newLine();
				bw.write("<td>Color:</td>");
				bw.write("<td>" + product.getAttributes().getPrColor() + "</td>");
				bw.write("</tr>");
				bw.newLine();
				if (product.getAttributes().getPrWarranity() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Warranity:</td>");
					bw.write("<td>" + product.getAttributes().getPrWarranity() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}
				if (product.getAttributes().getPrPublicationDate() != null) {

					bw.write("<tr>");
					bw.newLine();
					bw.write("<td>Warranity:</td>");
					bw.write("<td>" + product.getAttributes().getPrPublicationDate() + "</td>");
					bw.write("</tr>");
					bw.newLine();
				}

				bw.write("</tbody>");
				bw.newLine();
				bw.write("</table>");
				bw.newLine();
			}

			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			// container 3 end

			bw.write("<div class=\"presentation-customer-reviews\">");
			bw.newLine();
			bw.write("<div class=\"row\">");
			bw.newLine();
			bw.write("<div class=\"col-md-12\">");
			bw.newLine();
			List<ProductReviews> customerReviews = product.getProductReview();
			for (ProductReviews productReviews : customerReviews) {
				bw.write("<h5>" + productReviews.getTitle() + "</h5>");
				bw.newLine();
				String rating = Double.toString(productReviews.getRating());
				String ratingFormatted = rating.replace(".", "");
				bw.write("<span class=\"rating-static rating-" + ratingFormatted + "\"></span>");
				bw.newLine();

				bw.write("<p>" + productReviews.getAuthor() + productReviews.getDate() + "</p>");
				bw.newLine();
				bw.write("<br>");
				bw.write("<p>" + productReviews.getReviewText() + "</p>");
				bw.newLine();
			}

			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			bw.write("</div>");
			bw.newLine();
			// container 4 end

			// content end
			bw.write("</div>");
			bw.newLine();
			bw.write("</body>");
			bw.newLine();

			System.out.println("HTML File Generated!");
			bw.close();
		}
	}
}