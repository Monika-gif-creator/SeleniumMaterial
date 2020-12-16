package basic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class ReadPropertiesFile {

	
	public static void main(String[] args) throws IOException {
		
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AMBA BISHT\\eclipse-workspace\\Monika\\Selenium\\src\\config.properties");
		properties.load(fileInputStream);
		
		System.out.println("name " +  properties.getProperty("name"));
		System.out.println("age " +  properties.getProperty("age"));
		
		WebDriver driver = startbrowser();//1
		String url = properties.getProperty("URL");
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		String OfficeDepotLogo = driver.findElement(By.xpath(properties.getProperty("OfficeDepotLogo_xpath"))).getAttribute("title");
		if(OfficeDepotLogo.equals("officedepot.com"))
		{
			System.out.println("Landing to the correct site");
		}
		
		else
		{
			System.err.println("Not able to find the Logo");
		}
		
		driver.findElement(By.xpath(properties.getProperty("Search_xpath"))).sendKeys(properties.getProperty("Search"));
		driver.findElement(By.xpath(properties.getProperty("Search_xpath"))).sendKeys(Keys.ENTER);
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		driver.findElement(By.xpath(properties.getProperty("Popup_Close"))).click();
		JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("window.scrollBy(0,500)");
		
		driver.findElement(By.xpath(properties.getProperty("Sku_Add_To_Cart"))).click();
		driver.findElement(By.xpath(properties.getProperty("Subscription_Close_Button"))).click();
		
		Actions actions = new Actions(driver);
		actions.moveToElement(driver.findElement(By.xpath(properties.getProperty("Hover_Add_To_Cart")))).build().perform();
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath(properties.getProperty("View_Cart"))).click();
		
		driver.findElement(By.xpath(properties.getProperty("SIGN_UP_TO_RECEIVE"))).click();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
        Set<String> handler = driver.getWindowHandles();
		
		Iterator<String> iterartor = handler.iterator();
		String parentwindow = iterartor.next();
		String childwindow = iterartor.next();
	    driver.switchTo().window(childwindow);
	    
	    driver.findElement(By.xpath(properties.getProperty("Email"))).sendKeys("Abc@yopmail.com");
		
	}

	public static WebDriver startbrowser() throws IOException
	{
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\AMBA BISHT\\eclipse-workspace\\Monika\\Selenium\\src\\config.properties");
		properties.load(fileInputStream);
		String Browser = properties.getProperty("Browser");
		
		if(Browser.equals("chrome"))
		{
			WebDriver webdriver;
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
			return webdriver;
		}
		else
		{
			WebDriver webdriver;
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			webdriver = new FirefoxDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
			return webdriver;
		}
		
		
	}
}
