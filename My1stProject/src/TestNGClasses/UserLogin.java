package TestNGClasses;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;

public class UserLogin {
	
	public WebDriver driver;
	
	
	@BeforeMethod
	  public void beforeMethod() {
		  
		   System.setProperty("webdriver.chrome.driver","D:\\Automation_java\\ChromeDriver\\chromedriver.exe");
		  driver = new ChromeDriver();
		  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		  driver.manage().window().maximize();
		  System.out.println("Before Method");
	  }

	
  @Test
  public void normal_user_login() throws InterruptedException {
	  System.out.println("Inside Class");
	  driver.get("http://test.livepools.com/");
	  driver.findElement(By.id("emailid")).sendKeys("su12kadam@gmail.com");
      driver.findElement(By.id("password")).sendKeys("Test1234");
      driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[2]/div/a[2]")).click();
      System.out.println("User login successfully");  
      
     
      
      
      WebElement element = driver.findElement(By.id("userName"));
	     Actions action = new Actions(driver);
	     action.moveToElement(element).build().perform();
	     driver.findElement(By.linkText("Logout")).click();
		 System.out.println("---");
	     System.out.println("Logout action performed");
      
      
  }
  
//  @Test(priority = 2)
//  public void facebook_login() throws InterruptedException
//  {
//	  System.out.println("Click on facebook button........");
//	  driver.get("https://play.livepools.com/login.html");
//      driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[1]/div/a[2]")).click();
//      
//      
//      String mainWindow = driver.getWindowHandle();
//      Set<String> set = driver.getWindowHandles();
//      
//      Iterator<String> itr = set.iterator();
//      while (itr.hasNext())
//      {
//      	String childWindow=itr.next();
//      	
//      	if(!mainWindow.equals(childWindow))
//      	{
//      		 driver.switchTo().window(childWindow);
//      		 System.out.println(driver.switchTo().window(childWindow).getTitle());
//      		 driver.findElement(By.id("email")).sendKeys("siddheshkedari31@gmail.com");
//      	        driver.findElement(By.id("pass")).sendKeys("devsid@9665hello.");
//      	        driver.findElement(By.id("u_0_0")).click();
//      	}
//      } 
//      
//      Thread.sleep(1000);
//      WebElement element = driver.findElement(By.id("userName"));
//	     Actions action = new Actions(driver);
//	     action.moveToElement(element).build().perform();
//	     driver.findElement(By.linkText("Logout")).click();
//		 System.out.println("---");
//	     System.out.println("Logout action performed");
//     
//	  
//  }
  
  

  @AfterMethod
  public void afterMethod() {
	  
	 driver.close();
	  driver.quit();
	  
  }

}
