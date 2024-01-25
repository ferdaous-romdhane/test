package Test1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.*;

public class deleteEntreprise {
	WebDriver driver;
	
	@Given("open login page")
	public void open_login_page() {
		 System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
	        this.driver = new ChromeDriver();  // Corrected line
	        driver.get("http://192.168.1.192:3000/");
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	}

	@When("I enter email")
	public void i_enter_email(){
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys("hamza.ramy.ing@gmail.com");
	}

	@And("I enter password")
	public void i_enter_password(){
		WebElement emailInput = driver.findElement(By.id("sign-in-password-input"));
		emailInput.sendKeys("Aziz@123");
	}

	@And("I logged")
	public void i_logged(){
		WebElement signin_button = driver.findElement(By.id("sign-in-button"));
		signin_button.click();
	}
	
	@And("I click enterprise")
	public void i_click_enterprise(){
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(30, TimeUnit.SECONDS)
		        .pollingEvery(2,TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()=' Entreprises']")));
		WebElement entreprise = driver.findElement(By.xpath("//span[text()=' Entreprises']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", entreprise);
		
	}

	@And("I click delete button")
	public void i_click_delete_button(){
		WebElement dropdown_input = driver.findElement(By.xpath("//*[@id=\"root\"]//div[1]//div[2]/input"));
		dropdown_input.sendKeys("25");
		dropdown_input.sendKeys(Keys.ENTER);
		WebElement delete_button_id = driver.findElement(By.id("delete-enterprise-659bf636968d6614c4ec2509"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete_button_id);
		WebElement confirm_button = driver.findElement(By.xpath("/html/body/div[5]/div/div[6]/button[1]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirm_button);
	}

	@Then("the enterprise deleted successfully")
	public void the_enterprise_deleted_successfully(){
		WebElement popup_text = driver.findElement(By.xpath("//*[@id=\"root\"]//div[1]//div[2]/input"));
		popup_text.getText().equals("Supprimé !");
	}

}
