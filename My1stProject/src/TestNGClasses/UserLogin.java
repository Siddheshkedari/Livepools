package TestNGClasses;

import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class UserLogin {
	
	public WebDriver driver;
	public String firstWinHandle;  
	public String secondWinHandle; 
	WebDriverWait wait;// = new WebDriverWait(driver, 5);  create a WebDriverWait that we will reuse
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFCell cell;


	
  @Test(priority = 1)
  public void normal_user_login() throws InterruptedException {
	    System.setProperty("webdriver.chrome.driver","D:\\Automation_java\\ChromeDriver1\\chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, 5);
		
		//driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String baseUrl = "https://play.livepools.com/";
		
		driver.get(baseUrl);
		String actualTitle = "https://play.livepools.com/";
        String expectedTitle = driver.getCurrentUrl();
     
     
        Assert.assertEquals(expectedTitle, actualTitle);
      
      
//    WebElement userloginID = driver.findElement(By.id("emailid"));
//        userloginID.clear();
//        userloginID.sendKeys("su12kadam@gmail.com");
//      
//      WebElement passwordID = driver.findElement(By.id("password"));
//      passwordID.clear();
//      passwordID.sendKeys("Test12345");
//      
//      driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[2]/div/a[2]")).click();
//      
//     
//    	  Thread.sleep(10000);
//    	  WebElement cricketTabClick = driver.findElement(By.xpath("//a[@id='fantasytab1']"));
//    	  cricketTabClick.click();
    	  
    	    
   }
  
  
  @Test(priority = 2)
  public void ReadData() throws IOException, InterruptedException
  {
	  
	  System.out.println("Inside readdata file..");
	  	//Import excel file
	  Thread.sleep(5000);
        File src=new File("C:\\Users\\ADMIN\\Desktop\\TestData.xlsx");
//	     
//	     //Load the file
	     FileInputStream finput=new FileInputStream(src);
//	     
//	     //Load the workbook
	     workbook = new XSSFWorkbook(finput);
//	     
	     System.out.println(workbook.getSheetName(0));
//	     // Load the sheet in which data is stored.
	     sheet = workbook.getSheetAt(0);  
	     Thread.sleep(1000);
	     
	     int count=sheet.getLastRowNum();
	     System.out.println(count);
	     
	     for(int i=1; i<=sheet.getLastRowNum(); i++)
	     {
	    	 
	    	 
	    	 System.err.println("Inside For Loop");
	         //import data for email..
	    	 cell = sheet.getRow(i).getCell(1);
	         cell.setCellType(CellType.STRING);
	         WebElement userloginID = driver.findElement(By.id("emailid"));
	         userloginID.clear();
	         userloginID.sendKeys(cell.getStringCellValue());
	         System.out.println(cell.getStringCellValue());

	         //import data for password..
	         cell = sheet.getRow(i).getCell(2);
	         cell.setCellType(CellType.STRING);
	         WebElement passwordID = driver.findElement(By.id("password"));
	         passwordID.clear();
	         passwordID.sendKeys("@live704");
	         System.out.println(cell.getStringCellValue());
	     }
	    
	     Thread.sleep(10000);
	     driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[2]/div/a[2]")).click();
	     

	  

      
     // driver.findElement(By.xpath("/html/body/div[2]/section/div[2]/aside[2]/div/a[2]")).click();
      
      
	  Thread.sleep(10000);
	  WebElement cricketTabClick = driver.findElement(By.xpath("//a[@id='fantasytab1']"));
	  cricketTabClick.click();
      
      
  }
  
  
  
 
  
  
  
  // Handle exist element is present or not...........
  private boolean existsElement(String xpath) 
  {
      try {
          driver.findElement(By.xpath(xpath));
      } catch (Exception e) {
          System.out.println("Element is not present ");
          return false;
      }

      return true;
  }
  
  
  
  
  //Cricket Click
  @Test(priority = 3)
  public void SelectandValidateMarket() throws InterruptedException 
  {
	  Thread.sleep(2000);

		  if(existsElement("//span[contains(.,'Manage team')]")==true)
		  {
			  System.out.println("Click on Manage Team Button");
			  Set<String> windows1 = driver.getWindowHandles();
			  System.out.println(windows1.size());
		  
			  driver.findElement(By.xpath("//span[contains(.,'Manage team')]")).click();  //If there is manage team button
			  System.out.println("Manage team button click and we view the selected player succesfully");
		  
			  driver.findElement(By.className("si-backBtn")).click();
		  
			  Thread.sleep(1000);

		  
			  //By ClickOnViewButton = By.xpath("//div[@id='li_101']//*[contains(text(),'View')]");
		 
			  //if(driver.findElement(ClickOnViewButton).isDisplayed())
			  Thread.sleep(2000);
			  if(existsElement("//div[@id='li_101']//*[contains(text(),'View')]")==true)
			  {
			  
				  System.out.println("You are on view click page, inside If");
				  wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='li_101']/div[3]/div/span"))).click();
				  Thread.sleep(2000);
				  driver.findElement(By.className("si-backBtn")).click();
				  System.out.println("You are reflected https://fantasy.livepools.com/ page");
			  }
			  else
			  {
				  driver.findElement(By.xpath("//div[@id='li_101']/div[3]/div/span")).click();
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div[3]/div/div/div[2]/span")).click();
			  // ------------------ Click on Popup play button --------------------------
			  
				  Thread.sleep(5000);
				  driver.findElement(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div")).click();
			     //popup click
			  }		  
		  }
	  
	  	  else
	  	  {
	  		  	driver.findElement(By.xpath("//span[contains(.,'CREATE TEAM')]")).click(); 
	  		  	//create team button clicked--------------------
	  		    System.out.println("Create team button is clicked");
	  		    
	  		    
	  		  if(existsElement("//div[@id = 'container']/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div")==true)
    			{
    				 wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id = 'container']/div/div/div[2]/div[2]/div/div/div[3]/div[2]/div"))).click();
    			}
	  		   
				wait.until(ExpectedConditions.elementToBeClickable(By.className("si-lp-bt"))).click();
	  		    
	  		    
	  		    //   All Player selection................ start here
		
	  		    
	  		    //-----------------------Select Player one-------Batsman one-------------------------------------//
	  		    WebElement playerBatname1 = driver.findElement(By.xpath("//li[2]/div/div/div/div[1]/div/div[2]/div"));
	  		    WebElement playerBatcredit1 = driver.findElement(By.xpath("//li[2]/div/div/div/div[2]/span"));
	  		    WebElement playerBatselection1 = driver.findElement(By.xpath("//li[2]/div/div/div/div[3]/div"));
	  		    
	  		    System.out.println(playerBatname1.getText()+' '+playerBatcredit1.getText());
	  		    playerBatselection1.click();
	  		    

	  		    //-----------------------Select Batsman one--------------------------------------------//
	  		    WebElement playerBatname2 = driver.findElement(By.xpath("//li[4]/div/div/div/div[1]/div/div[2]/div"));
	  		    WebElement playerBatcredit2 = driver.findElement(By.xpath("//li[4]/div/div/div/div[2]/span"));
	  		    WebElement playerBatselection2 = driver.findElement(By.xpath("//li[4]/div/div/div/div[3]/div"));
	  		    
	  		    System.out.println(playerBatname2.getText()+' '+playerBatcredit2.getText());
	  		    playerBatselection2.click();
	  		    
	  		    
	  		    
	  		    //------------------------Select Batsman three------------------------------------
	  		WebElement playerBatname3 = driver.findElement(By.xpath("//li[5]/div/div/div/div[1]/div/div[2]/div"));
  		    WebElement playerBatcredit3 = driver.findElement(By.xpath("//li[5]/div/div/div/div[2]/span"));
  		    WebElement playerBatselection3 = driver.findElement(By.xpath("//li[5]/div/div/div/div[3]/div"));
  		    
  		    System.out.println(playerBatname3.getText()+' '+playerBatcredit3.getText());
  		    playerBatselection3.click();
  		  
  		  
  		  //-----------------------------Select Batsman Four-------------------
	  		WebElement playerBatname4 = driver.findElement(By.xpath("//li[6]/div/div/div/div[1]/div/div[2]/div"));
  		    WebElement playerBatcredit4 = driver.findElement(By.xpath("//li[6]/div/div/div/div[2]/span"));
  		    WebElement playerBatselection4 = driver.findElement(By.xpath("//li[6]/div/div/div/div[3]/div"));
  		    
  		    System.out.println(playerBatname4.getText()+' '+playerBatcredit4.getText());
  		    playerBatselection4.click(); 		  

  //Bowler Selection Started...
  		  
			wait.until(ExpectedConditions.elementToBeClickable(By.className("si-lp-bl"))).click();
		  
			 //-----------------------------Select Bowler Four--- 1st----------------
	  		WebElement playerBowlername1 = driver.findElement(By.xpath("//li[6]/div/div/div/div[1]/div/div[2]/div"));
  		    WebElement playerBowlercredit1 = driver.findElement(By.xpath("//li[6]/div/div/div/div[2]/span"));
  		    WebElement playerBowlerselection1 = driver.findElement(By.xpath("//li[6]/div/div/div/div[3]/div"));
  		    
  		    System.out.println(playerBowlername1.getText()+' '+playerBowlercredit1.getText());
  		    playerBowlerselection1.click();
  		  
  		  //-------------------Bowler 2nd
  		    WebElement playerBowlername2 = driver.findElement(By.xpath("//li[7]/div/div/div/div[1]/div/div[2]/div"));
		    WebElement playerBowlercredit2 = driver.findElement(By.xpath("//li[7]/div/div/div/div[2]/span"));
		    WebElement playerBowlerselection2 = driver.findElement(By.xpath("//li[7]/div/div/div/div[3]/div"));
		    
		    System.out.println(playerBowlername2.getText()+' '+playerBowlercredit2.getText());
		    playerBowlerselection2.click();	
		  
		  
		  //-------------------Bowler 3nd---------------------------
	  		WebElement playerBowlername3 = driver.findElement(By.xpath("//li[11]/div/div/div/div[1]/div/div[2]/div"));
			WebElement playerBowlercredit3 = driver.findElement(By.xpath("//li[11]/div/div/div/div[2]/span"));
			WebElement playerBowlerselection3 = driver.findElement(By.xpath("//li[11]/div/div/div/div[3]/div"));
			    
			    System.out.println(playerBowlername3.getText()+' '+playerBowlercredit3.getText());
			  playerBowlerselection3.click();
			  
			  
			  //-------------------Bowler 4th---------------------------
		  	WebElement playerBowlername4 = driver.findElement(By.xpath("//li[12]/div/div/div/div[1]/div/div[2]/div"));
		    WebElement playerBowlercredit4 = driver.findElement(By.xpath("//li[12]/div/div/div/div[2]/span"));
			WebElement playerBowlerselection4 = driver.findElement(By.xpath("//li[12]/div/div/div/div[3]/div"));
				    
				    System.out.println(playerBowlername4.getText()+' '+playerBowlercredit4.getText());
				  playerBowlerselection4.click();
				  
				  
				  
	//Bowler section completed - Wicketkepper selection started..
		  
			wait.until(ExpectedConditions.elementToBeClickable(By.className("si-lp-wk"))).click();
 		  //Wicketkipper selection................
		  	WebElement playerWicketKeepername1 = driver.findElement(By.xpath("//li[4]/div/div/div/div[1]/div/div[2]/div"));
		    WebElement playerWicketKeepercredit1 = driver.findElement(By.xpath("//li[4]/div/div/div/div[2]/span"));
			//WebElement playerWicketKeeperselection1 = driver.findElement(By.xpath("//li[2]/div/div/div/div[3]/div"));
				    
				    System.out.println(playerWicketKeepername1.getText()+' '+playerWicketKeepercredit1.getText());
				  //  playerWicketKeeperselection1.click();
					wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//li[4]/div/div/div/div[3]/div"))).click();

				    
				    
	//Wicket Keeper selection done here
	//All rounder selection started ->
				    
			wait.until(ExpectedConditions.elementToBeClickable(By.className("si-lp-ar"))).click();

		
			//1st Allrounder..
		  	WebElement playerAllRoundername1 = driver.findElement(By.xpath("//li[1]/div/div/div/div[1]/div/div[2]/div"));
		    WebElement playerAllRoundercredit1 = driver.findElement(By.xpath("//li[1]/div/div/div/div[2]/span"));
			WebElement playerAllRounderselection1 = driver.findElement(By.xpath("//li[1]/div/div/div/div[3]/div"));
			System.out.println(playerAllRoundername1.getText()+' '+playerAllRoundercredit1.getText());
			playerAllRounderselection1.click();
			
			//2st Allrounder..
		  	WebElement playerAllRoundername2 = driver.findElement(By.xpath("//li[6]/div/div/div/div[1]/div/div[2]/div"));
		    WebElement playerAllRoundercredit2 = driver.findElement(By.xpath("//li[6]/div/div/div/div[2]/span"));
			WebElement playerAllRounderselection2 = driver.findElement(By.xpath("//li[6]/div/div/div/div[3]/div"));
			System.out.println(playerAllRoundername2.getText()+' '+playerAllRoundercredit2.getText());
			playerAllRounderselection2.click();
			
			
			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[2]/div/span"))).click();
			System.out.println("Submit Button successfully clicked........");
			Thread.sleep(2000);
			
			
			firstWinHandle = driver.getWindowHandle();//Store my parent window...
			secondWinHandle = null;
			System.out.println("First Window ID : "+firstWinHandle);
			
			Set <String>handles = driver.getWindowHandles();
			Iterator<String> iterator =handles.iterator();
			
			while(iterator.hasNext())
			{
				secondWinHandle = iterator.next();

			}
			driver.switchTo().window(secondWinHandle);

			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div[4]/div/div/ul/li[2]/div/div[2]/div/span"))).click();
			
			driver.switchTo().window(firstWinHandle);	
			
			System.out.println("Team Created successfully---------- welldone siddhesh, you are Boss.");
			
			Thread.sleep(10000);
//			//Play button will clicked here
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='li_101']/div[3]/div/span"))).click();
//			
//			//Click on Play Button
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div[3]/div/div/div[2]/span"))).click();
//			
//			//User successfully enter
//			wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div"))).click();
			
			driver.findElement(By.xpath("//div[@id='li_101']/div[3]/div/span")).click();
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div[3]/div/div/div[2]/span")).click();
		  // ------------------ Click on Popup play button --------------------------
		  
			  Thread.sleep(5000);
			  driver.findElement(By.xpath("//div[@id='container']/div/div/div[2]/div[2]/div/div")).click();
		     //popup click
	
  		}	
		  
  }
  

//  @Test(priority = 3)
//  public void CloseDriver()
//  {
//	  
//	  driver.close();
//  }
}
