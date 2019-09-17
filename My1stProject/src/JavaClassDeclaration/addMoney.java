package JavaClassDeclaration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class addMoney {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver","D:\\Automation_java\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String baseUrl = "https://play.livepools.com/login.html";
        
		driver.get(baseUrl);
		
		driver.findElement(By.id("emailid")).sendKeys("su12kadam@gmail.com");
        driver.findElement(By.id("password")).sendKeys("Test1234");
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();
        
        System.out.println("User Login Successfully...");
        
        Thread.sleep(10000);
        driver.findElement(By.id("accountbalance")).click();
               
        System.out.println("My Wallet page is open...");
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@class='btnaction fullwidth']")).click();
        System.out.println("Add Money to your Wallet - Tab is open");
        
        System.out.println("Select A amount :- 50");
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//div[@class='addmoneyselect']//a[1]")).click();
        System.out.println("Amount Enter Successfully...");
        
        
        Thread.sleep(5000);
        driver.findElement(By.xpath("//a[@id='id_addmoneysubmit']")).click();
        System.out.println("Click on Add money and redirect on PayTm wallet..");
        
        System.out.println("Click on Login button...");
        driver.findElement(By.xpath("//a[@id='id_addmoneysubmit']")).click();
        
        System.out.println("Click on Pay Now Button");
        
        System.out.println("Wallet Open successfully...");
        //Thread.sleep(2000);
        //driver.findElement(By.cssSelector(".btn-fullLen")).click();
        
        driver.close();       
	}

}
