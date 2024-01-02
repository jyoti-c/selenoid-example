package utils;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

public class ChromeTestBase {

    protected WebDriver webDriver; // Use protected for access in subclasses

    @BeforeTest(alwaysRun = true)
    public void setUp() throws MalformedURLException {
        Map<String, Object> selenoidOptions = new HashMap<>();
        selenoidOptions.put("enableVideo", true);
        selenoidOptions.put("enableVNC", true);
        // Load Selenoid URL from configuration
        URL seleniumGridURL = new URL(
            "http://localhost:4444/wd/hub"); // Replace with configured URL
        ChromeOptions options = new ChromeOptions();
        options.setCapability("selenoid:options", selenoidOptions);
        webDriver = new RemoteWebDriver(seleniumGridURL, options);
    }

    @AfterTest
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
