package week4;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;


import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.testng.annotations.Test;



public class ServiceNowFrames extends BaseclassServiceNowFrame {
@Test
public  void method() throws IOException  {
		driver.findElement(By.xpath("(//div[contains(text(),'All')])[2]")).click();
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
		driver.findElement(By.id("lookup.incident.caller_id")).click();
		Set<String>windowHandles =driver.getWindowHandles();
		List<String>windowList =new ArrayList<String>(windowHandles);
		driver.switchTo().window(windowList.get(1));
		driver.findElement(By.xpath("(//a[@class='glide_ref_item_link'])[1]")).click();
		driver.switchTo().window(windowList.get(0));
		driver.switchTo().frame(0);
		driver.findElement(By.xpath("//input[@id='sys_display.incident.short_description']/following-sibling::input")).sendKeys("Short desc");
		driver.findElement(By.xpath("(//span[@class='navbar_ui_actions']/button)[1]")).click();
		String incidentNumber =driver.findElement(By.xpath("(//td[@class='vt'])[1]")).getText();
		driver.findElement(By.xpath("(//input[@placeholder='Search' and @class='form-control'])")).sendKeys(incidentNumber,Keys.ENTER);
		String  incidentNumber2 =driver.findElement(By.xpath("(//td[@class='vt'])[1]")).getText();
		if(incidentNumber.equals(incidentNumber2)) {
			System.out.println("Incident has been created successfully");
		}
		File src =driver.getScreenshotAs(OutputType.FILE);
		File dest =new File("./src/snap/ServiceNow.jpg");
		FileUtils.copyFile(src, dest);
		  
	}

}


