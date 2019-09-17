package JavaClassDeclaration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class normal_registration_Form {

	public static void main(String[] args) {
		
		System.setProperty("webdriver.chrome.driver","D:\\Automation_java\\ChromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		
		String baseUrl = "https://play.livepools.com/login.html";
        
		driver.get(baseUrl);
		
		
		driver.findElement(By.xpath("//a[@id='btnemailsignup']")).click();
		System.out.println("Registration page is open..");
		
		driver.findElement(By.id("firstname")).sendKeys("Rupamati");
		driver.findElement(By.id("lastname")).sendKeys("Mahadevan");
		driver.findElement(By.id("nickname")).sendKeys("IndiaWonICC2019");
		
		Select mySelectDate = new Select(driver.findElement(By.id("dobday"))); 
		mySelectDate.selectByIndex(2);
		
		Select mySelectMonth = new Select(driver.findElement(By.id("dobmonth")));
		mySelectMonth.selectByIndex(4);
		
		Select mySelectYear = new Select(driver.findElement(By.id("dobyear")));
		mySelectYear.selectByIndex(5);
		
		driver.findElement(By.id("emailid")).sendKeys("sudarshan_mane123@gmail.com");
		
		driver.findElement(By.id("password")).sendKeys("123456");
		
		driver.findElement(By.id("confirmpassword")).sendKeys("123456");
		
		Select selectState = new Select(driver.findElement(By.id("selState")));
		selectState.selectByIndex(5);
		
		WebElement agreementCheckBox = driver.findElement(By.id("termsandconditions"));
		agreementCheckBox.click();
		
		driver.findElement(By.xpath("//a[contains(text(),'Submit')]")).click();	
		System.out.println("User Login successfully....");
	}
}
