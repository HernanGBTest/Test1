package testNGTests;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class TestBase {
	protected static ThreadLocal<WebDriver> driver = new ThreadLocal<WebDriver>();
	String path= System.getProperty("user.dir") + "\\reports\\index.html";
	public ExtentSparkReporter reporter = new ExtentSparkReporter(path);
	public static ExtentReports extent;
	protected static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<ExtentTest>();
	
	@BeforeSuite
	public void beforeSuite() {
		reporter.config().setReportName("Web Automation Results");
		reporter.config().setDocumentTitle("Test results");
		extent = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Hernán");
		}
	
	@BeforeMethod
	public void beforeMethod(ITestResult result) {
		ExtentTest test = extent.createTest(result.getMethod().getMethodName());
		extentTest.set(test);
		driver.set(initDriver());
		
	}
	
	@AfterMethod
	public void afterMethod() {
		driver.get().close();
	}
	
	@AfterSuite
	public void afterSuite() {
		driver.get().quit();
		extent.flush();
		
	}
	
	public WebDriver initDriver() {
		System.setProperty("webdriver.chrome.driver", "e:\\Mavenproject\\chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");
		WebDriver driver = new ChromeDriver(options);
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		return driver;
	}
}
