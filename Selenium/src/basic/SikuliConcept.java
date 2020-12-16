package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.sikuli.script.*;


public class SikuliConcept {

	public static void main(String[] args) {
		
		/*Integration of Sikuli with Selenium WebDriver:

			Now, no need to take the headache of XPath, CSS, ID and Name. 

			+Sikuli is an image-based open source tool to automate the GUI and can be used on any platform like Windows/Linux/Mac/Mobile. 

			+Sikuli uses a technique called image recognition to identify and control GUI components.

			====================================================
			• Automate using images
			• No API to launch Browser and URL – need to use selenium
			• Can automate flash objects – YouTube video
			• Desktop application automation*/
		
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		webdriver.get("https://www.youtube.com/watch?v=o_Ay_iDRAbc");
		/*Screen scr = new Screen();
		Patter pause = new Patter("YT_Pause.png");
		scr.wait(pause,2000);
		scr.click();*/
		
	}

}
