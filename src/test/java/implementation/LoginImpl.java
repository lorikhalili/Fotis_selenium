package implementation;

import log.Logs;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;


public class LoginImpl {
    private final By usernameHolder = By.xpath("//input[@type='text']");
    private final By passwordHolder = By.xpath("//input[@type='password']");
    private final By loginButton = By.xpath("//button[@class='sc-gYbzsP iYFfWH']");
    private final By idHolder = By.xpath("//div[@class='sc-hbqYmb hfDZim']");

    public final WebDriver driver;

    public LoginImpl(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getTitleElement() {
        return driver.findElement(idHolder);
    }

    public void login(String username, String password) {
        driver.findElement(passwordHolder).sendKeys(password);
        driver.findElement(usernameHolder).sendKeys(username);
        driver.findElement(loginButton).click();
        Logs.info("User has successfully clicked login button!");

            if (username.contains("rtregcode@beta.test")) {

                Assert.assertTrue(getTitleElement().isDisplayed(), "Newsfeed is displayed");
                Logs.info("Master Admin can login");

            } else if (username.contains("cfpadmin")) {

                Assert.assertTrue(getTitleElement().isDisplayed(), "Newsfeed is displayed");
                Logs.info("CFP can login");

            } else if (username.contains("publisher")) {

                Assert.assertTrue(getTitleElement().isDisplayed(), "Newsfeed is displayed");
                Logs.info("Content Publisher can login");

            } else if (username.contains("simple")) {

                Assert.assertTrue(getTitleElement().isDisplayed(), "Newsfeed is displayed");
                Logs.info("Simple User can login");

            }
            System.out.println("login test has been completed");
    }

}

