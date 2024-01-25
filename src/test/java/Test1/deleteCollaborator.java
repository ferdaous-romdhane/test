package Test1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.*;

public class deleteCollaborator {
	WebDriver driver;
	
	@Given("loginPpage")
	public void login_ppage() {
		System.setProperty("webdriver.chrome.driver","c:/chromedriver.exe");
		this.driver = new ChromeDriver(); // Corrected line
		driver.get("http://192.168.1.192:3000/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("I pass informations and log in")
	public void i_pass_informations_and_log_in() {
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys("test3@gmail.com");
		WebElement password_input = driver.findElement(By.id("sign-in-password-input"));
		password_input.sendKeys("Aziz@123");
		WebElement signin_button = driver.findElement(By.id("sign-in-button"));
		signin_button.click();
	}

	@And("I press the users_button")
	public void i_press_the_users_button() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div)[30]")));
		WebElement users_button = driver.findElement(By.xpath("(//div)[30]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", users_button);
	}

	@And("I press the collaborator_button")
	public void i_press_the_collaborator_button() {
		WebElement collaborator_button = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul/a[7]/div/div/div/ul[1]/a/li/div/div/span"));
		collaborator_button.click();
	}

	@And("I press menu button")
	public void i_press_menu_button() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()='more_vert']")));
		WebElement menu_button = driver.findElement(By.xpath("//span[text()='more_vert']"));	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu_button);
	}

	@And("I press delete")
	public void i_press_delete() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body/div[5]/div[3]/ul/li[3]")));
		WebElement delete_button = driver.findElement(By.xpath("/html/body/div[5]/div[3]/ul/li[3]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", delete_button);
	}

	@And("I confirm the action")
	public void i_confirm_the_action() {
		WebElement confirm_button = driver.findElement(By.xpath("//button[normalize-space()='Oui, supprimer !']"));
		confirm_button.click();
	}

	@Then("I should delete admin successfully")
	public void i_should_delete_admin_successfully() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id("swal2-title")));
		WebElement popap= driver.findElement(By.id("swal2-title"));
		popap.isDisplayed();
	}

}
