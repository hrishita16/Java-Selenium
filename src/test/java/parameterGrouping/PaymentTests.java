package parameterGrouping;


import org.testng.annotations.Test;

public class PaymentTests {
	
	@Test(priority = 1, groups = {"sanity","regression", "functional"})
	void paymentByRupee() {
		System.out.println("This is payment by rupee");
	}
	
	@Test(priority = 2, groups = {"sanity","regression", "functional"})
	void paymentByDollar() {
		System.out.println("This is payment by dollar");
	}

}
