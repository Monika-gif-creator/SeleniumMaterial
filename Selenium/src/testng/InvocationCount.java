package testng;

import org.testng.annotations.Test;

public class InvocationCount {
	
   @Test(invocationCount = 5)
   public void RepeatATestCase()
   {
	   System.out.println("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA");
   }
	
}
