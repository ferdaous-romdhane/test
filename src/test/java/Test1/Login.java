package Test1;

import static org.junit.Assert.assertEquals;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class Login {
    WebDriver driver;

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
        this.driver = new ChromeDriver();  // Corrected line
        driver.get("http://192.168.1.192:3000/");
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }
	@When("I enter the email {string}")
	public void iEnterTheEmail(String email){
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys(email);
	}

	@And("I enter the password {string}")
	public void iEnterThePassword(String password){
		WebElement passwordInput = driver.findElement(By.id("sign-in-password-input")); 
		passwordInput.sendKeys(password);
	}

	@And("I click the login button")
	public void iClickTheLoginButton(){
		WebElement loginButton = driver.findElement(By.id("sign-in-button")); 
		loginButton.click();
	}


	 @Then("I should be logged in successfully")
	    public void iShouldBeLoggedInSuccessfully(){
	        WebElement logo = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/div/a/div/h6"));
	        assertEquals("Square", logo.getText());
	        driver.quit();
	    }
	 
	 @Then("I should be faile to log in")
	    public void I_should_faile_to_log_in() throws InterruptedException {
	        WebElement errorMessage = driver.findElement(By.xpath("//*[@id=\"error-alert\"]/div"));
	        assert errorMessage.isDisplayed();
	        driver.quit();
	        Thread.sleep(2000);
	    }
	 @Then("I can t click the button")
	    public void I_can_t_click_the_button(){
	        WebElement login_button= driver.findElement(By.id("sign-in-button"));
	        assert login_button.isEnabled();
	        driver.quit(); 
	        }
}


