package testNGTests;


import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

public class Test2 extends TestBase {

	@Test
	public void testmethod2() {
		SoftAssert sassert = new SoftAssert();
		System.out.println("test2");
		driver.get().get("https://test.salesforce.com");
		extentTest.get().log(Status.PASS, "Test2 PASSED");
		sassert.assertAll();
	}
}
