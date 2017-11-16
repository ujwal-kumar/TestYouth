package com.pack.home.Libraries;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverLaunch {

	private WebDriver driver;
	private static String OS = System.getProperty("os.name").toLowerCase();
	private static String currentDir = System.getProperty("user.dir");

	public WebDriver openBrowser(String browser) {
		try {

			if (browser.equalsIgnoreCase("Firefox")) {
				System.out.println("Selected browser is Firefox");
				driver = new FirefoxDriver();
			} else if (browser.equalsIgnoreCase("chrome")) {
				System.out.println("Selected browser is Chrome");
				detectOS();
				driver = new ChromeDriver();
			} else if (browser.equalsIgnoreCase("IE")) {
				System.out.println("Selected browser is Internet Explorer");
				System.setProperty("webdriver.ie.driver",
						"" + currentDir + "" + "/src/com/pack/home/AllDrivers/IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}

		} catch (WebDriverException e) {
			System.out.println(e.getMessage());
		}

		// Maximize the window
		driver.manage().window().maximize();

		return driver;
	}

	public static void detectOS() {		
		if (isWindows()) {			
			System.setProperty("webdriver.chrome.driver","" + currentDir + "" + "/src/main/java/com/pack/home/AllDrivers/chromedriver_win32/chromedriver.exe");
		} else if (isMac()) {
			System.setProperty("webdriver.chrome.driver","" + currentDir + "" + "/src/main/java/com/pack/home/AllDrivers/chromedriver_mac64/chromedriver");
		} else if (isUnix()) {
			System.setProperty("webdriver.chrome.driver","" + currentDir + "" + "/src/main/java/com/pack/home/AllDrivers/chromedriver_linux64/chromedriver");
		} else {

		}
		
	}

	private static boolean isWindows() {
		return (OS.indexOf("win") >= 0);
	}

	private static boolean isMac() {
		return (OS.indexOf("mac") >= 0);
	}

	private static boolean isUnix() {
		return (OS.indexOf("nux") >= 0);
	}
}
