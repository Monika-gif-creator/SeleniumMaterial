package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Navigation {

	public static void main(String[] args) {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("https://www.google.com/");
		webdriver.manage().timeouts().pageLoadTimeout(50, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		webdriver.navigate().to("https://www.nykaa.com/");
		webdriver.navigate().back();
		webdriver.navigate().forward();
		webdriver.navigate().refresh();


	}

}
