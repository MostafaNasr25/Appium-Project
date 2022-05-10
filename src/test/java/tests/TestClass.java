package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestClass extends BaseClass {
	
	BaseClass baseclass;
	
	@Test
	public void checkSearch() {
		driver.getTitle();
		baseclass = new BaseClass();
		baseclass.searchFor();
		
		WebElement vodafonelink = driver.findElement(By.xpath("//span[text()='Vodafone.com.eg - Vodafone Egypt - Manage Your Account']"));
		Assert.assertTrue(vodafonelink.isDisplayed());
	}
	
}
