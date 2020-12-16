package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CalenderTest {

	public static void main(String[] args) throws InterruptedException {
		WebDriver webdriver;
		System.setProperty("webdriver.chrome.driver","C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
		webdriver = new ChromeDriver();//class child object can be refrenced(new ChromeDriver()) by parent child obj //Dynamic polymorphism
		webdriver.manage().deleteAllCookies();
		webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.SECONDS);
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.SECONDS);
		webdriver.manage().window().maximize();
		
		webdriver.get("https://classic.crmpro.com");
		webdriver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("batchautomation");
		webdriver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("Test@12345");
		webdriver.findElement(By.xpath("//input[@value='Login']")).click();
		
		webdriver.manage().timeouts().pageLoadTimeout(5000, TimeUnit.MILLISECONDS);
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		webdriver.switchTo().frame("mainpanel");
		
		webdriver.findElement(By.xpath("//a[@title='Calendar']")).click();
		webdriver.manage().timeouts().implicitlyWait(3000, TimeUnit.MILLISECONDS);
		
		String DateSelected = "28-August-2023";
		String SplitBy[] = DateSelected.split("-");
		String Date = SplitBy[0];
		String Month = SplitBy[1];
		String Year = SplitBy[2];
		
		Select select = new Select(webdriver.findElement(By.xpath("//select[@name='slctMonth']")));
		select.selectByVisibleText(Month);
		Thread.sleep(2000);
		Select selectYear = new Select(webdriver.findElement(By.xpath("//select[@name='slctYear']")));
		selectYear.selectByVisibleText(Year);
		
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[1] //tr means rows and td means column
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[2]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[3]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[4]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[5]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[6]
		//*[@id="crmcalendar"]/table/tbody/tr[2]/td/table/tbody/tr[2]/td[7]
		
		String Beforexpath = "//*[@id='crmcalendar']/table/tbody/tr[2]/td/table/tbody/tr[";
		String Afterxpath = "]/td[";
		Boolean Flag = false;
		final int totalweekval = 7;
		for(int row=2;row<totalweekval;row++)
		{
			for(int col=1;col<8;col++)
			{
				String Date1 = webdriver.findElement(By.xpath(Beforexpath+row+Afterxpath+col+"]")).getText();
				System.out.println(Date1);
				if(Date1.equals(Date))
				{
					webdriver.findElement(By.xpath(Beforexpath+row+Afterxpath+col+"]")).click();
					Flag= true;
					break;
				}
				
			}
			
			if(Flag)
			{
				break;
			}
		}
		
	}

}
