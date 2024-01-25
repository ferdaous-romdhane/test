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

public class editCollaborator {
	WebDriver driver;
	@Given("login_page")
	public void login_page() {
		System.setProperty("webdriver.chrome.driver","c:/chromedriver.exe");
		this.driver = new ChromeDriver(); // Corrected line
		driver.get("http://192.168.1.192:3000/");
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	@When("I enter informations and log in")
	public void i_enter_informations_and_log_in() {
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys("test3@gmail.com");
		WebElement password_input = driver.findElement(By.id("sign-in-password-input"));
		password_input.sendKeys("Aziz@123");
		WebElement signin_button = driver.findElement(By.id("sign-in-button"));
		signin_button.click();
	}

	@When("I click the users_button")
	public void i_click_the_users_button() throws InterruptedException {
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("(//div)[30]")));
		WebElement users_button = driver.findElement(By.xpath("(//div)[30]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", users_button);
		Thread.sleep(6);
	}

	@When("I click the collaborator_button")
	public void i_click_the_collaborator_button() throws InterruptedException {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		WebElement collaborator_button = driver
				.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul/a[7]/div/div/div/ul[1]/a/li/div/div/span"));
		collaborator_button.click();
		Thread.sleep(6);
	}

	@When("I click menu button")
	public void i_click_menu_button() {
		driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
				.pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("/html/body//li[2]")));
		WebElement menu_button = driver.findElement(By.xpath("/html/body//li[2]"));	
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", menu_button);
		WebElement edit_button = driver.findElement(By.xpath("//span[text()='more_vert']"));	
		edit_button.click();
}

/*
 * @When("I click edit") public void i_click_edit() {
 * driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
 * driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
 * FluentWait<WebDriver> fluentWait = new FluentWait<>(driver).withTimeout(30,
 * TimeUnit.SECONDS) .pollingEvery(2,
 * TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
 * fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
 * "//span[text()='more_vert']"))); WebElement edit_button =
 * driver.findElement(By.xpath("//span[text()='more_vert']"));
 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
 * edit_button); }
 * 
 * @When("I change admin informations") public void
 * i_change_admin_informations() { driver.manage().timeouts().implicitlyWait(40,
 * TimeUnit.SECONDS); driver.manage().timeouts().pageLoadTimeout(40,
 * TimeUnit.SECONDS); WebElement first_name =
 * driver.findElement(By.id("firstname")); first_name.sendKeys(Keys.CONTROL +
 * "a"); first_name.sendKeys(Keys.DELETE);
 * 
 * first_name.sendKeys("asma"); WebElement last_name =
 * driver.findElement(By.id("lastname")); last_name.clear();
 * last_name.sendKeys("slim"); WebElement emailInput =
 * driver.findElement(By.id("email")); emailInput.clear();
 * emailInput.sendKeys("asma-slim@gmail.com"); }
 * 
 * @When("I click modify") public void i_click_modify() { FluentWait<WebDriver>
 * fluentWait = new FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS)
 * .pollingEvery(2, TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
 * fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(
 * "//*[@id=\"basic-info\"]/div[2]/button[2]"))); WebElement modif_button =
 * driver.findElement(By.xpath("//*[@id=\"basic-info\"]/div[2]/button[2]"));
 * ((JavascriptExecutor) driver).executeScript("arguments[0].click();",
 * modif_button); }
 * 
 * @Then("I should edit admin successfully") public void
 * i_should_edit_admin_successfully() { FluentWait<WebDriver> fluentWait = new
 * FluentWait<>(driver).withTimeout(30, TimeUnit.SECONDS) .pollingEvery(2,
 * TimeUnit.SECONDS).ignoring(NoSuchElementException.class);
 * fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.id(
 * "swal2-title"))); WebElement popap= driver.findElement(By.id("swal2-title"));
 * popap.isDisplayed(); }
 */
}
