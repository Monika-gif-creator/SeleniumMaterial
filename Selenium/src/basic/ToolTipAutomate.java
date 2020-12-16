package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class ToolTipAutomate {

	public static void main(String[] args) {
		
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.manage().window().maximize();
		
		webdriver.get("https://www.facebook.com/");
		webdriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		/*
		 * WebElement tooltip =
		 * webdriver.findElement(By.xpath("//a[@class='_58ms mlm']"));
		 * 
		 * String tooltiptext = tooltip.getAttribute("title");
		 * System.out.println(tooltiptext);
		 */
		
		Actions action = new Actions(webdriver);
		action.moveToElement(webdriver.findElement(By.xpath("//a[@class='_58ms mlm']"))).perform();
		String tooltiptext = webdriver.findElement(By.xpath("//a[@class='_58ms mlm']")).getAttribute("title");
		System.out.println(tooltiptext);
		
		
		
	}

}
