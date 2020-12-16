package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class MouseMovementConcept {

	public static void main(String[] args) throws InterruptedException {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("https://www.nykaa.com/");
		webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		Actions action = new Actions(webdriver);
		action.moveToElement(webdriver.findElement(By.xpath("//*[@id='my-menu']/ul/li[4]/a"))).build().perform();
		Thread.sleep(1000);
		webdriver.findElement(By.xpath("//*[@id='my-menu']/ul/li[4]/ul/li/div[1]/div[4]/div[2]/ul/li[1]/a")).click();		
		

	}

}
