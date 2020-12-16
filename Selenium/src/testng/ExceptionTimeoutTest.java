package testng;

import org.testng.annotations.Test;

public class ExceptionTimeoutTest {
	
	//@Test(invocationTimeOut = 2000)
	/*public void InfineLoop()
	{
		int i = 1;
		while(i==1)
		{
			System.out.println("Print 1");
		}
	}*/
	
	@Test(expectedExceptions = NumberFormatException.class)
	public void ExpectedException()
	{
		String x = "100A";
		Integer.parseInt(x);
	}

}
