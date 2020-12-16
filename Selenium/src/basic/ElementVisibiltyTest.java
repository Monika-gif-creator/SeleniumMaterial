package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ElementVisibiltyTest {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");	
		
		WebDriver driver = new ChromeDriver(); //launch chrome
		
		driver.manage().window().maximize(); //maximize window
		driver.manage().deleteAllCookies(); //delete all the cookies
		
		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.get("https://www.freecrm.com"); //enter URL
		boolean b1 = driver.findElement(By.xpath("")).isDisplayed();
		System.out.println(b1);
		
		boolean b2 = driver.findElement(By.xpath("")).isSelected();
		System.out.println(b2);
		
		boolean b3 = driver.findElement(By.xpath("")).isEnabled();
		System.out.println(b3);
		
		/*1.isDisplayed() is the method used to verify the presence of a web element within the web page. The method returns a “true” value if the specified web element is present on the web page and a “false” value if the web element is not present on the webpage.
		2. isDisplayed() is capable to check for the presence of all kinds of web elements available.
		3. isEnabled() is the method used to verify if the web element is enabled or disabled within the web page.
		4. isEnabled() is primarily used with buttons.
		5. isSelected() is the method used to verify if the web element is selected or not. 
		6. isSelected() method is predominantly used with radio buttons, dropdowns and checkboxes.*/
		
	}

}
