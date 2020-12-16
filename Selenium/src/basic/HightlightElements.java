package basic;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class HightlightElements {

	public static void main(String[] args) throws InterruptedException {
	

				System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");	
				
				WebDriver driver = new ChromeDriver(); //launch chrome
				
				driver.manage().window().maximize(); //maximize window
				driver.manage().deleteAllCookies(); //delete all the cookies
				
				//dynamic wait
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				
				driver.get("https://www.freecrm.com"); //enter URL
				
				//executeScript -- to execute JavaScript code
				
				WebElement loginBtn = driver.findElement(By.xpath("//a[@class='btn btn-primary btn-xs-2 btn-shadow btn-rect btn-icon btn-icon-left']")); //login button
				
				
				flash(loginBtn, driver); //highlight the element
				Thread.sleep(5000);
				drawBorder(loginBtn, driver); //draw a border
				//generate Alert
				generateAlert(driver, "There is an issue with Login button on Login Page");
				driver.switchTo().alert().accept();
				
				//click on any element by using JS executor
				clickElementByJS(loginBtn, driver);
				
			    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
				
				//refresh the page:
				//1. by using selenium:
				//driver.navigate().refresh();
				
				//2. by using JS executor:
				refreshBrowserByJS(driver);
				
				//get the tile of the page by JS:
		         try {
					System.out.println(getTitleByJS(driver));
					
					//get the page text:
					System.out.println(getPageInnerText(driver));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				//scroll page down:
				scrollPageDown(driver);
				
				navigateBack(driver);
				driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
				WebElement privacyLink = driver.findElement(By.xpath("//p[@class='privacy']"));
				 
				 //Scroll till object visible 
				scrollIntoView(privacyLink, driver);
				
			}
			
			
			public static void flash(WebElement element, WebDriver driver) throws InterruptedException {
		        for (int i = 0; i < 20; i++) {
		            changeColor("rgb(0,200,183)", element,driver);//1
		            changeColor("rgB(49,71,0)", element,driver);//2
		        }
		    }
		    public static void changeColor(String color, WebElement element, WebDriver driver) {
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		        js.executeScript("arguments[0].style.backgroundColor = '"+color+"'",  element);

		        try {
		            Thread.sleep(500);
		        }  catch (InterruptedException e) {
		        }
		     }
			
			
		    public static void drawBorder(WebElement element, WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("arguments[0].style.border='3px solid red'", element);
		    }
		    
		    public static void generateAlert(WebDriver driver, String message){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("alert('"+message+"')");

		    }
		    
		    public static void clickElementByJS(WebElement element, WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("arguments[0].click();", element);
		    	
		    }
			
		    public static void refreshBrowserByJS(WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("history.go(0)");
		    }
		    
		    public static String getTitleByJS(WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	String title = js.executeScript("return document.title;").toString();
		    	return title;
		    }
		    
		    public static String getPageInnerText(WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	String pageText = js.executeScript("return document.documentElement.innerText;").toString();
		    	return pageText;
		    }
		    
		    public static void scrollPageDown(WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
		    }
		    
		    public static void scrollIntoView(WebElement element, WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("arguments[0].scrollIntoView(true);", element);
		    }
		    
		    public static void navigateBack(WebDriver driver){
		    	JavascriptExecutor js = ((JavascriptExecutor) driver);
		    	js.executeScript("history.go(-1)");
		    }

		}
