import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class positionsTest {
    public static final String KEY = "bde36d93afb31f7e648e465c2e84064e";
    public static final String SECRET = "dd82e31b11fefcd3f32201fdb0ebe8af";
    public static final String HUB_URL = "http://" + KEY + ":" + SECRET + "@hub.testingbot.com/wd/hub";
    private WebDriver driver;
    private URL url;
    private DesiredCapabilities caps;
    private Wait wait;

    @BeforeClass
    public void setup() throws MalformedURLException {
        caps = new DesiredCapabilities();
        caps.setCapability("name", "Project14position");
        url = new URL(HUB_URL);
    }

    @Test
    public void testFirefox() throws InterruptedException {
        caps.setCapability("platform", "WIN8");
        caps.setCapability("version", "60");
        caps.setCapability("browserName", "firefox");
        driver = new RemoteWebDriver(url, caps);

       setUp();
    }

    @Test
    public void testChrome() throws InterruptedException {
        caps.setCapability("platform", "WIN8");
        caps.setCapability("version", "79");
        caps.setCapability("browserName", "chrome");
        driver = new RemoteWebDriver(url, caps);

      setUp();
    }




    public void setUp() throws InterruptedException {
//        System.setProperty( "webdriver.chrome.driver", "/Users/haceryapici/Desktop/Selenyum/chromedriver" );
//        driver = new ChromeDriver();
        driver.get("https://test-basqar.mersys.io");
        driver.manage().window().maximize();
        // login info
        driver.findElement(By.cssSelector("[formcontrolname=\"username\"]")).sendKeys("nigeria_tenant_admin");
        driver.findElement(By.cssSelector("[formcontrolname=\"password\"]")).sendKeys("TnvLOl54WxR75vylop2A");
        driver.findElement(By.cssSelector("button[aria-label=\"LOGIN\"]")).click();
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.findElement(By.cssSelector("a[class='cc-btn cc-dismiss']")).click();
        //Click on Human Resources
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(4)")).click();
        //Click on Setup
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(4) > .children > .nav-item:nth-child(1)")).click();
        //Click the position
        driver.findElement(By.cssSelector("fuse-navigation .group-items > .nav-item:nth-child(4) >" +
                " .children > .nav-item:nth-child(1) > .children > .nav-item:nth-child(2)")).click();
        //Click on plus icon
        driver.findElement(By.cssSelector("svg[data-icon='plus']")).click();
        //send name
        driver.findElement(By.cssSelector("ms-text-field>input[aria-required='true']")).sendKeys("Hacer");
        //short name
        driver.findElement(By.cssSelector("ms-text-field[formcontrolname=\"shortName\"] input")).sendKeys("Yapici");
        // click on Save button
        driver.findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        //delete
        driver.findElement(By.xpath("//td[contains(text(), 'Hacer')]/..//ms-delete-button")).click();
        //yes button
        driver.findElement(By.xpath(" //span[contains(text(),'Yes')]")).click();

    }



    @AfterClass
    public void quit() {
        driver.close();
        driver.quit();
    }


}