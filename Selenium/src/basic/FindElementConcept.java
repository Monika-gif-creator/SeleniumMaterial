package basic;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class FindElementConcept {

	public static void main(String[] args) {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		/*webdriver.get("https://www.ebay.com/");
		webdriver.manage().timeouts().pageLoadTimeout(3000, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();*/
		
		/*//Xpath
		webdriver.findElement(By.xpath("//td[starts-with(@id,'gh-cat-td')]")).click();*/
		
		webdriver.get("https://www.flipkart.com/");
		webdriver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		//Find Element By
		webdriver.findElement(By.xpath("//button[@class='_2AkmmA _29YdH8']")).click();
		
		List<WebElement> linkname = webdriver.findElements(By.className("12"));
		
		System.out.println(linkname.size());
		
		/*
		 * for(int i =0;i<=linkname.size();i++) {
		 * 
		 * System.out.println(linkname.get(i)+"**********"); }
		 */
		
		webdriver.quit();
	}

}
