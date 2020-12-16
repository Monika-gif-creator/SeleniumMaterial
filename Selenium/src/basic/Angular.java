package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.paulhammant.ngwebdriver.NgWebDriver;

public class Angular {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "C:\\selenium_new\\chromedriver.exe");
		WebDriver driver = new ChromeDriver(); // launch chrome
		/*
		 * JavascriptExecutor jsDriver = (JavascriptExecutor) driver; NgWebDriver
		 * ngDriver = new NgWebDriver(jsDriver);
		 */
        driver.manage().window().maximize(); // maximize window

		
		//driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.get("https://juliemr.github.io/protractor-demo/"); // enter URL
        
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//input[@class='input-small ng-pristine ng-valid ng-touched']")).sendKeys("4");
	}

}
