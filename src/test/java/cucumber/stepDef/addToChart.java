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

public class addToChart {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User already login")
    public void userAlreadyLogin() {
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

    @And("Dashboard displays several products")
    public void dashboardDisplaysSeveralProducts() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
    }

    @When("Click add to chart button on the desired product")
    public void clickAddToChartButtonOnTheDesiredProduct() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
    }

    @And("Click chart")
    public void clickChart() {
        driver.findElement(By.id("shopping_cart_container")).click();
    }

    @And("Click button checkout")
    public void clickButtonCheckout() {
        driver.findElement(By.id("checkout")).click();
    }

    @Then("User directed to checkout information")
    public void userDirectedToCheckoutInformation() {
        driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Your Information')]"));
    }
//hana
}
