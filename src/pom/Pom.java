package pom;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Pom {
	@FindBy(xpath = "//span[@class='mat-mdc-button-touch-target']")
	public List<WebElement> showmap;
	
	@FindBy(xpath = "//span[text()='capture']")
	public WebElement capture;
	
	public Pom(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public List<WebElement> showmap() {
		return showmap;
	}
	public WebElement capture() {
		return capture;
	}
	
}
