package basic;

import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class WFX {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "C:\\selenium_new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		JavascriptExecutor jsDriver = (JavascriptExecutor) driver;
		NgWebDriver ngDriver = new NgWebDriver(jsDriver);

		driver.manage().window().maximize(); // maximize window

		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.get("https://app.wfxondemand.com/wfx_home.aspx"); // enter URL
		ngDriver.waitForAngularRequestsToFinish();
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);

		driver.findElement(By.xpath("//input[@name='txtUserID']")).sendKeys("PLMAUTO");
		driver.findElement(By.xpath("//input[@name='txtPassword']")).sendKeys("password1");
		driver.findElement(By.xpath("//input[@name='txtCompany']")).sendKeys("PLMAUTO");
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		
		WebElement products = driver.findElement(By.xpath("//a[@title='Products']"));
		
		jsDriver.executeScript("arguments[0].click();", products);
		
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		
		driver.switchTo().frame(0);
		
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//div[@class='search-wrapper']//input")).sendKeys("PlmAuto103");
		
		//driver.findElement(By.xpath("//div[@class='search-wrapper']//input")).sendKeys(Keys.ENTER);
		
		driver.findElement(By.xpath("//div[@class='advanced-filters']/a")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//input[@id='article_season_name']")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//mat-label[@id='txtFirstName' and contains(text(),'Spring')]//parent::div/../parent::div//following-sibling::div")).click();
		driver.findElement(By.xpath("//mat-label[@id='txtFirstName' and contains(text(),'Summers')]//parent::div/../parent::div//following-sibling::div")).click();
		driver.findElement(By.xpath("//button[@class='button-apply mat-raised-button mat-primary']//span")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//a[@class='wfx_viewOptionUnSelected']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//a[@class='wfx_viewOptionUnSelected']")).click();
		Thread.sleep(2000);
		
		driver.findElement(By.xpath("//div[@class='card-checkbox checkbox-unchecked']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//a[@class='bottamPanelSvg tooltip bottom-icon-publish ng-star-inserted']")).click();
		driver.findElement(By.xpath("//button[@id='CancelItems']")).click();
		driver.findElement(By.xpath("//div[@class='extended-menu-icon']")).click();
		driver.findElement(By.xpath("//a[text()='Time & Action']")).click();
		
		driver.findElement(By.xpath("//div[@class='extended-menu-icon']")).click();
		Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='bottamPanelSvg tooltip bottom-icon-articleupdate ng-star-inserted']"))	.click();	
        
        Thread.sleep(2000);
        String winHandleBefore = driver.getWindowHandle();
        for(String winHandle : driver.getWindowHandles()){
         driver.switchTo().window(winHandle);
          }
        Thread.sleep(2000);
        Select select = new Select(driver.findElement(By.xpath("//select[@id='ddlFieldName']")));
        select.selectByValue("Buyer");
        Thread.sleep(2000);
        driver.findElement(By.xpath("//span[@title='Close the window']")).click();
       // driver.switchTo().parentFrame();
        Thread.sleep(2000);
        driver.switchTo().window(winHandleBefore);
        driver.switchTo().frame(0);
        driver.findElement(By.xpath("//span[text()='Clear Filter']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='eye-icon show']")).click();
        String productsubgroup = driver.findElement(By.xpath("//mat-label[text()=' Product Sub-Category ']/ancestor::mat-grid-tile//following-sibling::mat-grid-tile//mat-label")).getText();
        System.out.println(productsubgroup);
        driver.findElement(By.xpath("//a[@class='remove-icon mat-icon-button mat-primary']")).click();
        driver.findElement(By.xpath("//div[@class='mat-tab-label-content' and text()=' Collections ']")).click();
	}
}
