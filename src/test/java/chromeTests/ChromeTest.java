package chromeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import utils.ChromeTestBase;

public class ChromeTest extends ChromeTestBase {

    @Test(groups = {"chrome"})
    public void testPageTitles() {
        String[] urls = {"https://www.google.com", "https://www.youtube.com",
            "https://www.facebook.com"};
        String[] expectedTitles = {"Google", "YouTube", "Meta"};

        for (int i = 0; i < urls.length; i++) {
            webDriver.navigate().to(urls[i]);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            Assert.assertEquals(webDriver.getTitle(), expectedTitles[i],
                "Title does not match for " + urls[i]);
        }
    }
}
