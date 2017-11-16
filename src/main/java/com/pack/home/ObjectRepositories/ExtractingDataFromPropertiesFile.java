package com.pack.home.ObjectRepositories;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ExtractingDataFromPropertiesFile {
	public static Properties extractData(String PageName) throws IOException {

		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "/src/main/resources/" + PageName + ".properties");
		Properties proObj = new Properties();
		proObj.load(fis);
		return proObj;

	}
}
