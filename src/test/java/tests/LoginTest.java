package tests;

import implementation.LoginImpl;
import org.testng.annotations.Test;

    public class LoginTest extends driver.WebDriver {
        @Test
        public void testAdminUser() {
            LoginImpl login = new LoginImpl(driver);
            login.login("rtregcode@beta.test", "Apprise1!");
        }
        @Test
        public void testCfpUser() {
            LoginImpl login = new LoginImpl(driver);
            login.login("cfpadmin", "Apprise1!");
        }
        @Test
        public void testPublisherUser() {
            LoginImpl login = new LoginImpl(driver);
            login.login("publisher", "Apprise1!");
        }
        @Test
        public void testNormalUser() {
            LoginImpl login = new LoginImpl(driver);
            login.login("simple", "Apprise1!");
        }
    }
