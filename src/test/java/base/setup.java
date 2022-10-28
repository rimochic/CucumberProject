package base;

import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;

public class setup {
	
	 WebDriver driver;
	 
	 
	 public WebDriver launchBrowser() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		 return driver;
	 }
	 
	
//	 public void getScreenshot(Scenario sc) {
//		if(sc.isFailed()) {
//			String screenshotName = sc.getName().replace(" ", "_");
//			byte[] srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
//			sc.attach(srcPath, "image.png", screenshotName);
//		}
//	 }

}
