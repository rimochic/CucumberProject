package stepDefinitions;

import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import base.setup;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import pageObjects.loginObjects;

public class steps extends setup{
	
	WebDriver driver;
	loginObjects lo;
	
	@Before
	public void setu() {
		driver = launchBrowser();
	}
	
	@Given("launch the browser")
	public void launch_the_browser() {
		
		lo = new loginObjects(driver);
	}

	@When("open the URL")
	public void open_the_url() {
	   driver.get("http://automationpractice.com/index.php?controller=authentication&back=my-account#account-creation");
	}

	@Then("page title should be {string}")
	public void page_title_should_be(String title) {
	  Assert.assertEquals(title, lo.getLoginPageTitle());
	}

	@And("close the browser")
	public void close_the_browser() {
	    driver.quit();
	}

	@Then("Forgot your password link should be displayed")
	public void forgot_your_password_link_should_be_displayed() {
		if(lo.forgetPasswordLink() == true) {
			Assert.assertTrue(true);
		}
		else {
			Assert.assertTrue(false);
			driver.close();
		}
		
	}

	@When("user enters username {string} and the password {string}")
	public void user_enters_username_and_the_password(String username, String pwd) {
	   lo.enterUserName(username);
	   lo.enterPassword(pwd);
	}
	
	
	
	@And("user clicks on Login button")
	public void user_clicks_on_login_button() {
	   lo.clickLogin();
	}
	
	@After
	public void getScreenshot(Scenario sc) {
		if(sc.isFailed()) {
			String screenshotName = sc.getName().replace(" ", "_");
			byte [] srcPath = ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
			sc.attach(srcPath, "image.png", screenshotName);
		}
	 }


}
