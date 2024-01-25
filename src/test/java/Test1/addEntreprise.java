package Test1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.*;

public class addEntreprise {
	WebDriver driver;
	
	 @Given("load the login page")
	    public void load_the_login_page() {
	        System.setProperty("webdriver.chrome.driver", "c:/chromedriver.exe");
	        this.driver = new ChromeDriver();  // Corrected line
	        driver.get("http://192.168.1.192:3000/");
	        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
	        driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
	        driver.manage().window().maximize();
	    }

	@When("I enter user email")
	public void i_enter_user_email(){
		WebElement emailInput = driver.findElement(By.id("sign-in-email-input"));
		emailInput.sendKeys("hamza.ramy.ing@gmail.com");
	}

	@And("I enter user password")
	public void i_enter_user_password(){
		WebElement password_input = driver.findElement(By.id("sign-in-password-input"));
		password_input.sendKeys("Aziz@123");
	}

	@And("I logged in")
	public void i_logged_in(){
		WebElement signin_button = driver.findElement(By.id("sign-in-button"));
		signin_button.click();
	}

	@And("I click the enterprise button")
	public void i_click_the_enterprise_button(){
		WebElement enterprise_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div[1]/div/ul/a[2]/li/div"));
		enterprise_button.click();
	}

	@And("I click the add_enterprise button")
	public void i_click_the_add_enterprise_button(){
		WebElement add_enterprise_button = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div/div[1]/div[2]/button[2]"));
		add_enterprise_button.click();
	}

	@And("I enter the enterprise name")
	public void i_enter_the_enterprise_name(){
		WebElement enterprise_name = driver.findElement(By.id("name-enterprise"));
		enterprise_name.sendKeys("TestEnterprise1");
	}

	@And("I enter the enterprise matricule")
	public void i_enter_the_enterprise_matricule(){
		WebElement enterprise_matricule = driver.findElement(By.id("serial-number-enterprise"));
		enterprise_matricule.sendKeys("12345678947");
	}

	@And("I enter the enterprise email")
	public void i_enter_the_enterprise_email(){
		WebElement enterprise_email = driver.findElement(By.id("email-enterprise"));
		enterprise_email.sendKeys("Testentreprise1@example.com");
	}

	@And("I enter the enterprise phone")
	public void i_enter_the_enterprise_phone(){
		WebElement enterprise_phone = driver.findElement(By.xpath("//*[@id=\"enterprise\"]/div/div/div/div[1]/div[3]/div[3]/div[1]/div[1]/input"));
		enterprise_phone.sendKeys("97456324");
	}

	@And("I select from the country dropdown")
	public void i_select_from_the_country_dropdown(){
		WebElement country_dropdown = driver.findElement(By.id("enterprise-country"));
		country_dropdown.sendKeys("Tunisia");
		country_dropdown.sendKeys(Keys.ENTER);
	}

	@And("I select from the city dropdown")
	public void i_select_from_the_city_dropdown(){
		WebElement city_dropdown = driver.findElement(By.id("enterprise-city"));
		city_dropdown.sendKeys("Ariana");
		city_dropdown.sendKeys(Keys.ENTER);
	}

	@And("I enter the enterprise address")
	public void i_enter_the_enterprise_address(){
		WebElement enterprise_address = driver.findElement(By.id("physiqual-address-enterprise"));
		enterprise_address.sendKeys("Ariana-tunis");
	}

	@And("I enter the enterprise postal code")
	public void i_enter_the_enterprise_postal_code() {
		WebElement enterprise_postalCode = driver.findElement(By.id("post-code-enterprise"));
		enterprise_postalCode.sendKeys("6548948");
	}

	@And("I click the next button")
	public void i_click_the_next_button() {
		WebElement next_button= driver.findElement(By.xpath("//*[@id=\"send\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", next_button);
		 
		
	}

	@And("I enter the department name")
	public void i_enter_the_department_name() {
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		WebElement department_name = driver.findElement(By.id("facility-name"));
		department_name.sendKeys("firsttest");
  	}

	@And("I enter the department matricule")
	public void i_enter_the_department_matricule() {
		WebElement department_matricule = driver.findElement(By.id("facility-serial-number"));
		department_matricule.sendKeys("1234594578915");
	}

	@And("I select from the department type dropdown")
	public void i_select_from_the_department_type_dropdown(){
		WebElement department_dropdown = driver.findElement(By.id("size-small-standard-0"));
		department_dropdown.click();
		department_dropdown.sendKeys("Crèche");
		department_dropdown.sendKeys(Keys.ARROW_DOWN);
		department_dropdown.sendKeys(Keys.ENTER);
	}
	
	@And("I click next")
	public void i_click_next(){
		WebElement next_button_2= driver.findElement(By.xpath("//*[@id=\"send\"]"));
		next_button_2.click();
	}

	@And("I enter the manager first name")
	public void i_enter_the_manager_first_name(){
		driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
		WebElement manager_firstName = driver.findElement(By.id("company-admin-first-name"));
		manager_firstName.sendKeys("Testtt");
	}

	@And("I enter the manager last name")
	public void i_enter_the_manager_last_name(){
		WebElement manager_lastName = driver.findElement(By.id("company-admin-last-name"));
		manager_lastName.sendKeys("TestManager");
	}

	@And("I enter the manager email")
	public void i_enter_the_manager_email(){
		WebElement manager_email = driver.findElement(By.id("company-admin-email"));
		manager_email.sendKeys("Testttttttt1@example.com");
	}

	@And("I enter the manager phone")
	public void i_enter_the_manager_phone(){
		WebElement manager_phone = driver.findElement(By.xpath("//*[@id=\"enterprise\"]/div/div/div/div[1]/div[3]/div[4]/div[1]/div[1]/input"));
		manager_phone.sendKeys("99456321");
	}

	@And("I choose the manager gender")
	public void i_choose_the_manager_gender(){
		WebElement manager_gender = driver.findElement(By.xpath("//*[@id=\"company-admin-female\"]/span[1]/input"));
		manager_gender.click();
	}

	@And("I click add button")
	public void i_click_add_button(){
		WebElement add_button= driver.findElement(By.xpath("//*[@id=\"send\"]"));
		((JavascriptExecutor) driver).executeScript("arguments[0].click();", add_button);
	}

	@Then("I should add the enterprise successfully")
	public void i_should_add_the_enterprise_successfully() {
		WebElement popap_text= driver.findElement(By.id("swal2-title"));
		popap_text.isDisplayed();
	}
	
}
