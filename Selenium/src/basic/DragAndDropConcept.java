package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class DragAndDropConcept {

	@Test
	public static void main(String[] args) {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("https://jqueryui.com/droppable/");
		//webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		webdriver.switchTo().frame(0);
		Actions action = new Actions(webdriver);
		
		
		//1 way
		WebElement source = webdriver.findElement(By.id("draggable"));
		WebElement destination = webdriver.findElement(By.id("droppable"));
		
		//action.dragAndDrop(source, destination).build().perform();
		
		//2 way
		action.clickAndHold(source).moveToElement(destination).release().build().perform();
		
	}

}
