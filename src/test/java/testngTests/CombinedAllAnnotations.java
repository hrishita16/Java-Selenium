package testngTests;

import org.testng.annotations.*;

public class CombinedAllAnnotations {
	
	@BeforeSuite
	void bsuite() {
		System.out.println("this is before suite method");
	}
	@AfterSuite
	void asuite() {
		System.out.println("this is after suite method");
	}
	
	
	
	@BeforeTest
	void bt() {
		System.out.println("\t this is before test method");
	}
	@AfterTest
	void at() {
		System.out.println("\t this is after test method");
	}
	
	
	
	@BeforeClass
	void bs() {
		System.out.println("\t \t this is after class method");
	}
	@AfterClass
	void as() {
		System.out.println("\t \t this is after class method");
	}
	
	
	
	@BeforeMethod
	void bm() {
		System.out.println("\t \t \t this is before method");
		System.out.println();
	}
	@AfterMethod
	void am() {
		System.out.println("\t \t \t this is after method");
	}
	
	
	

	@Test
	void tm1() {
		System.out.println("\t \t \t \t \t \t this is test 1");
		System.out.println();
	}
	@Test
	void tm2() {
		System.out.println("\t \t \t \t \t \t this is test 2");
		System.out.println();
	}
}
