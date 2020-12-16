package wfx;

import java.util.concurrent.TimeUnit;

import org.apache.commons.lang3.RandomUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.util.List;
import java.util.Random;

import io.grpc.Context.Key;

public class Ebay {

	public static void main(String[] args) {
		
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.get("https://in.ebay.com/");
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']"));
		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys("Laptops");
		driver.findElement(By.xpath("//input[@class='gh-tb ui-autocomplete-input']")).sendKeys(Keys.ENTER);
		
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h1[@class='srp-controls__count-heading']//span")));
		
		String Results = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']//span")).getText();
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
		/*
		 * driver.findElement(By.
		 * xpath("//div[@class='x-refine__item--toggle' and contains(.,'Brand')]//following::li[@class='x-refine__main__list--value']//div[@class='x-refine__select__svg']//input[@aria-label='Dell']"
		 * )); driver.findElement(By.
		 * xpath("//div[@class='x-refine__item--toggle' and contains(.,'Brand')]//following::li[@class='x-refine__main__list--value']//div[@class='x-refine__select__svg']//input[@aria-label='Dell']"
		 * )).click();
		 * 
		 * driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		 */
		//String ResultsAfterDellSearch = driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']//span")).getText();
		
		//Assert.assertNotEquals(Results, ResultsAfterDellSearch);
		
		List<WebElement> BrandList = driver.findElements(By.xpath("//div[@id='x-refine__group_1__3']//li"));
		
        Random random = new Random();
        int rancount = random.nextInt(8);
        System.out.println(rancount);
        String locator = "//div[@id='x-refine__group_1__3']//li"+"["+rancount+"]";
        System.out.println(locator);
        driver.manage().timeouts().implicitlyWait(100, TimeUnit.SECONDS);
        driver.findElement(By.xpath(locator)).click();
        	
      }
}