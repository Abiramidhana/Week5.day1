package week4;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseclassServiceNowFrame {
	public  ChromeDriver driver;

	@BeforeMethod
	public void precondition() throws InterruptedException {
		
	WebDriverManager.chromedriver().setup();
	 driver= new ChromeDriver();
		driver.get("https://dev71708.service-now.com");
		driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@name='user_name' and @type='text']")).sendKeys("admin");
		driver.findElement(By.xpath("//input[@name='user_password' and @type='password']")).sendKeys("Lordmurugan!2020");
		driver.findElement(By.name("not_important")).click();
		driver.findElement(By.id("filter")).sendKeys("incident");
	}

	@AfterMethod
	public void postcondition() {
		driver.close();
	}

}
