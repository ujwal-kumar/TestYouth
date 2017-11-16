package com.pack.home.TestExecution;

import java.io.IOException;

import org.openqa.selenium.*;
import org.testng.Assert;
import org.testng.annotations.*;

import com.pack.home.Libraries.DriverLaunch;
import com.pack.home.Libraries.LibraryForGenericFunction;


public class TestRun {
	DriverLaunch Dlib = new DriverLaunch();
	public static WebDriver driver;	
	LibraryForGenericFunction lib = null;

	@BeforeTest
	public void executing() throws InterruptedException, IOException {
		driver = Dlib.openBrowser("chrome");
		lib = new LibraryForGenericFunction(driver);
		// Application link will be opened
		driver.get("http://69.176.98.99:9356/admin");
	}
	
	
	@Test(priority = 1, description="Email cannot be blank (passes)")
    public void login1() throws InterruptedException, IOException {
        lib.jsSendKeysForID("username", " ", "login", "ID");
        lib.waitAndClickForID("password", "login", "ID");
        Thread.sleep(2000);
      Assert.assertEquals(lib.getText("errormesg", "login", "class"), "Email cannot be blank.");
                 
    }
	
	@Test(priority = 2, description="Password cannot be blank.")
    public void login2() throws InterruptedException, IOException {
        lib.jsSendKeysForID("username", "admin@youthinc.com", "login", "ID");
        lib.jsSendKeysForID("password", " ", "login", "ID");
        lib.waitAndClickForID("login", "login", "name");
        Thread.sleep(2000);
	}    
	
	
	@Test(priority = 3, description="Performs an unsuccessful login invalid password ")
    public void login3() throws InterruptedException, IOException {
        lib.jsSendKeysForID("username", "admin@youthinc.com", "login", "ID");
        lib.jsSendKeysForID("password", "admi", "login", "ID");
        Assert.assertTrue(lib.waitAndClickForID("login", "login", "name"));
        Thread.sleep(2000);
        Assert.assertEquals(lib.getCurrentUrl(),"http://69.176.98.99:9356/admin/dashboard");
	}    
	
	@Test(priority = 4, description="Performs an unsuccessful login invalid username ")
    public void login4() throws InterruptedException, IOException {
        lib.jsSendKeysForID("username", "admi@youthinc.com", "login", "ID");
        lib.jsSendKeysForID("password", "admin", "login", "ID");
        Assert.assertTrue(lib.waitAndClickForID("login", "login", "name"));
        Thread.sleep(2000);
        Assert.assertEquals(lib.getCurrentUrl(),"http://69.176.98.99:9356/admin/dashboard");
	}    
	
	/*@Test(priority = 5, description="Performs an successful login and checks the dashboard url")
    public void login5() throws InterruptedException, IOException {
        lib.jsSendKeysForID("username", "admin@youthinc.com", "login", "ID");
        lib.jsSendKeysForID("password", "admin", "login", "ID");
        Assert.assertTrue(lib.waitAndClickForID("login", "login", "name"));
        Thread.sleep(5000);
        Assert.assertEquals(lib.getCurrentUrl(),"http://69.176.98.99:9356/admin/dashboard");
	}    
	*/
		  
	
	@AfterTest()
	public void afterMethod() throws IOException {
		driver.quit();		
	}	
}
