package driver;

import log.Logs;
import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class WebDriver {

    public org.openqa.selenium.WebDriver driver;
    DriverProperties driverProperties = new DriverProperties();
    @BeforeMethod
    public void openChrome (){
        driver = driverProperties.initializeDriver();
        driver.get("https://login.beta.theemployeeapp.com");
        orgId();
    }
    public void orgId () {
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("rtregcode.beta");
        driver.findElement(By.xpath("//div[@class='sc-jIILKH cbXiav']")).click();
    }

    @AfterMethod
    public void cleanup (){
        driver.quit();
    }
}
