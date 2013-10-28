package selenium;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class FindOwnersTest {

	private static WebDriver driver;

	@BeforeClass
	public static void startDriver() {
		driver = Utils.getDriver();
	}
	
	@Test
	public void find_owners_should_list_me() {
		driver.get(Utils.getBaseUrl());
		
		driver.findElement(By.partialLinkText("Find owners")).click();
		driver.findElement(By.linkText("Add Owner")).click();
		
		driver.findElement(By.id("firstName")).sendKeys("Rickard");
		driver.findElement(By.id("lastName")).sendKeys("von Essen");
		driver.findElement(By.id("address")).sendKeys("Industrigatan 9");
		driver.findElement(By.id("city")).sendKeys("Stockholm");
		driver.findElement(By.id("telephone")).sendKeys("070776655");
		driver.findElement(By.xpath("//button")).click();
		
		driver.findElement(By.partialLinkText("Find owners")).click();
		driver.findElement(By.xpath("//input[@id='lastName']")).sendKeys("von Essen");
		driver.findElement(By.xpath("//button")).click();
	
		//driver.findElement(By.xpath("//tbody")).findElement(By.linkText("Rickard von Essen"));
	}
	
	@AfterClass
	public static void stopDriver() {
		driver.quit();
	}
}
