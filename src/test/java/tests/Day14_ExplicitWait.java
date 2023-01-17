package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class Day14_ExplicitWait extends TestBase {

    /*
    Given
        Go to https://the-internet.herokuapp.com/dynamic_loading/1
    When
        User clicks on the "Start" button
    Then
        Assert the "Hello World!" Shows up on the screen
     */

    @Test
    public void explicitWaitTest(){

        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //User clicks on the "Start" button
        driver.findElement(By.xpath("//button")).click();

        //Assert the "Hello World!" Shows up on the screen
//        String helloWorldText=driver.findElement(By.xpath("//h4[.='Hello World!']")).getText();
//        Assert.assertEquals("Hello World!", helloWorldText);

        //Implicit Wait could not handle the waiting issue. We will try Explicit Wait.
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));--->in testBase class

        //1.step: Create webdriver wait object
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        //2.step: Use wait object to handle the waiting issue(synchronization)
       WebElement helloWorld= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h4[.='Hello World!']")));
        Assert.assertEquals("Hello World!", helloWorld.getText());

    }

    @Test
    public void explicitWaitTestReusable(){
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");

        //User clicks on the "Start" button
        driver.findElement(By.xpath("//button")).click();

        //Assert the "Hello World!" Shows up on the screen
      WebElement helloWorld=  driver.findElement(By.xpath("//h4[.='Hello World!']"));
       String helloWordString= waitForVisibility((By) helloWorld, 15).getText();
       Assert.assertEquals("Hello World!", helloWordString);
    }
}
