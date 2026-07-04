package com.orangehrm.utilities;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

//public class ConfigReader {
//	public static Properties prop;
//	
//	public static void loadConfig() throws IOException {
//		prop = new Properties();
//		FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
//		prop.load(fis);
//		
//	}
//	public static String getProperty(String key) {
//		return prop.getProperty(key);
//	}
//
//}


public class ConfigReader {
    private static Properties prop;

    public static void loadConfig() {
        try {
            FileInputStream fis = new FileInputStream("src/test/resources/config.properties");
            prop = new Properties();
            prop.load(fis);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String key) {
        return prop.getProperty(key);
    }
}
