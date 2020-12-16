package basic;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScreenshotConcept {

	public static void main(String[] args) throws IOException {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		
		webdriver .get("https://www.ebay.com/");
		webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		File src = ((TakesScreenshot)webdriver).getScreenshotAs(OutputType.FILE);
	    FileUtils.copyFile(src, new File("C:\\Users\\AMBA BISHT\\eclipse-workspace\\Monika\\Selenium\\src\\selenium\\Screenshot (299).png"));
	}

}
