package testNGTests;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.Status;

import pages.Page1;

public class Test1 extends TestBase{
//	public static WebDriver driver=null;
	
//	private static Logger log=LogManager.getLogger(Test1.class.getName());
	

	@Test(enabled=true)
	public void testcase1() {
		SoftAssert sassert = new SoftAssert();
		String searchText = "testing Google search";
		System.out.println("Test case 1");
		driver.get().get("http://www.google.com.ar");
		Page1 page = new Page1(driver.get());
		page.searchText(driver.get(), searchText);	
		sassert.assertEquals(page.getTitle(driver.get()), searchText + " - Buscar con Google");
		extentTest.get().log(Status.PASS, "Test1 PASSED");
//		log.error("test error message");
//		log.info("completed step");
//		log.fatal("test fatal error");
		sassert.assertAll();
	}

}