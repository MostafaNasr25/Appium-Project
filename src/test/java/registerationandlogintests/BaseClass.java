package registerationandlogintests;

import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseClass {

	public static AndroidDriver driver ;

	@SuppressWarnings("deprecation")
	@BeforeSuite
	public void openApp(){
		try {
			DesiredCapabilities caps = new DesiredCapabilities();
			caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
			caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P");

			caps.setCapability(MobileCapabilityType.BROWSER_NAME, "chrome");
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
			driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
			driver.navigate().to("http://www.google.com");
		} catch (Exception e) {
			System.out.println("cause is : " +e.getCause() );
		}

	}
	
	public void searchFor() {
		WebElement srchbx = driver.findElement(By.name("q"));
		srchbx.sendKeys("vodafone");
		srchbx.sendKeys(Keys.ENTER);
	}
	
	


	
	@AfterSuite
	public void closeApp() {
		driver.quit();
	}

}
