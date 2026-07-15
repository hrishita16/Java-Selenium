package testngAnnotations;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/*
1) Login 		- 		@BeforeMethod
2) Search		- 		@Test
3) Logout 		- 		@AfterMethod
4) Login
5) Adv search 	- 		@Test
6) Logout
*/
public class AnnotationsDemo1 {
	
	@BeforeTest
	void login() {
		System.out.println("this is login");
	}
	
	@AfterTest
	void logout() {
		System.out.println("this is logout");
	}
	
	@Test(priority = 1)
	void search() {
		System.out.println("this is search");
	}
	
	@Test(priority = 2)
	void advSearch() {
		System.out.println("this is advance search");
	}
}
/*
		as we need to go in the abover order mentioned 1 - 6, 
		we need to login twice, but we write the method only once. We specify that it should be executed before every test case
		test cases are annotations with @Test
*/