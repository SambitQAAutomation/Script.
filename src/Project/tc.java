package Project;

import java.awt.Desktop.Action;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import pom.Pom;



public class tc {


	@Test
	public void Capture() throws InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		int countcatch=0;
		int click=0;
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		driver.get("http://localhost:5021/capture");
		
		Pom p=new Pom(driver);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		WebElement show = driver.findElement(By.xpath("//span[text()='showmap']"));

		Thread.sleep(9000);
		int count = p.showmap().size();
		System.out.println(count);
		
		for(int i=0;i<=count;i++) {
			
			try {
			WebElement link = p.showmap().get(i);
			wait.until(ExpectedConditions.elementToBeClickable(link));
			Thread.sleep(8000);
					
			
				Actions a=new Actions(driver);
				a.moveToElement(link).click().perform();
				
				WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
				wait1.until(ExpectedConditions.elementToBeClickable(p.capture()));
				p.capture().click();
				System.out.println("count_try"+click++);
				
				Thread.sleep(8000);
				
				 if ((i + 0) % 20 == 0) {
			            System.out.println("Refreshing browser after " + (i + 1) + " iterations.");
			            driver.navigate().refresh();
			            Thread.sleep(15000);
			            System.out.println(count-i);
				 }
			}
			catch (Exception o) {
				
//				 if(!show.isDisplayed()) {
//					 System.out.println();
//					 driver.navigate().refresh();
//					 Thread.sleep(6000);
//				 }
				i++;
				countcatch++;
				System.out.println("count_Time_catch"+ countcatch);
			}
		}
	}
}
