package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class AjaxPage {

	WebDriver driver = null;
	public AjaxPage(WebDriver driver){
		this.driver = driver;
		PageFactory.initElements(new AjaxElementLocatorFactory(driver,5), this);
//		PageFactory.initElements(driver,this);
	}
	
	@FindBy(id="yes")
	WebElement radioYes;
	
	@FindBy(id="no")
	WebElement radioNo;
	
	@FindBy(xpath="//input[@type='reset']")
	WebElement reset;
	
	@FindBy(id="buttoncheck")
	WebElement check;
	
	@FindBy(xpath="//p[contains(text(),'value is No')]")
	WebElement text;
	
	public WebElement getYes() {
		return radioYes;
	}
	
	public WebElement getNo() {
		return radioNo;
	}
	
	
	public WebElement getReset() {
		return reset;
	}
	
	public WebElement getCheck() {
		return check;
	}
	
	public WebElement getText() {
		return text;
	}
}
