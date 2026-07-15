package testngAssertions;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class HardvsSoftAssertions {
	
	@Test
	void test_hardAssertions() {
		System.out.println("testing ....");
		System.out.println("testing ....");
		
		Assert.assertEquals(1, 2);		//test fails here, rest of statements will NOT execute
		
		System.out.println("testing ....");
		System.out.println("testing ....");
	}
	
	
	@Test
	void test_softAssertions() {
		System.out.println("testing ....");
		System.out.println("testing ....");
		
		SoftAssert soft = new SoftAssert();		//for soft assertions, we need to create obj of the class
		soft.assertEquals(1, 2);		//even though test fails here, remaining statements are executed
		
		System.out.println("testing ....");
		System.out.println("testing ....");
		
		soft.assertAll();		//this is a mandatory statement at last in soft assertions
								// if this is not written, the test will show passed even if it actually failed
								// by default, soft assertions are passed if this statement not written
	}

}
