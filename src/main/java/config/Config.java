package config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Config {

	
	
	// load properties
	
	public static Properties prop;
	static FileInputStream fis ;
	private static String filePath = System.getProperty("user.dir")+"\\src\\main\\resources\\config\\config.properties";
	
	public static Properties loadProps() {
		prop = new Properties();
		try {
			fis = new FileInputStream(filePath);
			prop.load(fis);
			fis.close();
		} catch (IOException e) {
			System.out.println("File Not found" + e.getStackTrace());
		}
		return prop;
	}
	
	
	
	
	
	
	
	
	
}
