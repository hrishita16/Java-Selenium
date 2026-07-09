package gettingStarted3;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collection;
import java.util.Properties;
import java.util.Set;

public class ReadingPropertiesFile {
	
	public static void readPropertiesDemo() throws IOException {
		Properties prop = new Properties();
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\testdata\\config.properties");
		
		prop.load(file);
		
		String appUrl = prop.getProperty("appurl");
		String email = prop.getProperty("email");
		String password = prop.getProperty("password");
		String orderId = prop.getProperty("orderid");
		String customerid = prop.getProperty("customerid");
		
		
		//reading all the keys from property file
		Set<String> keys = prop.stringPropertyNames();
		System.out.println(key);
		
		//same keys can be read in another way
		Set<Object> propKeys = prop.keySet();
		System.out.println(propKeys);
		
		//reading all values from property file
		Collection<Object> values = prop.values();
		System.out.println(values);
		
		file.close();
	}

}
