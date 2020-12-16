package testng;

import org.testng.annotations.Test;

public class TestngFeatures {
	
	@Test
	public void login()
	{
		System.out.println("login the page");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods = "login")
	public void Homepage()
	{
		System.out.println("Homepage is displaying");
	}

}
