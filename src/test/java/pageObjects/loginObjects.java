package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginObjects {
	
	 private WebDriver driver;

	    public loginObjects(WebDriver driver){
	        this.driver=driver;
	        PageFactory.initElements(driver,this);
	    }
	    
	    @FindBy(id ="email")
	    private WebElement email;
	    @FindBy(id="passwd")
	    private WebElement password;
	    @FindBy(id="SubmitLogin")
	    private WebElement submitBtn;
	    @FindBy(linkText = "Forgot your password?")
	    private WebElement forgetPassword;

	    public String getLoginPageTitle(){
	        driver.getTitle();
	        return driver.getTitle();
	    }
	    
	    public boolean forgetPasswordLink (){
	        boolean status = forgetPassword.isDisplayed();
	        return status;
	    }
	    
	    public void enterUserName(String Uname){
	        email.sendKeys(Uname);
	    }
	    
	    public void enterPassword(String pwd){
	        password.sendKeys(pwd);
	    }
	    
	    public void clickLogin(){
	        submitBtn.click();
	    }

}
