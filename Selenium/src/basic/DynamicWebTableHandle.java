package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DynamicWebTableHandle {

	public static void main(String[] args) throws InterruptedException {

		
		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window

		// dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		Actions action = new Actions(driver);

		driver.get("http://demo.automationtesting.in/WebTable.html"); // enter URL
		
		Thread.sleep(6000);

		driver.findElement(By.xpath("//span[contains(text(),'Email')]")).click();
		
		//*[@id="1589641719264-3-uiGrid-0005-cell"]
		
		//Method-1:
		String before_xpath = "//*[@id='1589641719264-";
		String after_xpath = "-uiGrid-0005-cell']//div";
		
		for(int i=1; i<=9; i++){
			String name = driver.findElement(By.xpath(before_xpath+i+after_xpath)).getText();
			System.out.println(name);
			//*[@id="1589630980389-1-uiGrid-0005-cell"]/div
			if(name.contains("14tentativa@teste.com"))
			{ //i=8
				//*[@id="1589641719264-8-uiGrid-000B-cell"]/user-click-select/div[1]/button
				driver.findElement(By.xpath("//*[@id='1589641719264-"+i+"-uiGrid-000B-cell']/user-click-select/div[1]/button"));
				action.doubleClick();
			}
		}
		
		//Method-2:
		driver.findElement(By.xpath("//*[@id='1589641719264-8-uiGrid-000B-cell']/user-click-select/div[1]/button"));
		action.doubleClick();
		//driver.findElement(By.xpath("//a[contains(text(),'ui uiii')]/parent::td//preceding-sibling::td//input[@name='contact_id']")).click();

	}

}
