package com.sitegenerator.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import com.sitegenerator.dao.ProductDataExtractor;

public class ProductsTest {

	public static void main(String[] args) throws UnsupportedEncodingException {

		// ProductDataExtractor extract = new ProductDataExtractor();
		// try {
		// extract.setUp();
		// extract.findProducts(null, null);
		// } catch (Exception e) {
		// e.printStackTrace();
		// }
		// try {
		// HtmlGenerator.generateHtmlPage(null, null, null, null, null, null,
		// null, null, null, null, null);
		// } catch (IOException e) {
		// // TODO Auto-generated catch block
		// e.printStackTrace();
		// }

		String url = "http://www.amazon.com/Omron-Wireless-Pressure-Wide-Range-BP786/dp/B00KW4PO82/ref=sr_1_1_s_it?s=hpc&ie=UTF8&qid=1457765301&sr=1-1&keywords=blood+pressure+cuff&refinements=p_n_feature_keywords_browse-bin%3A4862741011%2Cp_72%3A1248903011";
		String strin1 = url.substring(url.indexOf("dp"));
		String string2 = strin1.substring(3, 13);
		System.out.println(string2);
	}
}
