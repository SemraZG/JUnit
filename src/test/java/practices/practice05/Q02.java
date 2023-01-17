package practices.practice05;

import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

import java.io.IOException;

import static org.junit.Assert.assertTrue;

public class Q02 extends TestBase {
    @Test
    public void test() throws IOException {
        /*
    Given
        Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
    When
        Click on Ajax Loader
    And
        Click on "Click Me!" button
    Then
        Assert that button is clicked
    And
        Take screenshot after each step
     */

        //Go to "http://webdriveruniversity.com/Popup-Alerts/index.html"
        driver.get("http://webdriveruniversity.com/Popup-Alerts/index.html");

//        Click on Ajax Loader
        driver.findElement(By.linkText("CLICK ME!")).click();

//        Click on "Click Me!" button

        //driver.findElement(By.xpath("//p[.='CLICK ME!']")).click(); // it worked with implicitly wait.
        //or
        waitForClickablility(By.xpath("//p[.='CLICK ME!']"), 12).click();//it worked with explicit wait
        takeScreenshotOfPage();

//        Assert that button is clicked
        String text= waitForClickablility(By.xpath("//h4[.='Well Done For Waiting....!!!']"), 3).getText();

       assertTrue(text.contains("Well Done"));

//        Take screenshot after each step
        takeScreenshotOfPage();
    }
}
