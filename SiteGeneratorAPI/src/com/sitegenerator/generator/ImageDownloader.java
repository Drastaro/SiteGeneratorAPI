package com.sitegenerator.generator;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

public class ImageDownloader {

	public static String downloadImage(String url) throws IOException {

		URL ImageUrl = new URL(url);
		BufferedImage image = ImageIO.read(ImageUrl);

		String imageName = url.substring(url.lastIndexOf("/") + 1, url.length());

		ImageIO.write(image, "png", new File("d://Development/Utils/WAMP/wamp/www/smart/products/" + imageName));

		return imageName;
	}
}
