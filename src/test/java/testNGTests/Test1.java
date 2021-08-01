package testNGTests;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import pages.AjaxPage;
import pages.Page1;

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
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		
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
	
	@Test(enabled=false)
	public void testcase1() {
		extent.createTest("Google Search");
		SoftAssert sassert = new SoftAssert();
		String searchText = "testing Google search";
		System.out.println("Test case 1");
		driver.get("http://www.google.com.ar");
		Page1 page = new Page1(driver);
		page.searchText(driver, searchText);	
		sassert.assertEquals(page.getTitle(driver), searchText + " - Buscar con Google");
		log.error("test error message");
		log.info("completed step");
		log.fatal("test fatal error");
		sassert.assertAll();
		extent.flush();
	}
	
	@Test
	public void uploadFileTest() throws InterruptedException, IOException {
		extent.createTest("Upload File");
		SoftAssert sassert = new SoftAssert();
//		driver.get("https://www.ilovepdf.com/pdf_to_word");
//		driver.findElement(By.xpath("//span[text()='Select PDF file']")).click();
//		Thread.sleep(3000);
//		Runtime.getRuntime().exec("E:\\Mavenproject\\uploadscript.exe");
		driver.get("http://demo.guru99.com/test/ajax.html");
		AjaxPage ajaxPage = new AjaxPage(driver);
		Thread.sleep(3000);
//		System.out.println(ajaxPage.getText().getText());
		ajaxPage.getYes().click();
		ajaxPage.getCheck().click();
//		ajaxPage.getNo().click();
//		ajaxPage.getCheck().click();
		WebElement text=ajaxPage.getText();
		text.click();
		sassert.assertAll();
		extent.flush();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.quit();
	}
	

}