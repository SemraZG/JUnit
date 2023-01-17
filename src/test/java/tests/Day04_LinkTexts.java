package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static org.junit.Assert.*;

public class Day04_LinkTexts {
    WebDriver driver;

    @Before
    public void setUp(){

        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @Test
    public void LMSPage(){
        driver.get("https://www.techproeducation.com");
        //Click on LMS LOGIN
        //LMS LOGIN is a link
        //Text of that link is LMS LOGIN
        driver.findElement(By.linkText("LMS LOGIN")).click();

        //Verify lms page is visible
        String expectedURL="https://lms.techproeducation.com/";
        String actualURL=driver.getCurrentUrl();
        assertEquals("LMS LOGIN PAGE IS NOT DISPLAYED", expectedURL, actualURL);//first parameter is just for message.
        //message only be visible if assertion fails: LMS LOGIN PAGE IS NOT DISPLAYED
    }

    @Test
    public void LMSPagePartialLinkText(){
        driver.get("https://www.techproeducation.com");
        driver.findElement(By.partialLinkText("LMS L")).click();

        //partialLinkText and LinkText are case sensitive

        //alternatively we can locate a core element on lms page and check ıf that element is displayed on page
        WebElement loginElement=driver.findElement(By.linkText("Login/Register"));
        assertTrue(loginElement.isDisplayed());
        //isDisplayed() method returns true is element is on the page, returns false is element is not in the page
        //or
        assertTrue(driver.findElement(By.linkText("Login/Register")).isDisplayed());
    }
}
