package stepdefs;

import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {
    public WebDriver webDriver;

    @Before
    public void init() {
        webDriver = new ChromeDriver();
        webDriver.get("http://bhdtest.endava.com/petclinic/");
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void teardown() {
        webDriver.quit();
    }
}
