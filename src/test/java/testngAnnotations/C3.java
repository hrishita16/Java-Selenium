package testngAnnotations;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class C3 {
	
	@Test
	void pqr() {
		System.out.println("this is pqr from C3");
	}
	
	@BeforeSuite
	void bs() {
		System.out.println("this is before suite method");
	}
	
	@AfterSuite
	void as() {
		System.out.println("this is after suite method");
	}

}
