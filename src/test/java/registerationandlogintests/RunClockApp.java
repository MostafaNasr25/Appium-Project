package registerationandlogintests;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class RunClockApp {

	AndroidDriver driver ;

	@BeforeTest
	public void openApp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
		caps.setCapability(MobileCapabilityType.DEVICE_NAME, "Nexus_6P");
		
		caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE,"com.google.android.deskclock");
		caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY,"com.android.deskclock.DeskClock");
		
		 driver = new AndroidDriver (new URL("http://127.0.0.1:4723/wd/hub"),caps);
		 driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	

	@SuppressWarnings("deprecation")
	@Test
	public void testApp() {
		WebElement alarm = driver.findElement(MobileBy.AccessibilityId("Alarm"));
		alarm.click();
				
		WebElement clock = driver.findElement(MobileBy.AccessibilityId("Clock"));
		clock.click();
		
		WebElement globalbtn = driver.findElement(By.id("com.google.android.deskclock:id/fab"));
		globalbtn.click();
		
		WebElement searchbtn = driver.findElement(By.id("com.google.android.deskclock:id/search_button"));
		searchbtn.click();
		
		WebElement searchtxtbx = driver.findElement(MobileBy.className("android.widget.EditText"));
		searchtxtbx.sendKeys("Cairo");
		searchtxtbx.clear();
		
		WebElement backbtn = driver.findElement(MobileBy.AccessibilityId("Navigate up"));
		backbtn.click();
		
		
		WebElement Timer = driver.findElement(MobileBy.AccessibilityId("Timer"));
		Timer.click();

		WebElement StopWatch = driver.findElement(MobileBy.AccessibilityId("Stopwatch"));
		StopWatch.click();

		
	}
	
	
	@AfterTest
	public void closeApp() {
		driver.quit();
	}
	

}
