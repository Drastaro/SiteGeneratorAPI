package com.sitegenerator.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.log4j.Logger;

public class AmazonPropertiesUtils {

	public static final Logger LOG = Logger.getLogger(AmazonPropertiesUtils.class);

	public static Properties propConfig = null;
	public static String PROP_FILE = "amazon.properties";

	public static String AWS_ACCESS_KEY;
	public static String AWS_SECRET;
	public static String AWS_ENDPOINT;
	public static String AWS_ASSOCIATES_KEY;

	static {
		try {

			Properties propConfig = new Properties();
			InputStream input = null;

			input = Thread.currentThread().getContextClassLoader().getResourceAsStream(PROP_FILE);

			// load properties file
			propConfig.load(input);

			AWS_ACCESS_KEY = propConfig.getProperty("aws_acces_key");
			AWS_SECRET = propConfig.getProperty("aws_secret");
			AWS_ENDPOINT = propConfig.getProperty("aws_endpoint");
			AWS_ASSOCIATES_KEY = propConfig.getProperty("aws_associates_key");

		} catch (IOException e) {
			LOG.error("Properties File can not be loaded!!! " + e.getLocalizedMessage());
		}

	}

}
