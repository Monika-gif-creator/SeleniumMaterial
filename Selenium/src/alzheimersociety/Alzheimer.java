package alzheimersociety;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Alzheimer {
	
    static WebDriver driver; 
	
	public void invokeBrowser()
	{
		
		System.setProperty("webdriver.chrome.driver","C:\\selenium_new\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().deleteAllCookies();
	    
		driver.get("https://alzheimers-donations.wpnc-uat.site/home/");
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	}
	
	public static void main(String[] args) throws InterruptedException {
	
	//Test Case Purpose: "As a user I want to donate 10 GBP by using single donation option "
	    
	     /*Step-1 : Lunch Alzheimers Society donation platform
           Verification: Alzheimers Logo should display*/
		
		     Alzheimer donation = new Alzheimer();
		     donation.invokeBrowser();
		     
	
		     boolean alzheimersLogo = driver.findElement(By.xpath("//a[@class='o-alzheimers-logo']")).isDisplayed();
			 String title = driver.getTitle();
			 System.out.println(title);
			 if(alzheimersLogo==true)
			  {
			    	System.out.println("Verification Successful - The alzheimers Logo is displayed on the web page.");
			  }
			  else
			  {
				  System.err.println("Verification Failed - The alzheimers Logo is not displayed on the web page.");
			  }
			 if(title.equals("Alzheimer's Society"))
			 {
			    	System.out.println("Successfully Landing to the correct Url");
			  }
			  else
			  {
				  System.err.println("Incorrect Landing page is getting displayed");
			  } 
			    
	        
		/*Step-2 : Select Single donation option and Enter the amount and Click on continue button
		Verification: Verify single donation tab is selected*/
	         JavascriptExecutor js = ((JavascriptExecutor) driver);
	 		 js.executeScript("window.scrollBy(0,500)");
	 		 driver.findElement(By.xpath("//a[contains(text(),'Monthly donation')]")).click();
	 		 Thread.sleep(2000);
	 		 driver.findElement(By.xpath("//a[contains(text(),'Single donation')]")).click();
	 		 Thread.sleep(1000);
	 		 
	
	 		String singledonationenable = driver.findElement(By.xpath("//a[@aria-controls='profile']")).getAttribute("aria-expanded");
	 		System.out.println(singledonationenable);
	 		if(singledonationenable.equals("true"))
			{
			  System.out.println("Single donation tab is now selected");
			 }
			  else
			{
			  System.err.println("Single donation tab is not selected");
			} 
	 	String DonationAmount = "10";
	 	driver.findElement(By.xpath("//div[@class='tab-pane oneoff active']//input[@id='txtAmount']")).sendKeys(DonationAmount);
	 	driver.findElement(By.xpath("//div[@class='tab-pane oneoff active']//button[@type='submit']")).click();
	 	
	   /*Step-3 : "Enter Single Donation amount fields"
	              "Click On the my donation in the memory of someone"
	 	          "Click the radio button-"a personal donation - my own money" and then click on continue button"
	     Verification: Verify Single Donation Amount Page is displayed
	               After Continue Button single payment detail page is getting display
	               Verify that the correct donation amount should display
	               */
	 String singledonationamount = driver.findElement(By.xpath("//li[@class='c-steps__step is-active']//a//span")).getText();
	 if(singledonationamount.equals("Single Donation Amount"))
	 {
	    	System.out.println("Single Donation Page is present");
	  }
	  else
	  {
		  System.err.println("Single Donation Page is not present");
	  } 
	 driver.findElement(By.xpath("//li[@class='c-steps__step is-active']")).isEnabled();
	 String AmountOnSingleDonPage =driver.findElement(By.xpath("//input[@data-msg-required='Please enter the amount you wish to donate']")).getAttribute("value");
	 if(AmountOnSingleDonPage.equals(DonationAmount))
	 {
	    	System.out.println("Correct Amount of donation is present");
	  }
	  else
	  {
		  System.err.println("Incorrect amount of donation is present");
	  } 
	  Thread.sleep(3000);
	  driver.findElement(By.xpath("//a[@aria-label='dismiss cookie message']")).click();
	  String DonationPurpose = "\"My donation is in memory of someone\"";
	  driver.findElement(By.xpath("//label[@class='e-label e-label_inline']//span[text()="+DonationPurpose+"]//parent::span")).click();
	  
	  String Relationship ="Daughter";
	  String FirstName= "Sam";
	  String LastName= "Alex";
	  Select select = new Select(driver.findElement(By.xpath("//select[@name='InMemoryDonorRelationship']")));
	  select.selectByVisibleText(Relationship);
	  driver.findElement(By.xpath("//input[@name='InMemoryDeceasedFirstName']")).sendKeys(FirstName);
	  driver.findElement(By.xpath("//input[@name='InMemoryDeceasedLastName']")).sendKeys(LastName);
	  js.executeScript("window.scrollBy(0,500)");
	  driver.findElement(By.xpath("//*[@id='main']/div[2]/form/section[1]/div/fieldset/section/section/div[2]/label/span")).click();
	  driver.findElement(By.xpath("//*[@id='main']/div[2]/form/section[1]/div/fieldset/section/section/div[1]/label/span")).click();
	  driver.findElement(By.xpath("//button[@id='btnContinue']//span")).click();
	  driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	  
	  /*Step-4 : Enter Payment Detail using Credit.Debit Card option
	  			*My Details Section
	  			*Address Section
	  Verification:Verify the payment page should display
	               Verify the donation in the payment page
	               Verify the thank you page should display
	               */
	  String paymentdetails = driver.findElement(By.xpath("//li[@class='c-steps__step is-active']//a//span")).getText();
		 if(paymentdetails.equals("Single Payment Details"))
		 {
		    	System.out.println("Single Payment Details is present");
		  }
		  else
		  {
			  System.err.println("Single Payment Details is not present");
		  }      
		driver.findElement(By.xpath("//li[@class='c-steps__step is-active']")).isEnabled();     

	 String DonationInPaymentPage = driver.findElement(By.xpath("//h1[@class='c-donate-section__title']/parent::div//p")).getText();
	 String DonationText="You are making a single donation of: £"+DonationAmount+"";
	 System.out.println(DonationText);
	 if(DonationInPaymentPage.equals(DonationText))
	 {
	    	System.out.println("Correct Amount of donation is present");
	  }
	  else
	  {
		  System.err.println("Incorrect amount of donation is present");
	  } 
	 
	 //Card Details
	 String CreditCard ="4000 0000 0000 1000";
	 String ExpiryDate= "0521";
	 String SecurityCode = "123";
	 js.executeScript("window.scrollBy(0,500)");
	 Thread.sleep(3000);
	 clickOn(driver, driver.findElement(By.xpath("//a[@id='btnCC']//span")),20);
	 Thread.sleep(3000);
	 
	 driver.switchTo().frame("braintree-hosted-field-number");
	 driver.findElement(By.xpath("//input[@id='credit-card-number']")).sendKeys(CreditCard);
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("braintree-hosted-field-expirationDate");
	 driver.findElement(By.xpath("//input[@id='expiration']")).sendKeys(ExpiryDate);
	 driver.switchTo().defaultContent();
	 driver.switchTo().frame("braintree-hosted-field-cvv");
	 driver.findElement(By.xpath("//input[@placeholder='CVC']")).sendKeys(SecurityCode);
	 driver.switchTo().defaultContent();
	 
	 //My Details
	 js.executeScript("window.scrollBy(0,800)");
	 String Title ="Mr";
	 String FirstNameInDetails="Aditya";
	 String LastNameInDetails="Dash";
	 String Email="aditya.dash@niit-tech.com";
	 String MobileNo="09871734450";
	 
	 driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
	 Select TitleDropdown = new Select(driver.findElement(By.xpath("//select[@id='ddTitle']")));
	 TitleDropdown.selectByVisibleText(Title);
	 driver.findElement(By.xpath("//input[@id='txtFirstName']")).sendKeys(FirstNameInDetails);
	 driver.findElement(By.xpath("//input[@id='txtLastName']")).sendKeys(LastNameInDetails);
	 driver.findElement(By.xpath("//input[@name='Email']")).sendKeys(Email);
	 driver.findElement(By.xpath("//input[@id='phoneNo-test']")).sendKeys(MobileNo);
	 
	 //Address
	 js.executeScript("window.scrollBy(0,500)");
	 String PostCode = "BD9 4NP";
	 driver.findElement(By.xpath("//input[@id='findAddressFld']")).sendKeys(PostCode);
	 Thread.sleep(7000);
	 driver.findElement(By.xpath("//div[@class='pcaitem pcafirstitem pcaselected']")).click();
	 
	 js.executeScript("window.scrollBy(0,300)");
	 driver.findElement(By.xpath("//input[@name='AddressSameYes']/parent::label//span")).click();
	 js.executeScript("window.scrollBy(0,1000)");
	 driver.findElement(By.xpath("//button[@id='btnCompleteSingleDonation']")).click();
	 
	String ThankYou = driver.findElement(By.xpath("//h1[@class='c-thank-you__title large']")).getText();
	if(ThankYou.contains("Thank you"))
	 {
	    	System.out.println("Successfully completed the donation");
	  }
	  else
	  {
		  System.err.println("Not able to complete the payment");
	  }
	         
	 }
	public static void clickOn(WebDriver driver, WebElement locator,int timeout)
	{
	new WebDriverWait(driver, timeout).ignoring(StaleElementReferenceException.class).until(ExpectedConditions.elementToBeClickable(locator));
	locator.click();
	}
	
	}


