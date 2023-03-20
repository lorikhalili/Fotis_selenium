package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

public class LoginLogoutTest {
    private final By usernameHolder = By.id("user-name");
    private final By passwordHolder = By.id("password");
    private final By sign_inButton = By.id("login-button");
    private final By sing_outButton = By.id("logout_sidebar_link");
    private final By sandwichButton = By.id("react-burger-menu-btn");
    WebDriver driver;

    @BeforeTest
    public void setup() {
        driver = new ChromeDriver();
    }

    @DataProvider(name = "userData")
    public Object[][] userData() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"locked_out_user", "secret_sauce"}
        };
    }
    @Test(dataProvider = "userData")
    public void testLogin(String username, String password) {
        driver.get("https://www.saucedemo.com/");

        driver.findElement(usernameHolder).sendKeys(username);

        driver.findElement(passwordHolder).sendKeys(password);

        driver.findElement(sign_inButton).click();

        List<WebElement> errorMessage = driver.findElements(By.xpath("//*[@id=\"login_button_container\"]/div/form/div[3]/h3"));

        if (errorMessage.size() != 0) {
            Assert.assertTrue(errorMessage.get(0).isDisplayed());
        } else {

            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"inventory_container\"]/div")).isDisplayed());

            driver.findElement(sandwichButton).click();

            driver.findElement(sing_outButton).click();

            Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"root\"]/div/div[2]")).isDisplayed());
        }
            driver.quit();
    }
}

