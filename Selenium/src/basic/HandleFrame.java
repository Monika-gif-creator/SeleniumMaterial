package basic;

import java.sql.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrame {

	public static void main(String[] args) throws InterruptedException {

		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("https://www.calendarlabs.com/2020-hindu-calendar");
		webdriver.manage().window().maximize();
		Thread.sleep(8000);
		Thread.sleep(8000);
		Thread.sleep(8000);
		Thread.sleep(8000);
		Thread.sleep(8000);
		
		WebElement xpath = webdriver.findElement(By.xpath("//*[@id='page']/header/div[2]/div/div[2]/iframe"));
		WebElement xpath1 = webdriver.findElement(By.xpath("//*[@id='_mN_main_373823032_n']"));
		webdriver.switchTo().frame(xpath);
		Thread.sleep(3000);
		webdriver.switchTo().frame(xpath1);
		Thread.sleep(3000);
		
		webdriver.findElement(By.className("dak1 anchorhref")).click();
		webdriver.quit();
	}

}
