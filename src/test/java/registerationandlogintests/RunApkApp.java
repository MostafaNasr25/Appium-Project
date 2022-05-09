package registerationandlogintests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.xml.xpath.XPath;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class RunApkApp {
	
	AndroidDriver driver ;
	
	@BeforeTest
	public void openApp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P");
		
		String AppBath = System.getProperty("user.dir")+"/App/QAcart-To-Do.apk";
		caps.setCapability(MobileCapabilityType.APP,AppBath);
		
		 driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
	
	@SuppressWarnings("deprecation")
	@Test(priority = 1)
	public void userCanRegister() {
		WebElement signupbtn = driver.findElement(MobileBy.AndroidUIAutomator("text(\"Signup\")"));
		signupbtn.click();
		
		WebElement username = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Full name']"));
		username.click();
		username.sendKeys("MostafaNasr");
		
		WebElement email = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Email']"));
		email.click();
		email.sendKeys("Test147@test.com");
		
		WebElement password = driver.findElement(By.xpath("//android.widget.EditText[@text='Enter your Password']"));
		password.click();
		password.sendKeys("14785236");
		
		/*
		 * List<WebElement> userdata =
		 * driver.findElements(By.className("android.widget.EditText"));
		 * userdata.get(0).sendKeys("MostafaNasr");
		 * userdata.get(1).sendKeys("test120@test.com");
		 * userdata.get(2).sendKeys("1478520256");
		 */
	}
	
	
	
	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
	
	
}
