package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Xpath {

	public static void main(String[] args) {
		
			WebDriver webdriver;
			System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
			webdriver.manage().deleteAllCookies();
			
			webdriver.get("https://www.nykaa.com/");
			webdriver.manage().window().maximize();
			
			//1 Xpath:
			webdriver.findElement(By.xpath("//*[@id='SearchInputBox']")).sendKeys("MAC");
			webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			webdriver.findElement(By.xpath("//*[@id='SearchInputBox']")).sendKeys(Keys.ENTER);
		
			
			
			//By Id:
			webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
			webdriver.findElement(By.id("NykaaLogo")).click();
			
			//By partial link
			//By css selector
			//by link
			//by class
		    Select select = new Select(webdriver.findElement(By.className("gfhfhfj")));
		    select.selectByVisibleText("");

	}

}
