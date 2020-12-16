package basic;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Iterator;
import java.util.Set;

public class BrowsePopUpWindow {

	public static void main(String[] args) throws InterruptedException {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver_win32.zip\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("http://www.popuptest.com/");
		webdriver.manage().window().maximize();
		Thread.sleep(5000);
		
		webdriver.findElement(By.xpath("/html/body/table/tbody/tr[2]/td[2]/table/tbody/tr[2]/td[1]/font[2]/b/a")).click();
		
		Set<String> handler = webdriver.getWindowHandles();
		System.out.println(handler);
		
		Iterator<String> iterartor = handler.iterator();
		String parentwindowid = iterartor.next();
		System.out.println("parentwindowid:" +parentwindowid);
		
		String childwindowidFirst = iterartor.next();
		String childwindowidSecond = iterartor.next();
		String childwindowidThird = iterartor.next();
		System.out.println("childwindowid:" +childwindowidFirst);
		System.out.println("childwindowid:" +childwindowidSecond);
		System.out.println("childwindowid:" +childwindowidThird);
		
		Thread.sleep(2000);
		webdriver.switchTo().window(childwindowidFirst);
		System.out.println("Child window First title" +webdriver.getTitle());
		webdriver.close();
		
		Thread.sleep(1000);
		webdriver.switchTo().window(childwindowidSecond);
		System.out.println("Child window Second title" +webdriver.getTitle());
		webdriver.close();
		
		Thread.sleep(1000);
		webdriver.switchTo().window(childwindowidThird);
		System.out.println("Child window Third title" +webdriver.getTitle());
		webdriver.close();
		
		
		webdriver.switchTo().window(parentwindowid);
		System.out.println("Parent window title" +webdriver.getTitle());
		
		
	}

	
}
