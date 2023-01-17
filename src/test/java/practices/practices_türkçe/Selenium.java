package practices.practices_türkçe;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Selenium extends TestBase {


    //HARD WAIT:---->Thread.sleep---->waitFor
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

//    DYNAMIC SELENIUM WAITS:

//===============Implicitly Wait==============
 //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));--->in testBase class
 //NoSuchElementExeption



//===============Explicit Wait==============

    public static WebElement waitForVisibility(WebElement element, int timeout) {
    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
    return wait.until(ExpectedConditions.visibilityOf(element));
    }

        public static WebElement waitForVisibility(By locator, int timeout) {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
            return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        }

    public static WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static WebElement waitForClickablility(By locator, int timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }


//======Fluent Wait====

    // params : xpath of the element , max timeout in seconds, polling in second
    public static WebElement fluentWait(String xpath, int withTimeout, int pollingEvery) {
        FluentWait<WebDriver> wait = new FluentWait<WebDriver>(driver)
                .withTimeout(Duration.ofSeconds(withTimeout))//Wait 3 second each time
                .pollingEvery(Duration.ofSeconds(pollingEvery))//Check for the element every 1 second
                .withMessage("Ignoring No Such Element Exception")
                .ignoring(NoSuchElementException.class);


        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xpath)));
        return element;
    }



    /*
     What type of waits do you use?
            I use implicit or explicit wait

        Which wait do you prefer?
            Explicit wait works better in some cases. When I use explicit wait,
            and still see timeout exception, then there can be other issues such as incorrect locators.

        Why do you prefer that wait?
            I already have implicit wait in my Driver class,
            but I prefer explicit wait when I need to use an expected condition such as element is not visible.

        How do you resolve synronization issue?
            I use implicit or explicit wait. In my driver class, I already have implicit wait,
            that handles most of the wait issues, but when it is not enough than I use explicit wait.

     */



    }


