package uiTests;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author jyoti.chabria
 */
public class SampleTest_Chrome {
    WebDriver webDriver;

    @BeforeTest
    public void setUp() throws MalformedURLException {
        ChromeOptions options = new ChromeOptions();
        options.setCapability("enableVNC",true);
        options.setCapability("enableVideo",true);
        webDriver=new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), options);


    }

    @Test
    public void testUIChrome() {
        try {
            SessionId s = ((RemoteWebDriver) webDriver).getSessionId();
            System.out.println("Session Id is: " + s);
            webDriver.navigate().to("https://www.google.com");
            Assert.assertEquals(webDriver.getTitle(), "Google", "Title does not match");
            Thread.sleep(1000);
            webDriver.navigate().to("https://www.youtube.com");
            Assert.assertEquals(webDriver.getTitle(), "YouTube", "Title does not match");
            Thread.sleep(1000);
            webDriver.navigate().to("https://www.facebook.com");
            Assert.assertNotEquals(webDriver.getTitle(), "Meta", "Title does not match");

        }
        catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
    @AfterTest
    public void tearDown() {
        webDriver.quit();
    }
}
