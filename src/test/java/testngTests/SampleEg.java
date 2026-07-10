package testngTests;

import org.testng.annotations.Test;

public class SampleEg {
	
	
	@Test(priority = -1)
	void openapp() {
		System.out.println("Opening application....");
	}
	
	@Test(priority = 0)
	void login() {
		System.out.println("logging in application....");
	}
	
	@Test(priority = 1)
	void logout() {
		System.out.println("logging out application....");
	}

}

/*
 * 		1) 		TestNG execute test methods based on alphabetical order.
 * 		2) 		@Test(priority=num) controls the order of execution. 
 * 		3) 		Once you provide priorty to the test methods, then order of methods is not considered. 
 * 		4) 		priorities can be random numbers( no need to have consecutive numbers) 
 * 		5) 		default priority value is Zero (0). 
 * 		6) 		if the priorities are same then again execute methods in alphabetical order. 
 * 		7) 		Negitive priority allowed 
 * 		8) 		TestNG execute test methods only if they are having @Test annotation.
 */