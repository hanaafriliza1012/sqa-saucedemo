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

public class detail {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("User success login")
    public void userSuccessLogin() {
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

    @And("Directed to several products")
    public void directedToSeveralProducts() {
        driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
    }

    @When("Select a product")
    public void selectAProduct() {
        driver.findElement(By.id("item_4_title_link")).click();
    }

    @Then("See the product details")
    public void seeTheProductDetails() {
        driver.findElement(By.xpath("//button[contains(text(), 'Back to products')]")).getText();
    }
}
