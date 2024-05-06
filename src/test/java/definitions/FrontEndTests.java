package definitions;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class FrontEndTests {
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

    @Given("the user is on OpenCart page")
    public void theUserIsOnOpenCartPage() {
        driver.get("https://shop.pragmatic.bg");
    }

    @When("he clicks my account button")
    public void heClicksMyAccountButton() {
        driver.findElement(By.xpath("(//div[@id='top-links'])//li[2]")).click();
    }

    @And("he clicks login")
    public void heClicksLogin() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='top-links']//li[2]//li[2]//a")));
        driver.findElement(By.xpath("//div[@id='top-links']//li[2]//li[2]//a")).click();
    }

    @And("he enters {string} as email address")
    public void heEntersAsEmailAddress(String emailAddress) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-email")));
        driver.findElement(By.id("input-email")).sendKeys(emailAddress);
    }

    @And("he enters {string} as password")
    public void heEntersAsPassword(String password) {
        driver.findElement(By.id("input-password")).sendKeys(password);
    }

    @And("he clicks login button in order to login")
    public void heClicksLoginButtonInOrderToLogin() {
        driver.findElement(By.xpath("(//*[@class='btn btn-primary'])[2]")).click();
    }

    @Then("ensure the login is successful by text {string}")
    public void ensureTheLoginIsSuccessfulByText(String expectedSuccessText) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='list-group-item'][1]")));
        String actualSuccessText = driver.findElement(By.xpath("//*[@class='list-group-item'][1]")).getText();
        Assert.assertEquals(actualSuccessText, expectedSuccessText);
    }



    @When("he clicks add to wish list button")
    public void heClicksAddToWishListButton() {
        driver.findElement(By.xpath("(//div[@class='button-group'])[2]//button[2]")).click();
    }

    @And("he clicks on wish list button")
    public void heClicksOnWishListButton() {
        driver.findElement(By.id("wishlist-total")).click();
    }

    @Then("ensure he added iPhone to wish list by title {string}")
    public void ensureHeAddedIPhoneToWishList(String expectedTitle) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id='content']//h2")));
        String actualTitle = driver.findElement(By.xpath("//*[@id='content']//h2")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("he clicks camera button")
    public void heClicksCameraButton() {
        driver.findElement(By.xpath("(//*[@class='nav navbar-nav'])//li[7]")).click();
    }

    @And("he clicks Nikon camera button")
    public void heClicksNikonCameraButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@class='caption'])[2]//h4//a")));
        driver.findElement(By.xpath("(//*[@class='caption'])[2]//h4//a")).click();
    }

    @And("he clicks add to cart button")
    public void heClicksAddToCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//*[@id='button-cart'])[1]")));
        driver.findElement(By.xpath("(//*[@id='button-cart'])[1]")).click();
    }



    @And("he clicks cart button")
    public void heClicksCartButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".alert.alert-success.alert-dismissible")));
        driver.findElement(By.id("cart-total")).click();
    }

    @And("he clicks checkout button")
    public void heClicksCheckoutButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#cart .fa.fa-share")));
        driver.findElement(By.cssSelector("#cart .fa.fa-share")).click();

    }

    @Then("ensure he added to cart camera Nikon by message {string}")
    public void ensureHeAddedToCartCameraNikonByMessage(String expectedTitle) {
        String actualTitle = driver.findElement(By.xpath("//*[@id='content']//h1")).getText();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @When("he clicks my account button in order to register")
    public void heClicksMyAccountButtonInOrderToRegister() {
        driver.findElement(By.xpath("(//div[@id='top-links'])//li[2]")).click();
    }

    @And("he clicks register button")
    public void heClicksRegisterButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//*[@id=\"top-links\"])//li//li[1]")));
        driver.findElement(By.xpath("(//*[@id=\"top-links\"])//li//li[1]")).click();

    }

    @And("he enters {string} as first name")
    public void heEntersAsFirstName(String firstName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("input-firstname")));
        driver.findElement(By.id("input-firstname")).sendKeys(firstName);
    }

    @And("he enters {string} as last name")
    public void heEntersAsLastName(String lastName) {
        driver.findElement(By.id("input-lastname")).sendKeys(lastName);
    }

    @And("he enters email address")
    public void heEntersEmailAddressForRegister() {
        String emailPrefix = RandomStringUtils.randomAlphabetic(7);
        String emailSuffix = RandomStringUtils.randomAlphabetic(5);
        String email = emailPrefix + "@" + emailSuffix + ".com";
        driver.findElement(By.id("input-email")).sendKeys(email);
    }

    @And("he enters {string} as telephone")
    public void heEntersAsTelephone(String telephone) {
        driver.findElement(By.id("input-telephone")).sendKeys(telephone);
    }



    @And("he enters {string} as confirmation password")
    public void heEntersAsConfirmationPassword(String confirmationPassword) {
        driver.findElement(By.id("input-confirm")).sendKeys(confirmationPassword);
    }

    @And("he clicks agree button")
    public void heClicksAgreeButton() {
        driver.findElement(By.name("agree")).click();
    }

    @And("he clicks continue button")
    public void heClicksContinueButton() {
        driver.findElement(By.cssSelector(".btn.btn-primary")).click();
    }

    @Then("ensure he registered successfully by message")
    public void ensureHeRegisteredSuccessfullyByMessage(String expectedMessage) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        String actualMessage = driver.findElement(By.id("content")).getText();
        Assert.assertEquals(actualMessage, expectedMessage);
    }


    @And("he enters {string} as email address in order to register")
    public void heEntersAsEmailAddressInOrderToRegister(String email) {
        driver.findElement(By.id("input-email")).sendKeys(email);
    }


    @Then("ensure he didn't register successfully by message {string}")
    public void ensureHeDidntRegisterSuccessfullyByMessage(String message){

    }
}
