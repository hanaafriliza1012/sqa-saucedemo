package cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class checkoutOverview {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User login")
    public void userLogin() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @And("Go to chart")
    public void goToChart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("Go to button checkout")
    public void goToButtonCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @And("User on the checkout information page")
    public void userOnTheCheckoutInformationPage() {
        driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Your Information')]")).getText();
    }

    @When("User input firstname field")
    public void userInputFirstnameField() {
        driver.findElement(By.id("first-name")).sendKeys("Hana");
    }

    @And("Input lastname field")
    public void inputLastnameField() {
        driver.findElement(By.id("last-name")).sendKeys("Afriliza");
    }

    @And("Input postal code field")
    public void inputPostalCodeField() {
        driver.findElement(By.id("postal-code")).sendKeys("35376");
    }

    @And("Click continue button")
    public void clickContinueButton() {
        driver.findElement(By.id("continue")).click();
    }

    @Then("Checkout overview displayed")
    public void checkoutOverviewDisplayed() {
        driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Overview')]")).getText();
    }

}
