package basic;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandlePopUp {

	public static void main(String[] args) throws InterruptedException {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver.get("https://www.rediff.com/");
		webdriver.manage().window().maximize();
		Thread.sleep(5000);
		
		webdriver.findElement(By.className("signin")).click();
		Thread.sleep(5000);
		webdriver.findElement(By.name("proceed")).click();
		Alert alert = webdriver.switchTo().alert();
		String alertMsg = alert.getText();
		System.out.println(alertMsg);
		if(alertMsg.equals("Please enter a valid user name"))
		{
			System.out.println("Pop is displaying");
		}
		else
		{
			System.out.println("Pop is Not Displyaing");
		}
		alert.accept();
		alert.dismiss();
		
	}

}
