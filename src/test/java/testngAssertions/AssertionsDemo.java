package testngAssertions;

import org.testng.Assert;

public class AssertionsDemo {
	
	void testTitle() {
		String t1 = "opencart";
		String t2 = "openshop";
		
		/*
		if(t1.equals(t2)) {
			System.out.println("passed");
		}else {
			System.out.println("failed");
		}
		*/
		
		
		//the above if conditon will give the ans but the actual test, ie, testTile will still show "passed"
		//to fix this, we use
		Assert.assertEquals(t1, t2);
		
		
			//also you can print the same
		/*
		if(t1.equals(t2)) {
			System.out.println("passed");
			Assert.assertTrue(true);
		}else {
			System.out.println("failed");
			Assert.assertTrue(false);
		}
		*/
	}

}
