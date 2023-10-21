package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Login page saucedemo")
    public void loginPageSaucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");
    }

    @When("User input registered username")
    public void userInputRegisteredUsername() {
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input registered password")
    public void inputRegisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @And("Click login button")
    public void clickLoginButton() {
        driver.findElement(By.xpath("//input[@type='submit']")).click();
    }

    @Then("User direct to dashboard")
    public void userDirectToDashboard() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
    }

    @And("Input unregistered password")
    public void inputUnregisteredPassword() {
        driver.findElement(By.id("password")).sendKeys("secret-sauce");
    }

    @Then("Error message displayed")
    public void errorMessageDisplayed() {
        String errorLogin = driver.findElement(By.xpath("//h3[@data-test='error']")).getText();
        Assert.assertEquals(errorLogin,"Epic sadface: Username and password do not match any user in this service");
    }
}
