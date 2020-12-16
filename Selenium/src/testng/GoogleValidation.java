package testng;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class GoogleValidation {
	WebDriver webdriver;
	
	@BeforeMethod
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
	    webdriver.manage().deleteAllCookies();
	    
	    webdriver.get("https://www.google.com/");
		webdriver.manage().window().maximize();
		webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	@Test
	public void googleTest()
	{
	 String pagetitle =  webdriver.getTitle();
	 System.out.println(pagetitle);
	 Assert.assertEquals( pagetitle,"Google","Coorect Page is displaying");
	}
	@Test
	public void googleTestAnother()
	{
	 boolean pagetitle =  webdriver.findElement(By.xpath("//*[@id='hplogo']")).isDisplayed();
	 System.out.println(pagetitle);
	 Assert.assertEquals(pagetitle, "true","Page is getting displayed");
	}

}
