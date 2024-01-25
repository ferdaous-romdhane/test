package Test1;

import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import io.cucumber.java.en.*;

public class editEntreprise {
	WebDriver driver;
	@Given("load login page")
	public void load_login_page() {
		 System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
	        this.driver = new ChromeDriver();  // Corrected line
	        driver.get("http://192.168.1.192:3000/");
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	}

	@When("I pass user email")
	public void i_pass_user_email() {
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys("hamza.ramy.ing@gmail.com");
	}

	@And("I pass user password")
	public void i_pass_user_password() {
		WebElement password_input = driver.findElement(By.id("sign-in-password-input"));
		password_input.sendKeys("Aziz@123");
	}

	@And("I click log in")
	public void i_click_log_in() {
		WebElement signin_button = driver.findElement(By.id("sign-in-button"));
		signin_button.click();
	}

	@And("I press the enterprise button")
	public void i_click_the_enterprise_button(){
		FluentWait<WebDriver> fluentWait = new FluentWait<>(driver)
		        .withTimeout(30, TimeUnit.SECONDS)
		        .pollingEvery(2,TimeUnit.SECONDS)
		        .ignoring(NoSuchElementException.class);
		fluentWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//span[text()=' Entreprises']")));
		WebElement entreprise = driver.findElement(By.xpath("//span[text()=' Entreprises']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", entreprise);
	}
	
	@And("I click the edit_enterprise button")
	public void i_click_the_edit_enterprise_button() {
		WebElement editEnterprise_button = driver.findElement(By.id("edit-enterprise-page"));
		editEnterprise_button.click();
	}

	@And("I change the enterprise name")
	public void i_change_the_enterprise_name() throws InterruptedException{
		WebElement enterprise_name = driver.findElement(By.name("companyName"));
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        jsExecutor.executeScript("arguments[0].value=''; ", enterprise_name );
        jsExecutor.executeScript("arguments[0].value='TestEnterprise2';", enterprise_name);
        Thread.sleep(3000);
        //enterprise_name.sendKeys("TestEnterprise2");
	}

	@And("I change the enterprise matricule")
	public void i_change_the_enterprise_matricule() {
		WebElement enterprise_matricule = driver.findElement(By.xpath("//*[@id=\"basic-info\"]/form/div[1]/div[2]/div/div[2]/input"));
		enterprise_matricule.clear();
		enterprise_matricule.sendKeys("12345678hbfviu");
	}

	@And("I change the enterprise email")
	public void i_change_the_enterprise_email() {
		WebElement enterprise_email = driver.findElement(By.xpath("//*[@id=\"basic-info\"]/form/div[2]/div[1]/div/div[2]/input"));
		enterprise_email.clear();
		enterprise_email.sendKeys("Testentreprise222@example.com");
	}

	@And("I change the enterprise phone")
	public void i_change_the_enterprise_phone() {
		WebElement enterprise_phone = driver.findElement(By.xpath("//*[@id=\"basic-info\"]/form/div[3]/div[1]/div[1]/input"));
		enterprise_phone.clear();
		enterprise_phone.sendKeys("54657937");
	}

	@And("I click modify button")
	public void i_click_modify_button() {
		WebElement modify_button = driver.findElement(By.xpath("//*[@id=\"basic-info\"]/div[2]/div/button[2]"));
		modify_button.click();
	}

	@Then("I should edit the entreprise successfully")
	public void i_should_edit_the_entreprise_successfully() {
		WebElement popap= driver.findElement(By.id("swal2-title"));
		popap.isDisplayed();
	}

}
