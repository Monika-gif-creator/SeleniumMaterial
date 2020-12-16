package basic;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class TestngBasic {

//pre condition
 @BeforeSuite
 public void setup()
 {
	System.out.println("This is setup method");
 }
 
 @BeforeClass
 public void launchBrowser()
 {
	System.out.println("This is launch Browser method");
 }
 
 @BeforeMethod
 public void enterURL()
 {
	System.out.println("This is URL method");
 }
 
 //test cases starting with test
 @Test
 public void googleTestTitle()
 {
	System.out.println("This is google site");
 }
 
 //post condition
 @AfterMethod
 public void logout()
 {
	System.out.println("This is logout method");
 }
 
 @AfterTest
 public void deleteAllcookies()
 {
	System.out.println("This is deleteAllcookies method");
 }
 @AfterClass
 public void clearBrowser()
 {
	System.out.println("This is clearBrowser method");
 }
 
 @AfterSuite
 public void generateReport()
 {
	System.out.println("This is generateReport method");
 }
}


