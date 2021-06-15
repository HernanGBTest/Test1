package mavenproject.selenium1;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class Test1 {
	public static WebDriver driver=null;
	ExtentReports extent;
	private static Logger log=LogManager.getLogger(Test1.class.getName());
	
	@BeforeSuite
	public void beforeSuite() {
		System.setProperty("webdriver.chrome.driver", "e:\\Mavenproject\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		driver = new ChromeDriver(options);
		
	}
	
	@BeforeTest
	public void beforeTest() {
		
		String path= System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hernán");
	}
	
	@Test
	public void testcase1() {
		extent.createTest("Google Search");
		SoftAssert sassert = new SoftAssert();
		String searchText = "testing Google search";
		System.out.println("Test case 1");
		driver.get("http://www.google.com.ar");
		Page1 page = new Page1(driver);
		page.searchBar.sendKeys(searchText);
		page.buscar.click();	
		sassert.assertEquals(page.driver.getTitle(), searchText + " - Buscar con Google");
		log.error("test error message");
		log.info("completed step");
		log.fatal("test fatal error");
		sassert.assertAll();
		extent.flush();
	}
	

	

}