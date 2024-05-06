package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.time.Duration;

public class DashboardTests {
    WebDriver driver;

    @Before
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("the user is on Dashboard page")
    public void theUserIsOnDashboardPage() {
        driver.get("https://shop.pragmatic.bg/admin");
    }

    @When("he enters {string} as username")
    public void heEntersHisUsername(String username) {
        driver.findElement(By.id("input-username")).sendKeys(username);}


    @And("he enters {string} as admin's password")
    public void heEntersPasswordAsAdminsPassword(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @And("he clicks login button")
    public void heClicksLoginButton() {
    driver.findElement(By.cssSelector(".btn-primary")).click();

    }


    @Then("ensure the login is successful by username {string}")
    public void ensureTheLoginIsSuccessfulByUsername(String expectedUsername) {
        String actualUsername = driver.findElement(By.xpath("//*[@id='user-profile']/ ..")).getText();
        Assert.assertEquals(actualUsername, expectedUsername);
    }
    @Then("click on logout button")
    public void clickOnLogoutButton() {
    driver.findElement(By.cssSelector(".fa.fa-sign-out")).click();
    }

    @Then("ensure the logout is successful by text {string}")
    public void ensure_the_logout_is_successful_by_text(String expectedTitle) {
        String actualTitle = driver.findElement(By.cssSelector(".panel-title")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }
    }

