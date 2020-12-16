package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {

	public static void main(String[] args) {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		webdriver.get("https://www.google.com/");

	}

}
