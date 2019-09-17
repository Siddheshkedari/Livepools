package JavaClassDeclaration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class myFirstProgram {
	
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation_java\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String baseUrl = "http://test.livepools.com/";
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
        
        
        driver.findElement(By.id("emailid")).sendKeys("su12kadam@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test1234");
        driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[2]/div/a[2]")).click();
        
     
        /** System.out.println("User login successfully");
        
        Thread.sleep(1000);
        
	     WebElement element = driver.findElement(By.id("userName"));
	     Actions action = new Actions(driver);
	     action.moveToElement(element).build().perform();
	     driver.findElement(By.linkText("Logout")).click();
		 
	     System.out.println("Logout action performed");  **/
        
         //driver.close();
	}
}
