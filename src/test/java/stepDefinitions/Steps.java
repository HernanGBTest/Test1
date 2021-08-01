package stepDefinitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.Page1;
import testNGTests.Test1;
import testNGTests.TestBase;



public class Steps extends TestBase{

	ExtentReports extent;
	private static Logger log=LogManager.getLogger(Test1.class.getName());
//	public static WebDriver driver=null;
	SoftAssert sassert = new SoftAssert();
	String searchText = "" ;
	Page1 page = null;
	
	@Given ("Browser is opened")
	public void browser_is_opened() {
		String path= System.getProperty("user.dir") + "\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hernán");
		extent.createTest("Google Search");
		beforeSuite();
	}
	
	@Given("User navigates to {string}")
	public void user_navigates_to_url(String url) {
		driver.get().get(url);
		
	}
	@When("User enters (.+) and clicks on search$")
	public void user_enters_text_and_clicks_login(String searchtext) {
		searchText = searchtext;
		page= new Page1(driver.get());
		page.searchText(driver.get(), searchText);
		System.out.println("Texto a buscar: " + searchText);
	}
	@Then("Search results page is opened")
	public void landing_page_is_opened() {
		sassert.assertEquals(page.getTitle(driver.get()), searchText + " - Buscar con Google");
		sassert.assertAll();
		extent.flush();
	}
	
	@And("Close browser")
	public void close_browser() {
		driver.get().close();
	}

}
