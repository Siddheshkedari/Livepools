package JavaClassDeclaration;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class facebooklogin {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation_java\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		String baseUrl = "https://play.livepools.com/login.html";
        String expectedTitle = "Welcome: Livepools.com";
        String actualTitle = "LivePools - Login";
        
        driver.get(baseUrl);
        expectedTitle = driver.getTitle();
        System.out.println("Page title is : "+expectedTitle);
        
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        
        System.out.println("Click on facebook button........");
        driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[1]/div/a[2]")).click();
        
        
        String mainWindow = driver.getWindowHandle();
        
        Set<String> set = driver.getWindowHandles();
        
        Iterator<String> itr = set.iterator();
        while (itr.hasNext())
        {
        	String childWindow=itr.next();
        	
        	if(!mainWindow.equals(childWindow))
        	{
        		 driver.switchTo().window(childWindow);
        		 System.out.println(driver.switchTo().window(childWindow).getTitle());
        		 driver.findElement(By.id("email")).sendKeys("siddheshkedari31@gmail.com");
        	        driver.findElement(By.id("pass")).sendKeys("devsid@9665hello.");
        	        driver.findElement(By.id("u_0_0")).click();
        	}
        }      
        
        System.out.println("Login with facebook");
        
        driver.close();

	}

}
