package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicConcept {
	
	WebDriver webdriver; // web driver is an interface 
	
	public void invokeBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
	    webdriver.manage().deleteAllCookies();
	    
	    webdriver.get("https://www.google.com/");
		webdriver.manage().window().maximize();
	    webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    
	    String title = webdriver.getTitle();
	    
	    if(title.equals("Google"))
	    {
	    	System.out.println("This is the correct url");
	    }
	    else
	    {
	    	System.out.println("This is the incorrect url");
	    }
	    
	    webdriver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	    webdriver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
	    System.out.println(webdriver.getCurrentUrl());
		//System.out.println(webdriver.getPageSource());
		webdriver.quit();//close all the chrome browser
	}
	

	public static void main(String[] args) {
		
		BasicConcept myBasic1 = new BasicConcept();
		myBasic1.invokeBrowser();
		
		
	}

}
