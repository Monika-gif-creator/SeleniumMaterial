package testng;

import org.testng.annotations.Test;

public class GoogleTest {
	
	@Test(priority=1,groups="A")
	public void testGoogle1()
	{
		System.out.println("google 1");
		
	}
		
	@Test(priority=4)
	public void googleHomePage()
	{
		System.out.println("google Homepage");
	}
	
	@Test(priority=2)
	public void googleSearchBox()
	{
		System.out.println("googleSearchBox");
	}
	
	@Test(priority=5)
	public void googlePage()
	{
		System.out.println("googlePage");
	}
	
	@Test(priority=3)
	public void googleEndPage()
	{
		System.out.println("google EndPage");
	}

}
