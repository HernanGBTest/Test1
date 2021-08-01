package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Page1 {
	
	@FindBy(xpath = "//div/div[3]/center/input[@value='Buscar con Google']")
	WebElement buscar;
	
	@FindBy(xpath="//input[@title='Buscar']")
	WebElement searchBar;
	
	WebDriver driver;
	
	public Page1(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void searchText(WebDriver driver, String searchText) {
		searchBar.sendKeys(searchText);
		buscar.click();	
	}

	public String getTitle(WebDriver driver) {
		return driver.getTitle();
	}
}
