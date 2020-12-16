package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import com.gargoylesoftware.htmlunit.javascript.background.JavaScriptExecutor;


public class SelectCalendarByJS {

	public static void main(String[] args) {

		System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");

		WebDriver driver = new ChromeDriver(); // launch chrome

		driver.manage().window().maximize(); // maximize window
		driver.manage().deleteAllCookies(); // delete all the cookies

		//dynamic wait
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);

		driver.get("http://spicejet.com/"); // enter URL
		
		WebElement date = driver.findElement(By.xpath("//input[@name='ctl00$mainContent$txt_Fromdate']"));
		String dateVal = "30-March-2021";
		String DateSelected[]= dateVal.split("-");
		String MonthSelected = DateSelected[1];
		String YearSelected = DateSelected[2];
		String Month  = driver.findElement(By.xpath("//div[@class='ui-datepicker-group ui-datepicker-group-first']")).getTagName();
		
		//selectDateByJS(driver, date, dateVal);
		driver.findElement(By.xpath("//button[@class='ui-datepicker-trigger']")).click();
		
		
	}
	
	public static void selectDateByJS(WebDriver driver, WebElement element, String dateVal){
    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		js.executeScript("arguments[0].setAttribute('value','"+dateVal+"');", element);
		
	}
	
	
	
	

}

