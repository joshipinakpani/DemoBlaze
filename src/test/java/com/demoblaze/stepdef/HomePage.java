package com.demoblaze.stepdef;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

//import static org.junit.Assert.assertTrue;
//import static org.junit.Assert.assertNotNull;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomePage {
	WebDriver driver;
	@Given("The user is on a web browser")
	public void the_user_is_on_a_web_browser() {
		System.out.println("I am launching application");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@When("The user navigates to {string}")
	public void the_user_navigates_to(String url) {
		driver.get(url);
	}

	@Then("The homepage is displayed")
	public void the_homepage_is_displayed() {
	    String title = driver.getTitle();
	    assertTrue("Homepage is not displayed", title.contains("STORE"));
	}

	@When("The user clicks on the sign-up link")
	public void the_user_clicks_on_the_sign_up_link() {
		WebElement signUpLink = driver.findElement(By.id("signin2"));
        signUpLink.click();
	}

	@Then("Signup window contains all the fields")
	public void signup_window_contains_all_the_fields() {
		WebElement usernameField = driver.findElement(By.id("sign-username"));
        WebElement passwordField = driver.findElement(By.id("sign-password"));
        assertNotNull("Username field is not displayed", usernameField);
        assertNotNull("Password field is not displayed", passwordField);
	}

	@When("user enters username as {string}")
	public void user_enters_username_as(String username) {
		WebElement usernameField = driver.findElement(By.id("sign-username"));
        usernameField.sendKeys(username);
	}

	@When("user enters password as {string}")
	public void user_enters_password_as(String password) {
		WebElement passwordField = driver.findElement(By.id("sign-password"));
        passwordField.sendKeys(password);
	}

	@When("click on signup button")
	public void click_on_signup_button() {
		WebElement signUpButton = driver.findElement(By.xpath("//button[contains(text(),'Sign up')]"));
        signUpButton.click();
	}

	@Then("Sign up successful. message confirmation")
	public void sign_up_successful_message_confirmation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertTrue("Sign-up was not successful", alertText.contains("Sign up successful"));
        alert.accept(); // Close the alert box
	}

	@Then("This user already exist. message confirmation")
	public void this_user_already_exist_message_confirmation() {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        Alert alert = wait.until(ExpectedConditions.alertIsPresent());
//		Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        assertTrue("User already exists message not displayed", alertText.contains("This user already exist"));
        alert.accept();
	}
	@After
    public void tearDown() {
        driver.quit();
    }
}
