package basic;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {

	public static void main(String[] args) throws InterruptedException {
		
		/*Steps:
			1. Google Search – pick a value from suggestions
			2. Search using Xpath
			3. Get the total count of suggestions
			4. Use if condition to match the value
			5. Click on matched value
*/
		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://www.google.com/"); // enter URL
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        
        driver.findElement(By.xpath("//input[@class='gLFyf gsfi']")).sendKeys("Test");
        Thread.sleep(6000);
        
        //Selects all descendants (children, grandchildren, etc.) of the current node{descendant}
        List<WebElement> List= driver.findElements(By.xpath("//div[@class='jKWzZXdEJWi__suggestions-inner-container']/descendant::div[@class='sbtc']//span"));
		Thread.sleep(6000);
        for (int i=0 ; i<List.size();i++)
		System.out.println(List.get(i).getText());
        for (int i=0 ; i<List.size();i++)
        if(List.get(i).getText().equals("test for coronavirus"))
		{
			List.get(i).click();
			break;
		}

	}

}
