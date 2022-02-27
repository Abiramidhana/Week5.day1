package week4;
import org.openqa.selenium.By;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
public class CreateLead extends BaseClass {
	@Parameters({"cmpnyname","firstname","lastname"})
@Test
		public  void createLead(String cmpnyname,String firstname,String lastname)
		{
			driver.findElement(By.linkText("CRM/SFA")).click();
			driver.findElement(By.linkText("Leads")).click();
			driver.findElement(By.linkText("Create Lead")).click();
			driver.findElement(By.id("createLeadForm_companyName")).sendKeys("cmpnyname");
			driver.findElement(By.id("createLeadForm_firstName")).sendKeys("firstname");
			driver.findElement(By.id("createLeadForm_lastName")).sendKeys("lastname");
			driver.findElement(By.name("submitButton")).click();
			driver.close();
	}
	}

