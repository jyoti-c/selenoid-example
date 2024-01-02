package testsWithGroups;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.SessionId;
import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ChromeTestBase;

/**
 * @author jyoti.chabria
 */
public class ChromeTestWithGroup extends ChromeTestBase {

    @Test(groups = {"chrome"})
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

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail();
        }

    }
}
