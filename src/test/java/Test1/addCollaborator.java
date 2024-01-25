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

public class addCollaborator {

	WebDriver driver;

	@Given("login page")
	public void login_page() {
		System.setProperty("webdriver.chrome.driver",
				"c:/chromedriver.exe");
		this.driver = new ChromeDriver(); // Corrected line
		driver.get("http://192.168.1.192:3000/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("I pass user informations and log in")
	public void i_pass_user_informations_and_log_in() {
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys("test3@gmail.com");
		WebElement password_input = driver.findElement(By.id("sign-in-password-input"));
		password_input.sendKeys("Aziz@123");
		WebElement signin_button = driver.findElement(By.id("sign-in-button"));
		signin_button.click();
	}

	@And("I press the users button")
	public void i_press_the_users_button() {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div)[30]")));
		WebElement users_button = driver.findElement(By.xpath("(//div)[30]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", users_button);
	}

	@And("I press the collaborator button")
	public void i_press_the_collaborator_button() {
		WebElement collaborator_button = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul/a[7]/div/div/div/ul[1]/a/li/div/div/span"));
		collaborator_button.click();
	}

	@And("I press add admin button")
	public void i_press_add_admin_button() {
		WebElement add_admin = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[3]/div/div/div[1]/div/div/div/span"));
		add_admin.click();
	}

	@And("I enter admin first name")
	public void i_enter_admin_first_name() {
		WebElement first_name = driver.findElement(By.id("firstname"));
		first_name.sendKeys("ahmed");
	}

	@And("I enter admin last name")
	public void i_enter_admin_last_name() {
		WebElement last_name = driver.findElement(By.id("lastname"));
		last_name.sendKeys("ali");
	}

	@And("I enter admin email")
	public void i_enter_admin_email() {
		WebElement emailInput = driver.findElement(By.id("email"));
		emailInput.sendKeys("ahmed_ali@gmail.com");
	}

	@And("I enter admin gender")
	public void i_enter_admin_gender() {
		WebElement admin_gender = driver.findElement(By.xpath("//*[@id=\"gender\"]/label[1]/span[1]/input"));
		admin_gender.click();
	}

	@And("I enter admin phone")
	public void i_enter_admin_phone() {
		WebElement admin_phone = driver
				.findElement(By.xpath("//*[@id=\"user\"]/div/div/div/div[1]/div/div[3]/div[4]/div[1]/div[1]/input"));
		admin_phone.sendKeys("95468123");
	}

	@And("I press add button")
	public void i_press_add_button() {
		WebElement add_button = driver.findElement(By.id("btn-add"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add_button);
	}

	@Then("I should add admin successfully")
	public void i_should_add_admin_successfully() {
		WebElement popup = driver.findElement(By.id("swal2-title"));
		popup.getText().equals("succès !");
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait
				.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//button[normalize-space()='OK']")));
		WebElement confirm_button = driver.findElement(By.xpath("//button[normalize-space()='OK']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", confirm_button);
	}

}
