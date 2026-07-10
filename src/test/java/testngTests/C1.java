package testngTests;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class C1 {
	
	@Test
	void abc() {
		System.out.println("This is abc from C1 .....");
	}
	
	@BeforeTest
	void bt() {
		System.out.println("this is before test method ....");
	}

}

/*
	@BeforeTest & @AFterTest  ----> for more than one classes
	@BeforeCLass & @AFterClass  ----> used inside a class
 */