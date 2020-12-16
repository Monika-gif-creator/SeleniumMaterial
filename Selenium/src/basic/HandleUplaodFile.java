package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleUplaodFile {

	public static void main(String[] args) throws InterruptedException {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("https://html.com/input-type-file/");
		webdriver.manage().window().maximize();
		Thread.sleep(5000);
		
		webdriver.findElement(By.xpath("//*[@id='fileupload']")).sendKeys("G:\\Pictures\\Screenshots\\Screenshot (299).png");
		

	}

}
